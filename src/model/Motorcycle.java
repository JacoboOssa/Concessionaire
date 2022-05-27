package model;

public class Motorcycle extends Vehicule implements Consume{
	private String typeM;
	private double capacity;
	
	public Motorcycle(String numMotor, double basePrice,double salePrice, String mark, int model, double cylinder, 
		double mileage,String type, String plate,String typeM,double capacity,Soat soat,MechanicalReview mReview,String propertyCard){
		super(numMotor, basePrice,salePrice,mark,model,cylinder,mileage,type,plate,soat,mReview,propertyCard);
		this.type = typeM;
		this.capacity = capacity;
	}

	@Override
	public double calculateConsumeGasoline(double capacity,double cylinder){
		double consumeGasoline = 0;
		consumeGasoline += capacity * (cylinder/75);
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
		"Motorcycle type: " + typeM + "\n" +
		"Tank Capacity: " + capacity + "\n" +
		"Gasoline consume: " + consumeG;
	}
}