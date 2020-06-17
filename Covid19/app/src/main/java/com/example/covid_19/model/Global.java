package com.example.covid_19.model;

import com.google.gson.annotations.SerializedName;

public class Global{

	@SerializedName("NewRecovered")
	private int newRecovered;

	@SerializedName("NewDeaths")
	private int newDeaths;

	@SerializedName("TotalRecovered")
	private int totalRecovered;

	@SerializedName("TotalConfirmed")
	private int totalConfirmed;

	@SerializedName("NewConfirmed")
	private int newConfirmed;

	@SerializedName("TotalDeaths")
	private int totalDeaths;

	public void setNewRecovered(int newRecovered){
		this.newRecovered = newRecovered;
	}

	public int getNewRecovered(){
		return newRecovered;
	}

	public void setNewDeaths(int newDeaths){
		this.newDeaths = newDeaths;
	}

	public int getNewDeaths(){
		return newDeaths;
	}

	public void setTotalRecovered(int totalRecovered){
		this.totalRecovered = totalRecovered;
	}

	public int getTotalRecovered(){
		return totalRecovered;
	}

	public void setTotalConfirmed(int totalConfirmed){
		this.totalConfirmed = totalConfirmed;
	}

	public int getTotalConfirmed(){
		return totalConfirmed;
	}

	public void setNewConfirmed(int newConfirmed){
		this.newConfirmed = newConfirmed;
	}

	public int getNewConfirmed(){
		return newConfirmed;
	}

	public void setTotalDeaths(int totalDeaths){
		this.totalDeaths = totalDeaths;
	}

	public int getTotalDeaths(){
		return totalDeaths;
	}

	@Override
 	public String toString(){
		return 
			"Global{" + 
			"newRecovered = '" + newRecovered + '\'' + 
			",newDeaths = '" + newDeaths + '\'' + 
			",totalRecovered = '" + totalRecovered + '\'' + 
			",totalConfirmed = '" + totalConfirmed + '\'' + 
			",newConfirmed = '" + newConfirmed + '\'' + 
			",totalDeaths = '" + totalDeaths + '\'' + 
			"}";
		}
}