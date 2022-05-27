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

	/**
	* register a motorcycle, along with Soat and mechanical technical review<br>
	* <b> pos:</b> a new object is added to the arraylist
	* @param <numMotor> String; vehicle identifier
	* @param <basePrice> double; base price of the vehicle
	* @param <salePrice> double; selling price of the vehicle
	* @param <mark> String; Vehicle brand
	* @param <model> int; vehicle model year
	* @param <cylinder> double; vehicle engine cylinder
	* @param <mileage> double; mileage traveled by the vehicle
	* @param <type> String; new or used
	* @param <plate> String; vehicle license plate (if used)
	* @param <typeM> String; type of motorcycle
	* @param <capacity> double; gasoline capacity (per km)
	* @param <price> double; Soat price
	* @param <year> int; soat year
	* @param <soatImage> String; soat code
	* @param <coverageAmount> double; amount coverage of the soat
	* @param <priceMR> double; Mechanical Review price
	* @param <yearMR> int; Mechanical Review year 
	* @param <mechanicalImage> String; Mechanical Review code
	* @param <releasedGases> double; result of the technical-mechanical review
	* @param <propertyCard>  String; property card code 
	*/

	public String addMotorcycle(String numMotor, double basePrice,double salePrice, String mark, int model, double cylinder, double mileage,String type, String plate ,String typeM,double capacity,
		double price,int year,String soatImage,double coverageAmount,double priceMR, int yearMR,String mechanicalImage, double releasedGases,String propertyCard){
		String out =  "";
		Soat newSoat = new Soat(price,year,soatImage,coverageAmount);
		MechanicalReview newMechanicalR = new MechanicalReview(priceMR,yearMR,mechanicalImage,releasedGases);
		vehicule.add(new Motorcycle(numMotor, basePrice,salePrice,mark,model,cylinder,mileage,type,plate,typeM,capacity,newSoat,newMechanicalR,propertyCard));
		out += "Motorcycle Registration Successful";
		return out;
	}

	/**
	* register a car of Gasoline, along with Soat and mechanical technical review<br>
	* <b> pos:</b> a new object is added to the arraylist
	* @param <numMotor> String; vehicle identifier
	* @param <basePrice> double; base price of the vehicle
	* @param <salePrice> double; selling price of the vehicle
	* @param <mark> String; Vehicle brand
	* @param <model> int; vehicle model year
	* @param <cylinder> double; vehicle engine cylinder
	* @param <mileage> double; mileage traveled by the vehicle
	* @param <type> String; new or used
	* @param <plate> String; vehicle license plate (if used)
	* @param <typeVH> String; type of car (sedan/van)
	* @param <numDoor> String; number of vehicle doors
	* @param <polarized> String; the vehicle is polarized(yes/no)
	* @param <capacity> double; gasoline capacity (per km)
	* @param <typeGasoline> String; type of car (sedan/van)
	* @param <price> double; Soat price
	* @param <year> int; soat year
	* @param <soatImage> String; soat code
	* @param <coverageAmount> double; amount coverage of the soat
	* @param <priceMR> double; Mechanical Review price
	* @param <yearMR> int; Mechanical Review year 
	* @param <mechanicalImage> String; Mechanical Review code
	* @param <releasedGases> double; result of the technical-mechanical review
	* @param <propertyCard>  String; property card code 
	*/
	public String addGasolineCar(String numMotor, double basePrice,double salePrice, String mark, int model, double cylinder, double mileage,String type, String plate,String typeVh, String numDoor, String polarized, double capacity, String typeGasoline,
		double price,int year,String soatImage,double coverageAmount,double priceMR, int yearMR,String mechanicalImage,double releasedGases,String propertyCard){
		String out = "";
		Soat newSoat = new Soat(price,year,soatImage,coverageAmount);
		MechanicalReview newMechanicalR = new MechanicalReview(priceMR,yearMR,mechanicalImage,releasedGases);
		vehicule.add(new Gasoline(numMotor, basePrice,salePrice,mark,model,cylinder,mileage,type,plate,typeVh,numDoor,polarized,capacity,typeGasoline,newSoat,newMechanicalR,propertyCard));
		out += "Gasoline car registration successful";
		return out;

	}

	/**
	* register a car of Electric, along with Soat and mechanical technical review<br>
	* <b> pos:</b> a new object is added to the arraylist
	* @param <numMotor> String; vehicle identifier
	* @param <basePrice> double; base price of the vehicle
	* @param <salePrice> double; selling price of the vehicle
	* @param <mark> String; Vehicle brand
	* @param <model> int; vehicle model year
	* @param <cylinder> double; vehicle engine cylinder
	* @param <mileage> double; mileage traveled by the vehicle
	* @param <type> String; new or used
	* @param <plate> String; vehicle license plate (if used)
	* @param <typeVH> String; type of car (sedan/van)
	* @param <numDoor> String; number of vehicle doors
	* @param <polarized> String; the vehicle is polarized(yes/no)
	* @param <chargerType> String; charger type (fast/normal)
	* @param <batteryDuration> double; vehicle battery life
	* @param <capacity> double; gasoline capacity (per km)
	* @param <typeGasoline> String; type of car (sedan/van)
	* @param <price> double; Soat price
	* @param <year> int; soat year
	* @param <soatImage> String; soat code
	* @param <coverageAmount> double; amount coverage of the soat
	* @param <priceMR> double; Mechanical Review price
	* @param <yearMR> int; Mechanical Review year 
	* @param <mechanicalImage> String; Mechanical Review code
	* @param <releasedGases> double; result of the technical-mechanical review
	* @param <propertyCard>  String; property card code 
	*/

	public String addElectricCar(String numMotor, double basePrice,double salePrice, String mark, int model, double cylinder, double mileage,String type, String plate , String typeVh, String numDoor, String polarized,String chargertype, double batteryDuration,
		double price,int year,String soatImage,double coverageAmount,double priceMR, int yearMR,String mechanicalImage,double releasedGases,String propertyCard){
		String out = "";	
		Soat newSoat = new Soat(price,year,soatImage,coverageAmount);
		MechanicalReview newMechanicalR = new MechanicalReview(priceMR,yearMR,mechanicalImage,releasedGases);
		vehicule.add(new Electric(numMotor, basePrice,salePrice,mark,model,cylinder,mileage,type,plate,typeVh,numDoor,polarized,chargertype,batteryDuration,newSoat,newMechanicalR,propertyCard));
		out += "Successful electric car registration";
		return out;
	}

	/**
	* register a car of Hybrid, along with Soat and mechanical technical review<br>
	* <b> pos:</b> a new object is added to the arraylist
	* @param <numMotor> String; vehicle identifier
	* @param <basePrice> double; base price of the vehicle
	* @param <salePrice> double; selling price of the vehicle
	* @param <mark> String; Vehicle brand
	* @param <model> int; vehicle model year
	* @param <cylinder> double; vehicle engine cylinder
	* @param <mileage> double; mileage traveled by the vehicle
	* @param <type> String; new or used
	* @param <plate> String; vehicle license plate (if used)
	* @param <typeVH> String; type of car (sedan/van)
	* @param <numDoor> String; number of vehicle doors
	* @param <polarized> String; the vehicle is polarized(yes/no)
	* @param <capacity> double; gasoline capacity (per km)
	* @param <typeGasoline> String; type of car (sedan/van)
	* @param <chargerType> String; charger type (fast/normal)
	* @param <batteryDuration> double; vehicle battery life
	* @param <capacity> double; gasoline capacity (per km)
	* @param <typeGasoline> String; type of car (sedan/van)
	* @param <price> double; Soat price
	* @param <year> int; soat year
	* @param <soatImage> String; soat code
	* @param <coverageAmount> double; amount coverage of the soat
	* @param <priceMR> double; Mechanical Review price
	* @param <yearMR> int; Mechanical Review year 
	* @param <mechanicalImage> String; Mechanical Review code
	* @param <releasedGases> double; result of the technical-mechanical review
	* @param <propertyCard>  String; property card code 
	*/

	public String addHybridCar(String numMotor, double basePrice,double salePrice, String mark, int model, double cylinder, double mileage,String type, String plate,String typeVh, String numDoor, String polarized,double capacity, String typeGasoline,String chargertype,double batteryDuration,
		double price,int year,String soatImage,double coverageAmount,double priceMR, int yearMR,String mechanicalImage,double releasedGases,String propertyCard){
		String out = "";
		Soat newSoat = new Soat(price,year,soatImage,coverageAmount);
		MechanicalReview newMechanicalR = new MechanicalReview(priceMR,yearMR,mechanicalImage,releasedGases);
		vehicule.add(new Hybrid(numMotor, basePrice,salePrice,mark,model,cylinder,mileage,type,plate,typeVh,numDoor,polarized,capacity,typeGasoline,chargertype,batteryDuration,newSoat,newMechanicalR,propertyCard));
		out += "Successful Hybrid car registration";
		return out;
	}

	/**
	* Randomly generate an array and loop through L<br>
	* <b> pre:</b> register a vehicle<br>
	* <b> pos:</b> a Soat code is saved for the vehicle.
	*/


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

	/**
	* Randomly generate an array and loop through Z<br>
	* <b> pre:</b> register a vehicle<br>
	* <b> pos:</b> a Mechanical Review code is saved for the vehicle.
	*/

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

	/**
	* Randomly generate an array and loop through a pattern to generate code<br>
	* <b> pre:</b> register a vehicle<br>
	* <b> pos:</b> a property Card code is saved for the vehicle.
	*/

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



	/**
	* Report under the criteria of being a Car<br>
	* <b> pre:</b> register a vehicle<br>
	* <b> pos:</b> generate vehicle report
	*/
	public String generateReportCar(){
		String out = "";
		for (int i=0;i<vehicule.size();i++){
			if (vehicule.get(i) instanceof Car){
				out+= vehicule.get(i).toString();		
			}			
		}

		return out;
	}
	/**
	* Report under the criteria of being a Motorcycle<br>
	* <b> pre:</b> register a vehicle<br>
	* <b> pos:</b> generate vehicle report
	*/

	public String generateReportMotorcycle(){
		String out = "";

		for (int i=0;i<vehicule.size();i++){
			if (vehicule.get(i) instanceof Motorcycle){
				out+= vehicule.get(i).toString();
			}
		}

		return out;
	}
	/**
	* Report under the criteria of being a Gasoline Car<br>
	* <b> pre:</b> register a vehicle<br>
	* <b> pos:</b> generate vehicle report
	*/

	public String generateReportGasoline(){
		String out = "";

		for (int i=0;i<vehicule.size();i++){
			if (vehicule.get(i) instanceof Gasoline){
				out+= vehicule.get(i).toString();
			}
		}

		return out;
	}

	/**
	* Report under the criteria of being a Electric Car<br>
	* <b> pre:</b> register a vehicle<br>
	* <b> pos:</b> generate vehicle report
	*/
	public String generateReportElectric(){
		String out = "";

		for (int i=0;i<vehicule.size();i++){
			if (vehicule.get(i) instanceof Electric){
				out+= vehicule.get(i).toString();
			}
		}

		return out;
	}

	/**
	* Report under the criteria of being a Hybrid Car<br>
	* <b> pre:</b> register a vehicle<br>
	* <b> pos:</b> generate vehicle report
	*/

	public String generateReportHybrid(){
		String out = "";

		for (int i=0;i<vehicule.size();i++){
			if (vehicule.get(i) instanceof Hybrid){
				out+= vehicule.get(i).toString();
			}
		}

		return out;
	}
	/**
	* Report under the criteria of being a new Vehicule<br>
	* <b> pre:</b> register a vehicle<br>
	* <b> pos:</b> generate vehicle report
	*/
	
	public String generateReportNew(){
		String out = "";
		String type = "";

		for (int i=0;i<vehicule.size();i++){
			if (vehicule.get(i) instanceof Vehicule){
				if(vehicule.get(i).getType().equalsIgnoreCase("New")){
					out+=(vehicule.get(i).toString());
				}
			}
		}

		return out;
	}

	/**
	* Report under the criteria of being a used Vehicule<br>
	* <b> pre:</b> register a vehicle<br>
	* <b> pos:</b> generate vehicle report
	*/

	public String generateReportUsed(){
		String out = "";
		String type = "";

		for (int i=0;i<vehicule.size();i++){
			if (vehicule.get(i) instanceof Vehicule){
				if(vehicule.get(i).getType().equalsIgnoreCase("Used")){
					out+=(vehicule.get(i).toString());
				}
			}
		}
		return out;
	}

	/**
	* Generate Soat report and technical-mechanical review by the ID of a vehicle<br>
	* <b> pre:</b> register a vehicle<br>
	* <b> pos:</b> generate documents report by id 
	*/

	public String documentsById(String id){
		String out ="";

		for (int i=0;i<vehicule.size();i++){
			if (vehicule.get(i).getNumMotor().equals(id)){
				if (vehicule.get(i).getPropertyCard() == null){
					out+= "Does not have property card";
				}else {
					out+= "The property card code is:" + vehicule.get(i).getPropertyCard() + "\n";			
				}
				
				if (vehicule.get(i).getSoatYear()==2022){
					out += "\nSOAT valid" + "\n" +
					vehicule.get(i).getSoatInfo();	
				}else{
					out += "\nSOAT expired" + "\n" + 
					vehicule.get(i).getSoatInfo();
				}

				if (vehicule.get(i).getMechanicalrYear()==2022){
					out += "\nRevision Tecnico-Mecanica valid" + "\n" +
					vehicule.get(i).getMechanicalrInfo() + "\n";		
				}else{
					out += "\nRevision Tecnico-Mecanica expired" + "\n" +
					vehicule.get(i).getMechanicalrInfo() + "\n";	
				}
			}	
		}

		return out;
	}

	/**
	* Create the parking lot of size 10x5 with 0<br>
	* <b> pos:</b> generate parking map 
	*/
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

   	/**
	* create the report in a range of years<br>
	* <b> pre:</b> register a vehicle<br>
	* <b> pos:</b> show information aboout this vehicules
	*/

    
    public String createReportByYears(){
    	String out = "";
    	for (int i=0;i<vehicule.size();i++){

    		if (vehicule.get(i).getModel()==2014) {
    			out+= "Vehicules 2014: \n" + 
    			vehicule.get(i).toString();
			}
			if (vehicule.get(i).getModel()==2013) {
    			out+= "Vehicules 2013: \n" + 
    			vehicule.get(i).toString();
			}	
			if (vehicule.get(i).getModel()==2012) {
    			out+= "Vehicules 2012: \n" + 
    			vehicule.get(i).toString();
			}	
			if (vehicule.get(i).getModel()==2011) {
    			out+= "Vehicules 2011: \n" + 
    			vehicule.get(i).toString();
			}	
			if (vehicule.get(i).getModel()<2011) {
    			out+= "Vehiculesmodels less than 2011: \n" + 
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
    	out += "The oldest vehicle is: " + oldest + "\n" +
    	"The newest vehicle is:" + newest + "\n";

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