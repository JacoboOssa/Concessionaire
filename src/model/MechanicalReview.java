package model;

public class MechanicalReview extends Document{
	private double releasedGases;

	public MechanicalReview(double price,String year, double releasedGases){
		super(price,year);
		this.releasedGases = releasedGases;
	}
}