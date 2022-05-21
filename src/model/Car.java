package model;

public class Car extends Vehicule{

	protected String typeVh;
	protected String numDoor;
	protected String polarized;

	public Car(double basePrice,double salePrice, String mark, int model, double cylinder, double mileage,String type, String plate, String propertyCard,String typeVh,String numDoor,String polarized){
		super(basePrice,salePrice,mark,model,cylinder,mileage,type,plate,propertyCard);
		this.typeVh = typeVh;
		this.numDoor = numDoor;
		this.polarized = polarized;
	}
	
}