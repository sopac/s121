package org.sopac

import geoscript.feature.Field
import geoscript.feature.Schema
import geoscript.layer.*
import geoscript.layer.Shapefile
import geoscript.layer.io.GeoJSONWriter
import geoscript.proj.Projection
import groovy.io.FileType
import org.apache.commons.io.FileUtils

public class Attrib {

    public static void main(String[] args) {
        println "S121 Attribution Library @ " + new Date()
        def m = new Attrib()
        //String folder = "/home/sachin/Projects/maritime_boundaries_FFA_0_360/members/"
        String folder = "/home/sachin/Projects/maritime_boundaries_FFA_0_360/SPC_PROJECT_MEMBER_COUNTRIES/"
        String output = "/home/sachin/tmp/out/"
        m.process(folder, output, "Autodetect", false)
        //m.fields(folder)
        //m.test()
        //Writers.list().each {println it.getClass().name}
        println "Finished."
    }


    public void test() {
        def shp = new Shapefile("/home/sachin/tmp/WORLD_BORDERS.shp")
        List fields = shp.schema.fields
        println fields
        //modify old fields
        fields.each { fld ->
            Field f = fld
            f.name = f.name.toLowerCase()
        }
        //add new fields
        //fields.add(new Field("sachin", "String"))
        //fields.add(new Field("fili", "String"))

        def profiles = new Profiles()
        profiles.baseline.forEach { attr ->
            fields.add(new Field(attr, "String"))
        }

        //Schema schema = new Schema(shp.getName() + "_NEW", fields) //filename, original fields
        Schema schema = new Schema(shp.getName(), fields)

        //output layer // ----> create GML layer here to counter 10 character shp attribute length limit
        //Layer layer = shp.workspace.create(schema)
        Layer layer = new Layer(shp.getName(), schema)
        layer.setProj(new Projection("EPSG:4326"))

        // Copy all features to the new Layer
        layer.add(shp.features.collect { f ->
            Map attributes = [:]
            f.attributes.each { k, v ->
                //re-reflect modifications in field name above
                k = k.toString().toLowerCase()
                //modify attributes (v) here
                v = v.toString()
                attributes[k] = v
            }
            schema.feature(attributes, f.id)
        })

        //update newly added fields
        layer.features.each { f ->
            //f.set("sachin", "hello")
            //f.set("fili", "")
            profiles.baseline.forEach { attr ->
                f.set(attr, "")
            }
        }

        layer.update()

        //output geojson
        new File("/home/sachin/tmp/world.geojson").delete()
        GeoJSONWriter writer = new GeoJSONWriter()
        writer.write(layer, new File("/home/sachin/tmp/world.geojson"))

        //layer.toGMLFile(new File("/home/sachin/AU_ID_EEZ_LINE_TREATY.gml"))
        //GmlWriter writer = new GmlWriter()
        //writer.write(layer, new File("/home/sachin/AU_ID_EEZ_LINE_TREATY.gml"), 2, true, true, true, "")
        //String gml = writer.write(layer, 3.2, true, true, true, "http://www.opengis.net/gml")
        //new File("/home/sachin/world.gml").write(gml)
        //println gml

    }


    public void move(String folder) {
        //copy files from subfolders to output folder
    }

    public void fields(String folder) {
        def list = []
        new File(folder).eachFile(FileType.FILES) { f ->
            if (f.getName().toLowerCase().endsWith(".shp")) {
                def shp = new Shapefile(f.toString())
                def schema = shp.getSchema()
                println "\r\n" + shp.name
                println "======================"
                schema.fields.each { fld ->
                    println fld.name
                    list << fld.name.toUpperCase()
                }
            }
        }
        println "\r\n\r\n"
        list = list.unique().sort()
        list.each { println it }

    }


