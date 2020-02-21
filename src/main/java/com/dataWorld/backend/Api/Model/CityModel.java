package com.dataWorld.backend.Api.Model;

public class CityModel {

    public Integer Id;

    public String Name;

    public String CountryCode;

    public String District;

    public Integer Population;

public CityModel() {}

public CityModel(int Id, String Name, String CountryCode, String District, Integer Population ) {

    this.Id = Id;
    this.Name = Name;
    this.CountryCode = CountryCode;
    this.District = District;
    this.Population = Population;
    }
}
