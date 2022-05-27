package model;

public class Car extends Vehicule{

	protected String typeVh;
	protected String numDoor;
	protected String polarized;

	public Car(String numMotor, double basePrice,double salePrice, String mark, int model, double cylinder, double mileage,String type, String plate,String typeVh,String numDoor,String polarized,
		Soat soat, MechanicalReview mReview,String propertyCard){
		super(numMotor,basePrice,salePrice,mark,model,cylinder,mileage,type,plate,soat,mReview,propertyCard);
		this.typeVh = typeVh;
		this.numDoor = numDoor;
		this.polarized = polarized;
	}

	public String toString(){
		return "Engine number (ID) " + numMotor+ "\n" +
		"Property card:" + propertyCard + "\n" +
		"Base price: " + basePrice + "\n" +
		"Sale price:" + salePrice + "\n" +
		"Brand: " + mark + "\n" +
		"Model: " + model + "\n" + 
		"Cylinder capacity: " + cylinder + "\n" +
		"Mileage: " + mileage + "\n" +
		"Type (New or Used): " + type + "\n" +
		"License plate: " + plate + "\n" +
		"Vehicle Type (Sedan or Truck): " + typeVh + "\n" +
		"Number of doors: " + numDoor + "\n" +
		polarized;
	}
	
}