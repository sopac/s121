import geoscript.feature.Feature
import geoscript.feature.Field
import geoscript.feature.Schema
import geoscript.layer.*
import geoscript.layer.Shapefile
import geoscript.layer.io.GeoJSONWriter
import geoscript.layer.io.GmlWriter
import geoscript.layer.io.KmlWriter
import geoscript.layer.io.Writers
import geoscript.proj.Projection
import groovy.io.FileType

public class Main {

    public static void main(String[] args) {
        println "Sachindra Singh @ " + new Date()
        def m = new Main()
        String folder = "/home/sachin/Projects/FFA_Data_Sachin/"
        //m.process(folder)
        //m.fields(folder)
        m.test()
        //m.testGML()
        //Writers.list().each {println it.getClass().name}
        println "Finished."
    }

    public void testGML() {
        def shp = new Shapefile("/home/sachin/tmp/WORLD_BORDERS.shp")
        shp.setProj(new Projection("EPSG:4326"))
        GmlWriter writer = new GmlWriter()
        //writer.write(shp, new File("/home/sachin/world.gml"))
        println writer.write(shp, 3.2, true, true, true, "http://www.opengis.net/gml/3.2")
        //Layer l = (Layer) shp
        //println writer.write(shp)
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
        fields.add(new Field("sachin", "String"))
        Schema schema = new Schema(shp.getName() + "_NEW", fields) //filename, original fields

        //output layer // ----> create GML layer here to counter 10 character shp attribute length limit
        //Layer layer = shp.workspace.create(schema)
        Layer layer = new Layer(shp.getName() + "_NEW", schema)
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

        //update new added fields
        layer.features.each { f ->
            f.set("sachin", "hello")
        }



        layer.update()

        //output GML
        new File("/home/sachin/world.geojson").delete()
        GeoJSONWriter writer = new GeoJSONWriter()
        writer.write(layer, new File("/home/sachin/world.geojson"))

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


    public void process(String folder) { //act on output folder above
        try {
            new File(folder).eachFile(FileType.FILES) { f ->
                if (f.getName().toLowerCase().endsWith(".shp")) {
                    //println f.getName()

                    def shp = new Shapefile(f.toString())
                    def schema = shp.getSchema()
                    println schema.toString()
                    def ns = schema.addField(new Field("sachin_test", "String"), schema.getName())
                    shp.getFeatures().add()
                    shp.setSchema(ns)
                    shp.update()
                    //println shp.count()
                    //shp.getFeatures().each { ft ->
                    //println ft.getAttributes().keySet()
                    //}

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace()
        }
    }

}


