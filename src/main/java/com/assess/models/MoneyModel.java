package com.assess.models;

public class MoneyModel {
	private int penny;
	private int nickel;
	private int dime;
	private int quarter;
	
	public MoneyModel() {
	}
	
	
	public MoneyModel(int penny, int nickel, int dime, int quarter) {
		this.penny = penny;
		this.nickel = nickel;
		this.dime = dime;
		this.quarter = quarter;
	}



	public void add(MoneyModel money) {
		this.penny += money.getPenny();
		this.nickel += money.getNickel();
		this.dime += money.getDime();
		this.quarter += money.getQuarter();
	}
	
	public void deduct(MoneyModel money) {
		this.penny -= money.getPenny();
		this.nickel -= money.getNickel();
		this.dime -= money.getDime();
		this.quarter -= money.getQuarter();
	}
	
	public void clear() {
		this.penny = 0;
		this.nickel = 0;
		this.dime = 0;
		this.quarter = 0;
	}
	
	public double value() {
		return this.penny * 0.1 + 
				this.nickel * 0.05 + 
				this.dime * 0.1 + 
				this.quarter * 0.25;
	}
	
	// Accessor 
	public int getPenny() {
		return penny;
	}
	public void setPenny(int penny) {
		this.penny = penny;
	}
	public int getNickel() {
		return nickel;
	}
	public void setNickel(int nickel) {
		this.nickel = nickel;
	}
	public int getDime() {
		return dime;
	}
	public void setDime(int dime) {
		this.dime = dime;
	}
	public int getQuarter() {
		return quarter;
	}
	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}
}
