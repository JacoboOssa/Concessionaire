package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Controller{
	private String init;
	private ArrayList<Vehicule> vehicule;

	public Controller(String init){
		vehicule = new ArrayList<Vehicule>();
		this.init = init;

	}

	public String addMotorcycle(double basePrice,double salePrice, String mark, int model, double cylinder, double mileage,String type, String plate, String propertyCard,String typeM,double capacity){
		String out =  "";
		vehicule.add(new Motorcycle(basePrice,salePrice,mark,model,cylinder,mileage,type,plate,propertyCard,typeM,capacity));
		out += "Registro de moto Exitoso";
		return out;
	}

	public String addGasolineCar(double basePrice,double salePrice, String mark, int model, double cylinder, double mileage,String type, String plate, String propertyCard, String typeVh, String numDoor, String polarized, double capacity, String typeGasoline){
		String out = "";
		vehicule.add(new Gasoline(basePrice,salePrice,mark,model,cylinder,mileage,type,plate,propertyCard,typeVh,numDoor,polarized,capacity,typeGasoline));
		out += "Registro de carro a Gasolina exitoso";
		return out;

	}

	public String addElectricCar(double basePrice,double salePrice, String mark, int model, double cylinder, double mileage,String type, String plate, String propertyCard, String typeVh, String numDoor, String polarized,String chargertype, double batteryDuration){
		String out = "";	
		vehicule.add(new Electric(basePrice,salePrice,mark,model,cylinder,mileage,type,plate,propertyCard,typeVh,numDoor,polarized,chargertype,batteryDuration));
		out += "Registro de carro Electrico exitoso";
		return out;
	}

	public String addHybridCar(double basePrice,double salePrice, String mark, int model, double cylinder, double mileage,String type, String plate, String propertyCard, String typeVh, String numDoor, String polarized,double capacity, String typeGasoline,String chargertype,double batteryDuration){
		String out = "";
		vehicule.add(new Hybrid(basePrice,salePrice,mark,model,cylinder,mileage,type,plate,propertyCard,typeVh,numDoor,polarized,capacity,typeGasoline,chargertype,batteryDuration));
		out += "Registro de carro Hibrido exitoso";
		return out;
	}

	public String addSoatToVehicule(double price, String year, double coverageAmmount){
		String out = "";
        Soat soat = new Soat(price, year, coverageAmmount);
        vehicule.addSoat(soat);
        out += "Registro exitoso de numero de Soat";
	}



	public String showVehicules(){
		String out = "";
		for (int i=0;i<vehicule.size();i++){
			out += vehicule.get(i).toString();
		}
		return out;
	}

}