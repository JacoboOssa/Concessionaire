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
		return "Numero de motor (ID) " + numMotor+ "\n" +
		"Tarjeta de propiedad: " + propertyCard + "\n" +
		"Precio base: " + basePrice + "\n" +
		"Precio de venta: " + salePrice + "\n" +
		"Marca: " + mark + "\n" +
		"Modelo: " + model + "\n" + 
		"Cilindraje: " + cylinder + "\n" +
		"Kilometraje: " + mileage + "\n" +
		"Tipo (Nuevo o Usado): " + type + "\n" +
		"Placa: " + plate + "\n" +
		"Tipo de Vehiculo (Sedan o Camioneta): " + typeVh + "\n" +
		"Numero de puertas: " + numDoor + "\n" +
		polarized + "\n" + 
		"Tipo de cargador: " + chargertype + "\n" +
		"Duracion de bateria: " + batteryDuration + "\n" + 
		"Consumo de bateria: " + consumeB + "\n ";
	}
}