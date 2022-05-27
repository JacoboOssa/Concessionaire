package model;

public class Gasoline extends Car implements Consume{
	private double capacity;
	private String typeGasoline;


	public Gasoline(String numMotor, double basePrice,double salePrice, String mark, int model, double cylinder, double mileage,String type, String plate,  
		String typeVh, String numDoor, String polarized, double capacity, String typeGasoline, Soat soat, MechanicalReview mReview,String propertyCard){
		super(numMotor, basePrice,salePrice,mark,model,cylinder,mileage,type,plate,typeVh,numDoor,polarized,soat,mReview,propertyCard);
		this.capacity = capacity;		
		this.typeGasoline = typeGasoline;
	}

	@Override
	public double calculateConsumeGasoline(double capacity,double cylinder){
		double consumeGasoline = 0;
		consumeGasoline += capacity * (cylinder/150);
		return consumeGasoline;
	}

	@Override 
	public double calculateConsumeBattery(double cylinder,double batteryDuration){
		int out = 0;
		return out;
	}

	public String toString(){
		double consumeG = calculateConsumeGasoline(capacity,cylinder);
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
		polarized + "\n" +
		"Tank Capacity: " + capacity + "\n" +
		"Gasoline Type: " + typeGasoline + "\n" +
		"Gasoline consumption: " + consumeG;
	}

	public String getTypeVh(){
		return typeVh;
	}
}