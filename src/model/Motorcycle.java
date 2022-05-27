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
		"Tipo de moto: " + typeM + "\n" +
		"Capacidad del tanque: " + capacity + "\n" +
		"Consumo de Gasolina: " +consumeG;
	}
}