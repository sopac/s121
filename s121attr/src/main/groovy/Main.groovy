import geoscript.feature.Field
import geoscript.feature.Schema
import geoscript.layer.*
import geoscript.layer.Shapefile
import geoscript.layer.io.GeoJSONWriter
import geoscript.proj.Projection
import groovy.io.FileType
import org.sopac.Profiles

public class Main {

    public static void main(String[] args) {
        println "S121 Attribution Library @ " + new Date()
        def m = new Main()
        String folder = "/home/sachin/Projects/maritime_boundaries_FFA_0_360/members/"
        String output = "/home/sachin/tmp/"
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


    public void process(String folder, String outputFolder, String profile, boolean deleteExisiting) {
        try {
            new File(folder).eachFile(FileType.FILES) { f ->
                if (f.getName().toLowerCase().endsWith(".shp")) {
                    String fn = f.getName().toUpperCase()
                    //if fn contains profileCategoryBaseline add baseline attrs
                    //if fn contains profileCategoryLimits add limits attrs
                    //else add boundaries

                    //update attr:
                    //profileCategory Long form
                    //nation, nation
                    //objectname - filename trunc
                    //copy latlong ddms etc.

                    //output to outputFolder

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace()
        }
    }

}


