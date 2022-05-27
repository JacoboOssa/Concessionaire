package model;

public class MechanicalReview extends Document{
	private double releasedGases;

	public MechanicalReview(double price,int year,String image, double releasedGases){
		super(price,year,image);
		this.releasedGases = releasedGases;
	}

	public int getYear(){
		return year;
	}

	public String toString(){
		return "Precio: " + price + "\n" +
		"Año: " + year + "\n" +
		"Codigo: " + image + "\n" +
		"Niveles de gases arrojados: " + releasedGases;
	}
}