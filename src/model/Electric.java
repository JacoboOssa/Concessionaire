package model;

public class Electric extends Car implements Consume{
	private String chargertype;
	private double batteryDuration;
	

	public Electric(String numMotor, double basePrice,double salePrice, String mark, int model, double cylinder, double mileage,String type, String plate,String typeVh, String numDoor, String polarized,String chargertype, double batteryDuration, Soat soat, 
		MechanicalReview mReview,String propertyCard){
		super(numMotor, basePrice,salePrice,mark,model,cylinder,mileage,type,plate,typeVh,numDoor,polarized,soat,mReview,propertyCard);
		this.chargertype = chargertype;
		this.batteryDuration = batteryDuration;
		
	}

	@Override
	public double calculateConsumeBattery(double cylinder,double batteryDuration){
		double consumeBattery = 0;
		if (chargertype.equals("Rapido")) {
			consumeBattery = (batteryDuration + 13) * (cylinder/100);
		} else if (chargertype.equals("Normal")){
			consumeBattery =  (batteryDuration + 18) * (cylinder/100);		
		}

		return consumeBattery;
	}


	@Override 
	public double calculateConsumeGasoline(double capacity,double cylinder){
		int out = 0;
		return out;
	}

	public String toString(){
		double consumeB = calculateConsumeBattery(cylinder,batteryDuration);
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
		"Charger Type: " + chargertype + "\n" +
		"Battery life: " + batteryDuration + "\n" +
		"Battery Consumption:" + consumeB;
	}
}