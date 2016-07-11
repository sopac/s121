package org.sopac
/**
 * Created by sachin on 5/2/16.
 */
public class Profiles {

    def baseline = []

    def limits = []

    def boundaries = []

    public Profiles(){
        //baseline
        baseline << "Object Name"
        baseline << "Nation"
        baseline << "Category of Baseline" //1: Normal baseline 2: Straight baseline 3: Archipelagic baseline 4: River closing line 5: Bay closing line
        baseline << "Object Name"
        baseline << "National Object Name"
        baseline << "Point Type"
        baseline << "Source Horizontal Reference System"
        baseline << "Source Latitude Degrees Minutes Seconds"
        baseline << "Source Latitude"
        baseline << "Source Longitude Degrees Minutes Seconds"
        baseline << "Source Longitude"
        baseline << "Published Horizontal Reference System"
        baseline << "Published Latitude"
        baseline << "Published Longitude"
        baseline << "Legal Source"
        baseline << "Intellectual Property Owner"
        baseline << "Licence"
        baseline << "Disclaimer"
        baseline << "Textual Description"
        baseline << "Registry Identifier"
        baseline << "Date"

        //limits
        limits << "Object Name"
        limits << "Nation"
        limits << "Category of Maritime Zone or Limit" //1: internal waters 2:  archipelagic waters 3: territorial sea 4: contiguous zone 5: exclusive economic zone 6: continental shelf
        limits << "Object Name"
        limits << "National Object Name"
        limits << "Point Type"
        limits << "Source Horizontal Reference System"
        limits << "Source Latitude Degrees Minutes Seconds"
        limits << "Source Latitude"
        limits << "Source Longitude Degrees Minutes Seconds"
        limits << "Source Longitude"
        limits << "Published Horizontal Reference System"
        limits << "Published Latitude"
        limits << "Published Longitude"
        limits << "Legal Source"
        limits << "Intellectual Property Owner"
        limits << "Licence"
        limits << "Disclaimer"
        limits << "Textual Description"
        limits << "Registry Identifier"
        limits << "Date"

        //boundaries
        boundaries << "Object Name"
        boundaries << "Nation"
        boundaries << "Category of Boundary" //1: Delimitation
        boundaries << "Object Name"
        boundaries << "National Object Name"
        boundaries << "States Party"
        boundaries << "Vertical Jurisdiction"
        boundaries << "Point Type"
        boundaries << "Source Horizontal Reference System"
        boundaries << "Source Latitude Degrees Minutes Seconds"
        boundaries << "Source Latitude"
        boundaries << "Source Longitude Degrees Minutes Seconds"
        boundaries << "Source Longitude"
        boundaries << "Published Horizontal Reference System"
        boundaries << "Published Latitude"
        boundaries << "Published Longitude"
        boundaries << "Legal Source"
        boundaries << "Intellectual Property Owner"
        boundaries << "Licence"
        boundaries << "Disclaimer"
        boundaries << "Textual Description"
        boundaries << "Registry Identifier"
        boundaries << "Date"
    }



}
