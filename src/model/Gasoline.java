package model;

public class Gasoline extends Car implements Consume{
	private double capacity;
	private String typeGasoline;


	public Gasoline(double basePrice,double salePrice, String mark, int model, double cylinder, double mileage,String type, String plate, String propertyCard, String typeVh, String numDoor, String polarized, double capacity, String typeGasoline){
		super(basePrice,salePrice,mark,model,cylinder,mileage,type,plate,propertyCard,typeVh,numDoor,polarized);
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
		return "\n Precio base: " + basePrice + "\n" +
		"Precio de venta: " + salePrice + "\n" +
		"Marca: " + mark + "\n" +
		"Modelo: " + model + "\n" + 
		"Cilindraje: " + cylinder + "\n" +
		"Kilometraje: " + mileage + "\n" +
		"Tipo (Nuevo o Usado): " + type + "\n" +
		"Placa: " + plate + "\n" +
		"Tarjeta de propiedad: " + propertyCard + "\n" +
		"Tipo de Vehiculo (Sedan o Camioneta): " + typeVh + "\n" +
		"Numero de puertas: " + numDoor + "\n" +
		polarized + "\n" + 
		"Capacidad del tanque: " + capacity + "\n" +
		"Tipo de Gasolina: " + typeGasoline + "\n" + 
		"Consumo de Gasolina: " +consumeG;
	}

	public String getTypeVh(){
		return typeVh;
	}
}