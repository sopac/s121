package org.sopac
/**
 * Created by sachin on 5/2/16.
 */
public class Profiles {

    def baseline = []

    def limits = []

    def boundaries = []

    def countries = [:]

    def categories =[:]

    def profileCategoryBaseline = []

    def profileCategoryLimits = []

    def profileCategoryBoundary = []


    public Profiles(){
        //baseline
        baseline << "Object Name"
        baseline << "Nation"
        baseline << "Category of Baseline" //1: Normal baseline 2: Straight baseline 3: Archipelagic baseline 4: River closing line 5: Bay closing line
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

        //countries
        countries.put("AS", "American Samoa")
        countries.put("CK", "Cook Islands")
        countries.put("AU", "Australia")
        countries.put("FR", "France")
        countries.put("ID", "Indonesia")
        countries.put("GU", "Guam")
        countries.put("NC", "New Caledonia")
        countries.put("PF", "French Polynesia")
        countries.put("TK", "Tokelau")
        countries.put("NZ", "New Zealand")
        countries.put("US", "United States")
        countries.put("WF", "Wallis and Fatuna")
        countries.put("FJ", "Fiji Islands")
        countries.put("KI", "Kiribati")
        countries.put("MH", "Marshall Islands")
        countries.put("NR", "Nauru")
        countries.put("NU", "Niue")
        countries.put("PG", "Papua New Guinea")
        countries.put("PW", "Palau")
        countries.put("SB", "Solomon Islands")
        countries.put("TV", "Tuvalu")
        countries.put("VU", "Vanuatu")

        //categories
        categories.put("NBL", "Normal Baseline")
        categories.put("SBL", "Straight Baseline")
        categories.put("ASB", "Archipelagic Baseline")
        categories.put("RCL", "River Closing Line")
        categories.put("BCL", "Bay Closing Line")
        categories.put("TSB", "Territorial Sea Baseline")

        categories.put("IWZ", "Internal Water Zone")
        categories.put("AWZ", "Archipelagic Water Zone")
        categories.put("TSZ", "Territorial Sea Zone")
        categories.put("CZZ", "Contiguous Zone")
        categories.put("EEZ", "Exclusive Economic Zone")
        categories.put("CSZ", "Continental Shelf Zone")
        categories.put("HSZ", "High Seas Zone")

        //profileCategoryBaseline
        profileCategoryBaseline << "NBL"
        profileCategoryBaseline << "SBL"
        profileCategoryBaseline << "ASB"
        profileCategoryBaseline << "RCL"
        profileCategoryBaseline << "BCL"
        profileCategoryBaseline << "TSB"

        //profileCategoryLimits
        profileCategoryLimits << "IWZ"
        profileCategoryLimits << "AWZ"
        profileCategoryLimits << "TSZ"
        profileCategoryLimits << "CZZ"
        profileCategoryLimits << "EEZ"
        profileCategoryLimits << "CSZ"
        profileCategoryLimits << "HSZ"

/*
        Category of Baseline
        1: Normal baseline NBL 2: Straight baseline SBL 3: Archipelagic baseline ASB 4: River closing line  RCL 5: Bay closing line BCL

        Category of Maritime Zone or Limit
        1: internal waters IWZ 2:  archipelagic waters AWZ 3: territorial sea TSZ 4: contiguous zone CZZ 5: exclusive economic zone EEZ 6: continental shelf  CSZ 7 .HSZ - High Sea Zone

        Category of Boundary
        1: Delimitation
*/


    }



}
