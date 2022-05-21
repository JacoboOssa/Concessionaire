package model;

public class Soat extends Document{
	private double coverageAmount;

	public Soat(double price, String year, double coverageAmount){
		super(price,year);
		this.coverageAmount = coverageAmount;
	}

}