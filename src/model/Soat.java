package model;

public class Soat extends Document{
	private double coverageAmount;

	public Soat(double price, int year, String image, double coverageAmount){
		super(price,year,image);
		this.coverageAmount = coverageAmount;
	}

	public int getYear(){
		return year;
	}

	public String toString(){
		return "Precio: " + price + "\n" +
		"Año: " + year + "\n" +
		"Codigo: " + image + "\n" +
		"Monto De Cobertura: " + coverageAmount;
	}

}