package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Controller{
	private String init;
	private ArrayList<Vehicule> vehicule;
	private int [][] dSoat = new int [4][4];
	private int [][] dMechanicalR = new int [4][4];
	private int [][] dPropertyC = new int [4][4];
	public static final int MAX_COLUMNAS = 5;
    public static final int MAX_FILAS = 10;
	private Vehicule [][] lotParking;
	private int [][] parking;



	public Controller(String init){
		vehicule = new ArrayList<Vehicule>();
		this.init = init;
		parking = new int[MAX_FILAS][MAX_COLUMNAS];
		lotParking = new Vehicule[MAX_FILAS][MAX_COLUMNAS];

	}

	public String addMotorcycle(String numMotor, double basePrice,double salePrice, String mark, int model, double cylinder, double mileage,String type, String plate ,String typeM,double capacity,
		double price,int year,String soatImage,double coverageAmount,double priceMR, int yearMR,String mechanicalImage, double releasedGases,String propertyCard){
		String out =  "";
		Soat newSoat = new Soat(price,year,soatImage,coverageAmount);
		MechanicalReview newMechanicalR = new MechanicalReview(priceMR,yearMR,mechanicalImage,releasedGases);
		vehicule.add(new Motorcycle(numMotor, basePrice,salePrice,mark,model,cylinder,mileage,type,plate,typeM,capacity,newSoat,newMechanicalR,propertyCard));
		out += "Registro de moto Exitoso";
		return out;
	}

	public String addGasolineCar(String numMotor, double basePrice,double salePrice, String mark, int model, double cylinder, double mileage,String type, String plate,String typeVh, String numDoor, String polarized, double capacity, String typeGasoline,
		double price,int year,String soatImage,double coverageAmount,double priceMR, int yearMR,String mechanicalImage,double releasedGases,String propertyCard){
		String out = "";
		Soat newSoat = new Soat(price,year,soatImage,coverageAmount);
		MechanicalReview newMechanicalR = new MechanicalReview(priceMR,yearMR,mechanicalImage,releasedGases);
		vehicule.add(new Gasoline(numMotor, basePrice,salePrice,mark,model,cylinder,mileage,type,plate,typeVh,numDoor,polarized,capacity,typeGasoline,newSoat,newMechanicalR,propertyCard));
		out += "Registro de carro a Gasolina exitoso";
		for (int i=0;i<MAX_FILAS;i++){
			for (int j=0;j<MAX_COLUMNAS;j++){
				parking[i][0] =1;
			}
			
		}
		return out;

	}

	public String addElectricCar(String numMotor, double basePrice,double salePrice, String mark, int model, double cylinder, double mileage,String type, String plate , String typeVh, String numDoor, String polarized,String chargertype, double batteryDuration,
		double price,int year,String soatImage,double coverageAmount,double priceMR, int yearMR,String mechanicalImage,double releasedGases,String propertyCard){
		String out = "";	
		Soat newSoat = new Soat(price,year,soatImage,coverageAmount);
		MechanicalReview newMechanicalR = new MechanicalReview(priceMR,yearMR,mechanicalImage,releasedGases);
		vehicule.add(new Electric(numMotor, basePrice,salePrice,mark,model,cylinder,mileage,type,plate,typeVh,numDoor,polarized,chargertype,batteryDuration,newSoat,newMechanicalR,propertyCard));
		out += "Registro de carro Electrico exitoso";
		return out;
	}

	public String addHybridCar(String numMotor, double basePrice,double salePrice, String mark, int model, double cylinder, double mileage,String type, String plate,String typeVh, String numDoor, String polarized,double capacity, String typeGasoline,String chargertype,double batteryDuration,
		double price,int year,String soatImage,double coverageAmount,double priceMR, int yearMR,String mechanicalImage,double releasedGases,String propertyCard){
		String out = "";
		Soat newSoat = new Soat(price,year,soatImage,coverageAmount);
		MechanicalReview newMechanicalR = new MechanicalReview(priceMR,yearMR,mechanicalImage,releasedGases);
		vehicule.add(new Hybrid(numMotor, basePrice,salePrice,mark,model,cylinder,mileage,type,plate,typeVh,numDoor,polarized,capacity,typeGasoline,chargertype,batteryDuration,newSoat,newMechanicalR,propertyCard));
		out += "Registro de carro Hibrido exitoso";
		return out;
	}


	public String generateSoatCode(){
		String out = "";

		for (int i=0;i<4;i++){
			for (int j=0;j<4;j++ ) {
				dSoat[i][j] = (int)(Math.random()*(10-1+1)+1);
			}		
		}

		for (int i=0;i<4;i++){
			out += dSoat[i][0];		
		}
		
		for (int j=0;j<4;j++){
			out += dSoat[3][j];	
		}	

		return out;
	}

	public String generateMechanicalCode(){
		String out = "";
		for (int i=0;i<4;i++){
			for (int j=0;j<4;j++){
				dMechanicalR[i][j] = (int)(Math.random()*(10-1+1)+1);	
			}
		}

		for (int j=0;j<4;j++){
				out += dMechanicalR[0][j];					
		}
		for (int i=1;i<3;i++){
			for (int j=2;j>0;j--){
				out += dMechanicalR[i][j];	
			}	
		}
		
		for (int j=0;j<4;j++){
			out += dMechanicalR[3][j];	
		}	

		return out;
	}

	public String generatePropertyCode(){
		String out = "";


		for (int i=0;i<4;i++){
			for (int j=0;j<4;j++){
				dPropertyC[i][j] = (int)(Math.random()*(10-1+1)+1);	
			}
		}

		for (int i=3;i>0;i--){
			for (int j=3;j>0;j--){
				int sum = i+j;

				if (sum%2==0) {
					out+= dPropertyC[i][j];	
				}
				
			}
		}

		return out;
	}

	public String generateReportCar(){
		String out = "";
		for (int i=0;i<vehicule.size();i++){
			if (vehicule.get(i) instanceof Car){
				out+= vehicule.get(i).toString();		
			}			
		}

		return out;
	}

	public String generateReportMotorcycle(){
		String out = "";

		for (int i=0;i<vehicule.size();i++){
			if (vehicule.get(i) instanceof Motorcycle){
				out+= vehicule.get(i).toString();
			}
		}

		return out;
	}

	public String generateReportGasoline(){
		String out = "";

		for (int i=0;i<vehicule.size();i++){
			if (vehicule.get(i) instanceof Gasoline){
				out+= vehicule.get(i).toString();
			}
		}

		return out;
	}

	public String generateReportElectric(){
		String out = "";

		for (int i=0;i<vehicule.size();i++){
			if (vehicule.get(i) instanceof Electric){
				out+= vehicule.get(i).toString();
			}
		}

		return out;
	}

	public String generateReportHybrid(){
		String out = "";

		for (int i=0;i<vehicule.size();i++){
			if (vehicule.get(i) instanceof Hybrid){
				out+= vehicule.get(i).toString();
			}
		}

		return out;
	}
	
	public String generateReportNew(){
		String out = "";
		String type = "";

		for (int i=0;i<vehicule.size();i++){
			if (vehicule.get(i) instanceof Vehicule){
				if(vehicule.get(i).getType().equalsIgnoreCase("Nuevo")){
					out+=(vehicule.get(i).toString());
				}
			}
		}

		return out;
	}
	public String generateReportUsed(){
		String out = "";
		String type = "";

		for (int i=0;i<vehicule.size();i++){
			if (vehicule.get(i) instanceof Vehicule){
				if(vehicule.get(i).getType().equalsIgnoreCase("Usado")){
					out+=(vehicule.get(i).toString());
				}
			}
		}
		return out;
	}

	public String documentsById(String id){
		String out ="";

		for (int i=0;i<vehicule.size();i++){
			if (vehicule.get(i).getNumMotor().equals(id)){
				if (vehicule.get(i).getPropertyCard() == null){
					out+= "No tiene tarjeta de propiedad";
				}else {
					out+= "El codigo de la tarjeta de propiedad es: " + vehicule.get(i).getPropertyCard() + "\n";			
				}
				
				if (vehicule.get(i).getSoatYear()==2022){
					out += "\nSOAT vigente" + "\n" +
					vehicule.get(i).getSoatInfo();	
				}else{
					out += "\nSOAT expirado" + "\n" + 
					vehicule.get(i).getSoatInfo();
				}

				if (vehicule.get(i).getMechanicalrYear()==2022){
					out += "\nRevision Tecnico-Mecanica vigente" + "\n" +
					vehicule.get(i).getMechanicalrInfo() + "\n";		
				}else{
					out += "\nRevision Tecnico-Mecanica expirada" + "\n" +
					vehicule.get(i).getMechanicalrInfo() + "\n";	
				}
			}	
		}

		return out;
	}

	public String createParkingLot(){

		String print ="";
		for (int i=0; i<MAX_FILAS; i++ ) { 
			for (int j = 0; j <MAX_COLUMNAS; j++) { 
				print += parking[i][j] + " ";
			}
			print += "\n";
		}
		return print;


    }

    
    public String createReportByYears(){
    	String out = "";
    	for (int i=0;i<vehicule.size();i++){

    		if (vehicule.get(i).getModel()==2014) {
    			out+= "Vehiculos 2014: \n" + 
    			vehicule.get(i).toString();
			}
			if (vehicule.get(i).getModel()==2013) {
    			out+= "Vehiculos 2013: \n" + 
    			vehicule.get(i).toString();
			}	
			if (vehicule.get(i).getModel()==2012) {
    			out+= "Vehiculos 2012: \n" + 
    			vehicule.get(i).toString();
			}	
			if (vehicule.get(i).getModel()==2011) {
    			out+= "Vehiculos 2011: \n" + 
    			vehicule.get(i).toString();
			}	
			if (vehicule.get(i).getModel()<2011) {
    			out+= "Vehiculos modelos menores a 2011: \n" + 
    			vehicule.get(i).toString();
			}		
    	}

    	return out;
    }

    public String createReportByModel(){
    	String out = "";
    	String oldest = "";
    	String newest = ""; 

    	for (int i=0;i<MAX_FILAS;i++){
    		for (int j=0;j<MAX_COLUMNAS;j++){
    			if (lotParking[i][j]!=null){


    				if (lotParking[i][j].getModel()==2014) {
    					newest = lotParking[i][j].toString();
    				}
    				if (lotParking[i][j].getModel()==2013) {
    					newest = lotParking[i][j].toString();
    				}
    				if (lotParking[i][j].getModel()==2012) {
    					newest = lotParking[i][j].toString();
    				}
    				if (lotParking[i][j].getModel()==2011) {
    					newest = lotParking[i][j].toString();
    				}
    				
    				if (lotParking[i][j].getModel()<2014) {
    					newest = lotParking[i][j].toString();
    				}

    				if (lotParking[i][j].getModel()<2011) {
    					oldest = lotParking[i][j].toString();
    				}
    				if (lotParking[i][j].getModel()==2011) {
    					oldest = lotParking[i][j].toString();
    				}
    				if (lotParking[i][j].getModel()==2012) {
    					oldest = lotParking[i][j].toString();
    				}
    				if (lotParking[i][j].getModel()==2013) {
    					oldest = lotParking[i][j].toString();
    				}
    				if (lotParking[i][j].getModel()==2014) {
    					oldest = lotParking[i][j].toString();
    				}
    				
    			}
    			
    		}
    	 		
    	} 	
    	out += "El vehiculo mas viejo es: " + oldest + "\n" +
    	"El vehiculo mas nuevo es: " + newest + "\n";

    	return out;
    
    }

     public int lotParkingOcupation(){
        int cont =0;
        for (int i=0;i<MAX_FILAS;i++){
            for(int j=0;j<MAX_COLUMNAS;j++){

                if(parking[i][j]==1){
                    cont=cont+1;
                }
            }
        }

        return cont;
    }
    

	 
	public String showVehicules(){
		String out = "";
		for (int i=0;i<vehicule.size();i++){
			out += vehicule.get(i).toString();
		}
		return out;
	}

}