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
		"Capacidad del tanque: " + capacity + "\n" +
		"Tipo de Gasolina: " + typeGasoline + "\n" + 
		"Consumo de Gasolina: " +consumeG + "\n";
	}

	public String getTypeVh(){
		return typeVh;
	}
}