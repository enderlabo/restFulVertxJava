package com.dataWorld.backend.Api.Model;

public class CountryLanguageModel {

    public String CountryCode;

    public String Language;

    public String IsOfficial;

    public Double Percentage;

    public CountryLanguageModel() {}

    public CountryLanguageModel(String CountryCode, String Language, String IsOfficial, Double Percentage ) {

        this.CountryCode = CountryCode;
        this.Language = Language;
        this.IsOfficial = IsOfficial;
        this.Percentage = Percentage;
    }
}
