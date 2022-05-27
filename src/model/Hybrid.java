package model;

public class Hybrid extends Car implements Consume{
	private double capacity;
	private String typeGasoline;
	private String chargertype;
	private double batteryDuration;
	
	
	public Hybrid(String numMotor, double basePrice,double salePrice, String mark, int model, double cylinder, double mileage,String type, String plate, 
		String typeVh, String numDoor, String polarized,double capacity, String typeGasoline, String chargertype,
		double batteryDuration, Soat soat, MechanicalReview mReview,String propertyCard){
		super(numMotor,basePrice,salePrice,mark,model,cylinder,mileage,type,plate,typeVh,numDoor,polarized,soat,mReview,propertyCard);
		this.capacity = capacity;
		this.typeGasoline = typeGasoline;
		this.chargertype = chargertype;
		this.batteryDuration = batteryDuration;
	}
	@Override
	public double calculateConsumeGasoline(double capacity,double cylinder){
		double consumeGasoline = 0;
		consumeGasoline += capacity * (cylinder/180);
		return consumeGasoline;
	}

	@Override
	public double calculateConsumeBattery(double cylinder,double batteryDuration){
		double consumeBattery = 0;
		if (chargertype.equals("Rapido")) {
			consumeBattery = batteryDuration* (cylinder/200);
		} else if (chargertype.equals("Normal")){
			consumeBattery =  (batteryDuration + 7) * (cylinder/200);		
		}

		return consumeBattery;
	}

	public String toString(){
		double consumeG = calculateConsumeGasoline(capacity,cylinder);
		double consumeB = calculateConsumeBattery (cylinder,batteryDuration);
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
		"Charger Type: " + chargertype + "\n" +
		"Battery life: " + batteryDuration + "\n" + 
		"Gasoline consumption:" + consumeG + "\n" +
		"Battery Consumption:" + consumeB + "\n";
	}


}