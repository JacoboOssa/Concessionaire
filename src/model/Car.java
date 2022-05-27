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
		return "\nPrecio base: " + basePrice + "\n" +
		"Precio de venta: " + salePrice + "\n" +
		"Marca: " + mark + "\n" +
		"Modelo: " + model + "\n" + 
		"Cilindraje: " + cylinder + "\n" +
		"Kilometraje: " + mileage + "\n" +
		"Tipo (Nuevo o Usado): " + type + "\n" +
		"Placa: " + plate + "\n" +
		"Tipo de Vehiculo (Sedan o Camioneta): " + typeVh + "\n" +
		"Numero de puertas: " + numDoor + "\n" +
		polarized + "\n";
	}
	
}