    public int process(String folder, String outputFolder, String profile, boolean deleteExisiting) {
        int count = 0
        try {
            if (!new File(outputFolder).exists()) new File(outputFolder).mkdir()
            //find all files recursively in target subfolders and move to user.tmp
            String tmpFolder = System.getProperty("java.io.tmpdir") + "/s121out/"
            new File(tmpFolder).deleteDir()
            new File(tmpFolder).mkdir()
            FileUtils.iterateFiles(new File(folder), null, true).forEachRemaining { tf ->
                FileUtils.copyFileToDirectory(tf, new File(tmpFolder))

            }


            Profiles p = new Profiles()
            new File(tmpFolder).eachFile(FileType.FILES) { f ->
                if (f.getName().toLowerCase().endsWith(".shp")) {
                    String fn = f.getName().toUpperCase().replace(".SHP", "").trim()

                    //if fn contains profileCategoryBaseline add baseline attrs
                    //if fn contains profileCategoryLimits add limits attrs
                    //else add boundaries
                    boolean baseline = false
                    boolean limits = false
                    boolean boundaries = false

                    String categoryDescription = ""
                    p.profileCategoryBaseline.each { c ->
                        if (fn.contains(c)) {
                            baseline = true
                            categoryDescription = c + " " + p.categories.get(c)
                        }
                    }
                    p.profileCategoryLimits.each { c ->
                        if (fn.contains(c)) {
                            limits = true
                            categoryDescription = c + " " + p.categories.get(c)
                        }
                    }
                    if (!baseline && !limits) {
                        boundaries = true
                        categoryDescription = "Delimitation"
                    }
                    println fn + " [Baseline: " + baseline + ", Limits: " + limits + ", Boundaries: " + boundaries + "]"
                    println categoryDescription

                    def shp = new Shapefile(f)
                    List fields = shp.schema.fields

                    //modify existing fields
                    fields.each { fld ->
                        Field f1 = fld
                        f1.name = f1.name.toLowerCase()
                    }

                    def attrList = []
                    //add profile attributes
                    if (baseline) {
                        p.baseline.forEach { attr ->
                            fields.add(new Field(attr, "String"))
                        }
                        attrList = p.baseline
                    }
                    if (limits) {
                        p.limits.forEach { attr ->
                            fields.add(new Field(attr, "String"))
                        }
                        attrList = p.limits
                    }
                    if (boundaries) {
                        p.boundaries.forEach { attr ->
                            fields.add(new Field(attr, "String"))
                        }
                        attrList = p.boundaries
                    }

                    //output layer ----> create GeoJson layer to counter 10 character shp attribute length limit
                    Schema schema = new Schema(shp.getName(), fields)
                    Layer layer = new Layer(shp.getName(), schema)
                    layer.setProj(new Projection("EPSG:4326"))

                    //copy all features to the new Layer
                    layer.add(shp.features.collect { ft ->
                        Map attributes = [:]
                        ft.attributes.each { k, v ->
                            //re-reflect modifications in field name above
                            k = k.toString().toLowerCase()
                            //modify attributes (v) here
                            v = v.toString()
                            attributes[k] = v
                        }
                        schema.feature(attributes, ft.id)
                    })

                    //update newly added fields
                    //update attr:
                    //profileCategory Long form
                    //nation, nation
                    //objectname - filename trunc
                    //copy latlong ddms etc.
                    //output to outputFolder

                    String nation = ""
                    p.countries.keySet().each { c ->
                        if (fn.startsWith(c + "_")) nation = c + " " + p.countries.get(c)
                    }

                    layer.features.each { ft ->
                        attrList.each { attr ->
                            ft.set(attr, "")
                            if (attr.startsWith("Category of ")) ft.set(attr, categoryDescription)
                            if (attr.equals("Point Type")) ft.set(attr, "Defined")
                            if (attr.equals("Object Name")) ft.set(attr, fn.replaceAll("_-", "_").trim())
                            if (attr.equals("Nation")) ft.set(attr, nation)
                            if (attr.equals("National Object Name")) ft.set(attr, nation)
                            if (attr.equals("Intellectual Property Owner")) ft.set(attr, "SPC")
                            if (attr.equals("Legal Source")) ft.set(attr, "UNCLOS")
                            if (attr.equals("Licence")) ft.set(attr, "Public Domain")
                            if (attr.equals("Textual Description")) ft.set(attr, categoryDescription)


                        }
                    }

                    //output geojson
                    layer.update()
                    String of = outputFolder + fn + ".geojson"
                    new File(of).delete()
                    GeoJSONWriter writer = new GeoJSONWriter()
                    writer.write(layer, new File(of))

                    count++
                }
            }
            return count;
        } catch (Exception ex) {
            ex.printStackTrace()
            return 0;
        }
    }

}


