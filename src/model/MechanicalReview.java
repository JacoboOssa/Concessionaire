package model;

public class MechanicalReview extends Document{
	private double releasedGases;

	public MechanicalReview(double price,int year,String image, double releasedGases){
		super(price,year,image);
		this.releasedGases = releasedGases;
	}


	public double getPrice(){
		return price;
	}
	public void setPrice(double price){
		this.price = price;
	}

	public int getYear(){
		return year;
	}
	public void setYear(int year){
		this.year = year;
	}

	public String getImage(){
		return image;
	}
	public void setImage(String image){
		this.image = image;
	}

	public int getReleasedGases(){
		return year;
	}
	public void setReleasedGases(double releasedGases){
		this.releasedGases = releasedGases;
	}



	public String toString(){
		return "Price: " + price + "\n" +
		"Year: " + year + "\n" +
		"Code: " + image + "\n" +
		"Emitted gas levels: " + releasedGases;
	}
}