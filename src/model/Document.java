package model;
import java.util.Random;

public class Document{

	protected double price;
	protected int year;
	protected String image;

	public Document(double price,int year,String image){
		this.price = price;
		this.year = year;
		this.image = image;
	}

}