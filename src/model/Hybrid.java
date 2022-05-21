package model;

public class Hybrid extends Car implements Consume{
	private double capacity;
	private String typeGasoline;
	private String chargertype;
	private double batteryDuration;
	
	
	public Hybrid(double basePrice,double salePrice, String mark, int model, double cylinder, double mileage,String type, String plate, 
		String propertyCard, String typeVh, String numDoor, String polarized,double capacity, String typeGasoline, String chargertype,
		double batteryDuration){
		super(basePrice,salePrice,mark,model,cylinder,mileage,type,plate,propertyCard,typeVh,numDoor,polarized);
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
		"Tipo de cargador: " + chargertype + "\n" +
		"Duracion de bateria: " + batteryDuration + "\n" + 
		"Consumo de Gasolina: " + consumeG + "\n" +
		"Consumo de Bateria: " + consumeB ;
	}


}