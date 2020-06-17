package com.example.covid_19.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("Countries")
	private List<CountriesItem> countries;

	@SerializedName("Global")
	private Global global;

	@SerializedName("Date")
	private String date;

	public void setCountries(List<CountriesItem> countries){
		this.countries = countries;
	}

	public List<CountriesItem> getCountries(){
		return countries;
	}

	public void setGlobal(Global global){
		this.global = global;
	}

	public Global getGlobal(){
		return global;
	}

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"countries = '" + countries + '\'' + 
			",global = '" + global + '\'' + 
			",date = '" + date + '\'' + 
			"}";
		}
}