package model;

public class Vehicule{

	

	protected double basePrice;
	protected double salePrice;
	protected String mark;
	protected int model;
	protected double cylinder;
	protected double mileage;
	protected String type;
	protected String plate;	
	protected String propertyCard;
	public static final int MAX_DOCUMENT = 2;
	private Document [] carDocuments;


	public Vehicule(double basePrice,double salePrice, String mark, int model, double cylinder, double mileage,String type, String plate, String propertyCard){
		this.basePrice = basePrice;
		this.salePrice = salePrice;
		this.mark = mark;
		this.model = model;
		this.cylinder = cylinder;
		this.mileage = mileage;
		this.type = type;
		this.plate = plate;
		this.propertyCard = propertyCard;
		carDocuments = new Document[MAX_DOCUMENT];
	}

	public void addSoat(Soat dSoat){
		carDocuments[0] = dSoat;
	}
	public void addMechanicalReview(MechanicalReview dMechanicalR){
		carDocuments[1] = dMechanicalR;
	}
	

		
}