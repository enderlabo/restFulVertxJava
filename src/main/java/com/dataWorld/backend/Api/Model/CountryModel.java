package com.dataWorld.backend.Api.Model;

public class CountryModel {

    public String Code;

    public String Name;

    public String Continent;

    public String Region;

    public Double SurfaceArea;

    public Integer IndepYear;

    public Integer Population;

    public Double LifeExpectancy;

    public Double GNP;

    public  Double GNPOld;

    public String LocalName;

    public String GovernmentForm;

    public String HeadOfState;

    public Integer Capital;

    public String Code2;

    public CountryModel(){}

    public CountryModel(String Code, String Name, String Continent, String Region, Double SurfaceArea, int IndepYear,
                        int Population, Double LifeExpectancy, Double GNP, Double GNPOld, String LocalName, String GovernmentForm,
                        String HeadOfState, Integer Capital, String Code2 ) {

        this.Code = Code;
        this.Name = Name;
        this.Continent = Continent;
        this.Region = Region;
        this.SurfaceArea = SurfaceArea;
        this.IndepYear = IndepYear;
        this.Population = Population;
        this.LifeExpectancy = LifeExpectancy;
        this.GNP = GNP;
        this.GNPOld = GNPOld;
        this.LocalName = LocalName;
        this.GovernmentForm = GovernmentForm;
        this.HeadOfState = HeadOfState;
        this.Capital = Capital;
        this.Code2 = Code2;

    }
}
