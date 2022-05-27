package ui;


import java.util.Scanner;
import model.Controller;

public class Concessionaire{

	private Controller concessionaire;
	private Scanner sc;

	public Concessionaire(){
	//	InitModel initM = new InitModel();
	//	concessionaire = new Controller(initM.createVehicule());
		sc = new Scanner(System.in);
	}
	public void initApp(){
        System.out.println("Dealer Name");
        String init = sc.next();
        concessionaire = new Controller(init);
    }


	public static void main(String[] args) {
		Concessionaire main = new Concessionaire();
		main.initApp();

		int option = 0;
		do{
			option= main.showMenu();
			main.executeOperation(option);	
		}while (option!=0);
	}

	public int showMenu() {
		int option=0;

		System.out.println(
				"Select an option to get started\n" +
				"(1) To Register Car\n" +
                "(2) To Register Motorcycle\n" +
				"(3) Generate Reports\n"+
				"(4) Show Document Status\n" +  
				"(5) Create parking map\n" +
				"(6) Generate Parking reports\n" +
				"(0) To go out"
				);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}

	public void executeOperation(int operation) {
		
		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			System.out.println("Type of Vehicle to register:\n" +
				"(1) Gasoline\n" +
				"(2) Electric\n" +
				"(3) Hybrid");
			int optionV = sc.nextInt();
			switch(optionV){
			case 1:
				registerGasolineCar();
				break;
			case 2:
				registerElectricCar();
				break;
			case 3:
				registerHybridCar();
				break;
			}
		    
			break;
		case 2:
			registerMotorcycle();   
			break;
		case 3:
			System.out.println("Generate report:\n" +
			"(1) Vehicle Type\n" +
			"(2) Fuel type \n" +
			"(3) New/Used Car");
			int optionInf = sc.nextInt();
			switch (optionInf){
			case 1:
				System.out.println("(1) Car\n" +
					"(2) Motorcycle");
				int option1 = sc.nextInt();
				switch(option1){
				case 1:
					showReportCar();
					break;
				case 2:
					showReportMotorcycle();
					break;
				}

				break;
			case 2:
				System.out.println("(1) Gasoline\n" +
					"(2) Electric\n" +
					"(3) Hybrid");
				int option2 = sc.nextInt();
				switch(option2){
				case 1:
					showReportGasoline();
					break;
				case 2:
					showReportElectric();
					break;
				case 3:
					showReportHybrid();
					break;
				}

				break;
			case 3:
				System.out.println("(1) New\n" +
					"(2) Used");
				int option3 = sc.nextInt();
				switch(option3){
				case 1:
					showReportNew();
					break;
				case 2:
					showReportUsed();
					break;
				}

				break;
			}

			break;

		case 4:
			showReportDocuments();	
			break;

		case 5:
			createParkingMap();
			break;

		case 6:
			System.out.println("Generate report: \n" +
				"(1) range of years\n" +
				"(2) Antiquity\n" +
				"(3) Parking Lot Occupation");
			int option4 = sc.nextInt();
			switch(option4){
			case 1:
				generateReportByYears();
				break;

			case 2:
				generateReportByModel();
				break;

			case 3:
				generateReportByOcupation();
				break;
			}

			break;
		
		default:
			System.out.println("Error, invalid option");
		
		}
	}

	public void registerMotorcycle(){
		double basePrice,salePrice = 0,cylinder,mileage,capacity,consume,price,coverageAmount,priceMR,releasedGases;
		String numMotor,mark,plate;
		int model,optionT,optionM,optionS,year,yearMR;
		String type = "";
		String typeM = "";
		String propertyCard = "";

		System.out.println("Enter the engine number (ID)");
		numMotor = sc.next();
		System.out.println("Enter the base price:");
		basePrice = sc.nextDouble();
		salePrice = basePrice;
		System.out.println("Enter the brand of the motorcycle");
		mark = sc.next();
		System.out.println("Enter the model (year) of the motorcycle");
		model = sc.nextInt();
		System.out.println("Enter the cylinder capacity of the motorcycle");
		cylinder = sc.nextDouble();
		System.out.println("Enter the mileage of the motorcycle");
		mileage = sc.nextDouble();
		System.out.println("The vehicle is: \n" +
		"(1) New \n" +
		"(2) Used" );
		optionT = sc.nextInt();
		switch(optionT){
		case 1:
			type += "New";
			break;
		case 2:
			type += "Used";
			salePrice += basePrice - (basePrice*0.02);
			break;
		}
		if (optionT==1) {
			plate = null;
		}else{
			System.out.println("Enter the plate of the motorcycle");
			plate = sc.next();
		}

		System.out.println("The vehicle has been sold: " + "\n" +
			"(1) Yes \n" +
			"(2) No");
		optionS = sc.nextInt();
		switch(optionS){
		case 1:
			propertyCard = concessionaire.generatePropertyCode();
			System.out.println(propertyCard);

			break;
		case 2:
			break;
		}
		System.out.println("Enter the year of the SOAT");
		year = sc.nextInt();
		System.out.println("Enter the price of the SOAT");
		price = sc.nextDouble();
		System.out.println("Enter the SOAT coverage");
		coverageAmount = sc.nextDouble();
		String soatImage = concessionaire.generateSoatCode();
		System.out.println(soatImage);
		System.out.println("Enter the year of the Technical-Mechanical Revision");
		yearMR = sc.nextInt();
		System.out.println("Enter the price of the Revision-Technical-Mechanical");
		priceMR = sc.nextDouble();
		System.out.println("Enter the levels of released gases");
		releasedGases = sc.nextDouble();
		String mechanicalImage = concessionaire.generateMechanicalCode();
		System.out.println(mechanicalImage);

		if (year<2022 || yearMR<2022){
			salePrice += 500000;	
		}
		salePrice += salePrice + (basePrice*0.04);

		System.out.println("Motorcycle Type: \n" +
			"(1) Standard \n" + 
			"(2) Sporty \n" +
			"(3) Scooter \n" + 
			"(4) Cross \n");
		optionM = sc.nextInt();
		switch(optionM){
		case 1:
			typeM += "Standard";
			break;
		case 2:
			typeM += "Sporty";
			break;
		case 3:
			typeM += "Scooter";
			break;
		case 4:
			typeM += "Cross";
			break;
		}
		System.out.println("Gasoline Capacity (Per Gallon)");
		capacity = sc.nextDouble();
		System.out.println(concessionaire.addMotorcycle(numMotor,basePrice,salePrice,mark,model,cylinder,mileage,type,plate,typeM,capacity,price,year,soatImage,coverageAmount,priceMR,yearMR,mechanicalImage,releasedGases,propertyCard));
	}

	public void registerGasolineCar(){
		double basePrice,salePrice=0,cylinder,mileage,capacity,consume,price,coverageAmount,priceMR,releasedGases;
		String numMotor, mark,plate,numDoor;
		int model,optionT,optionVe,optionP,optionS,optionG,year,yearMR;
		String typeGasoline ="";
		String polarized = "";
		String typeVh = "";
		String type = "";
		String propertyCard = "";

		System.out.println("Enter the engine number (ID)");
		numMotor = sc.next();
		System.out.println("Enter the base price:");
		basePrice = sc.nextDouble();
		salePrice = basePrice;
		System.out.println("Enter the car brand");
		mark = sc.next();
		System.out.println("Enter the model (year) of the Car");
		model = sc.nextInt();
		System.out.println("Enter the cylinder capacity of the car");
		cylinder = sc.nextDouble();
		System.out.println("Enter the mileage of the car");
		mileage = sc.nextDouble();
		System.out.println("The vehicle is: \n" +
		"(1) New \n" +
		"(2) Used" );
		optionT = sc.nextInt();
		switch(optionT){
		case 1:
			type += "New";
			break;
		case 2:
			type += "Used";
			salePrice += basePrice - (basePrice*0.10);
			break;
		}
		if (optionT==1) {
			plate = null;
		}else{
			System.out.println("Enter Car Plate");
			plate = sc.next();
		}

		System.out.println("The vehicle has been sold: " + "\n" +
			"(1) Yes \n" +
			"(2) No");
		optionS = sc.nextInt();
		switch(optionS){
		case 1:
			propertyCard = concessionaire.generatePropertyCode();
			System.out.println(propertyCard);

			break;
		case 2:
			break;
		}
		System.out.println("Enter the year of the SOAT");
		year = sc.nextInt();
		System.out.println("Enter the price of the SOAT");
		price = sc.nextDouble();
		System.out.println("Enter the SOAT coverage");
		coverageAmount = sc.nextDouble();
		String soatImage = concessionaire.generateSoatCode();
		System.out.println(soatImage);
		System.out.println("Enter the year of the Technical-Mechanical Revision");
		yearMR = sc.nextInt();
		System.out.println("Enter the price of the Revision-Technical-Mechanical");
		priceMR = sc.nextDouble();
		System.out.println("Enter the levels of released gases");
		releasedGases = sc.nextDouble();
		String mechanicalImage = concessionaire.generateMechanicalCode();
		System.out.println(mechanicalImage);

		if (year<2022 || yearMR<2022){
			salePrice += basePrice + 500000;	
		}

		System.out.println("Car Type \n" + 
			"(1) Sedan \n" +
			"(2) Van");
		optionVe = sc.nextInt();

		switch(optionVe){
		case 1:
			typeVh += "Sedan";
			break;
		case 2:
			typeVh += "Van";
			break;
		}
		System.out.println("Enter the number of doors");
		numDoor = sc.next();
		System.out.println("The vehicle is Polarized: \n" +
			"(1) Yes \n" +
			"(2) No");
		optionP = sc.nextInt();
		switch(optionP){
		case 1:
			polarized += "polarized";
			break;
		case 2:
			polarized += "NO polarized";
			break;
		}
		System.out.println("Tank capacity");
		capacity = sc.nextDouble();
		System.out.println("Gasoline Type \n" +
			"(1) Extra \n" + 
			"(2) Current \n" + 
			"(3) Diesel ");
		optionG = sc.nextInt();
		switch (optionG) {
		case 1:
			typeGasoline += "Extra";
			break;
		case 2:
			typeGasoline += "Current";
			break;
		case 3:
			typeGasoline += "Diesel";
			break;			
		}
		System.out.println(concessionaire.addGasolineCar(numMotor, basePrice,salePrice,mark,model,cylinder,mileage,type,plate,typeVh,numDoor,polarized,capacity,typeGasoline,price,year,soatImage,coverageAmount,priceMR,yearMR,mechanicalImage,releasedGases,propertyCard));
	}

	public void registerElectricCar(){
		double basePrice,salePrice=0,cylinder,mileage,batteryDuration,consume,price,coverageAmount,priceMR,releasedGases;
		String numMotor, mark,plate,numDoor;
		int model,optionT,optionVe,optionP,optionC,year,yearMR,optionS;
		String chargertype = "";
		String polarized = "";
		String typeVh = "";
		String type = "";
		String propertyCard = "";

		System.out.println("Enter the engine number (ID)");
		numMotor = sc.next();
		System.out.println("Enter the base price:");
		basePrice = sc.nextDouble();
		salePrice = basePrice;
		System.out.println("Enter the car brand");
		mark = sc.next();
		System.out.println("Enter the model (year) of the Car");
		model = sc.nextInt();
		System.out.println("Enter the cylinder capacity of the car");
		cylinder = sc.nextDouble();
		System.out.println("Enter the mileage of the car");
		mileage = sc.nextDouble();
		System.out.println("The vehicle is: \n" +
		"(1) New \n" +
		"(2) Used" );
		optionT = sc.nextInt();
		switch(optionT){
		case 1:
			type += "New";
			break;
		case 2:
			type += "Used";
			salePrice += basePrice - (basePrice*0.10);
			break;
		}
		if (optionT==1) {
			plate = null;
		}else{
			System.out.println("Enter Car Plate");
			plate = sc.next();
		}
		
		System.out.println("The vehicle has been sold: " + "\n" +
			"(1) Yes \n" +
			"(2) No");
		optionS = sc.nextInt();
		switch(optionS){
		case 1:
			propertyCard = concessionaire.generatePropertyCode();
			System.out.println(propertyCard);

			break;
		case 2:
			break;
		}
		System.out.println("Enter the year of the SOAT");
		year = sc.nextInt();
		System.out.println("Enter the price of the SOAT");
		price = sc.nextDouble();
		System.out.println("Enter the SOAT coverage");
		coverageAmount = sc.nextDouble();
		String soatImage = concessionaire.generateSoatCode();
		System.out.println(soatImage);
		System.out.println("Enter the year of the Technical-Mechanical Revision");
		yearMR = sc.nextInt();
		System.out.println("Enter the price of the Revision-Technical-Mechanical");
		priceMR = sc.nextDouble();
		System.out.println("Enter the levels of released gases");
		releasedGases = sc.nextDouble();
		String mechanicalImage = concessionaire.generateMechanicalCode();
		System.out.println(mechanicalImage);

		if (year<2022 || yearMR<2022){
			salePrice += basePrice + 500000;	
		}
		salePrice += basePrice + (basePrice*0.20);


		System.out.println("Car Type \n" + 
			"(1) Sedan \n" +
			"(2) Van");
		optionVe = sc.nextInt();

		switch(optionVe){
		case 1:
			typeVh += "Sedan";
			break;
		case 2:
			typeVh += "Van";
			break;
		}
		System.out.println("Enter the number of doors");
		numDoor = sc.next();
		System.out.println("The vehicle is Polarized: \n" +
			"(1) Yes \n" +
			"(2) No");
		optionP = sc.nextInt();
		switch(optionP){
		case 1:
			polarized += "polarized";
			break;
		case 2:
			polarized += "NO polarized";
			break;
		}
		System.out.println("Charger Type: \n" +
			"(1) Fast \n" +
			"(2) Normal");
		optionC = sc.nextInt();
		switch (optionC) {
		case 1:
			chargertype += "Fast";
			break;
		case 2:
			chargertype += "Normal";
			break;
		}
		System.out.println("Enter the battery life (Per Km)");
		batteryDuration = sc.nextDouble();
		

		System.out.println(concessionaire.addElectricCar(numMotor,basePrice,salePrice,mark,model,cylinder,mileage,type,plate,typeVh,numDoor,polarized,chargertype,batteryDuration,price,year,soatImage,coverageAmount,priceMR,yearMR,mechanicalImage,releasedGases,propertyCard));
	}

	public void registerHybridCar(){
		double basePrice,salePrice=0,cylinder,mileage,batteryDuration,capacity,price,coverageAmount,priceMR,releasedGases;
		String numMotor, mark,plate,numDoor;
		int model,optionT,optionVe,optionP,optionC,optionG,year,yearMR,optionS;
		String typeGasoline = "";
		String chargertype = "";
		String polarized = "";
		String typeVh = "";
		String type = "";
		String propertyCard = "";

		System.out.println("Enter the engine number (ID)");
		numMotor = sc.next();
		System.out.println("Enter the base price:");
		basePrice = sc.nextDouble();
		salePrice = basePrice;
		System.out.println("Enter the car brand");
		mark = sc.next();
		System.out.println("Enter the model (year) of the Car");
		model = sc.nextInt();
		System.out.println("Enter the cylinder capacity of the car");
		cylinder = sc.nextDouble();
		System.out.println("Enter the mileage of the car");
		mileage = sc.nextDouble();
		System.out.println("The vehicle is: \n" +
		"(1) New \n" +
		"(2) Used" );
		optionT = sc.nextInt();
		switch(optionT){
		case 1:
			type += "New";
			break;
		case 2:
			type += "Used";
			salePrice += basePrice - (basePrice*0.10);
			break;
		}
		if (optionT==1) {
			plate = null;
		}else{
			System.out.println("Enter Car Plate");
			plate = sc.next();
		}

		System.out.println("The vehicle has been sold: " + "\n" +
			"(1) Yes \n" +
			"(2) No");
		optionS = sc.nextInt();
		switch(optionS){
		case 1:
			propertyCard = concessionaire.generatePropertyCode();
			System.out.println(propertyCard);

			break;
		case 2:
			break;
		}
		System.out.println("Enter the year of the SOAT");
		year = sc.nextInt();
		System.out.println("Enter the price of the SOAT");
		price = sc.nextDouble();
		System.out.println("Enter the SOAT coverage");
		coverageAmount = sc.nextDouble();
		String soatImage = concessionaire.generateSoatCode();
		System.out.println(soatImage);
		System.out.println("Enter the year of the Technical-Mechanical Revision");
		yearMR = sc.nextInt();
		System.out.println("Enter the price of the Revision-Technical-Mechanical");
		priceMR = sc.nextDouble();
		System.out.println("Enter the levels of released gases");
		releasedGases = sc.nextDouble();
		String mechanicalImage = concessionaire.generateMechanicalCode();
		System.out.println(mechanicalImage);

		if (year<2022 || yearMR<2022){
			salePrice += basePrice + 500000;	
		}

		System.out.println("Car Type \n" + 
			"(1) Sedan \n" +
			"(2) Van");
		optionVe = sc.nextInt();

		switch(optionVe){
		case 1:
			typeVh += "Sedan";
			break;
		case 2:
			typeVh += "Van";
			break;
		}
		System.out.println("Enter the number of doors");
		numDoor = sc.next();
		System.out.println("The vehicle is Polarized: \n" +
			"(1) Yes \n" +
			"(2) No");
		optionP = sc.nextInt();
		switch(optionP){
		case 1:
			polarized += "polarized";
			break;
		case 2:
			polarized += "NO polarized";
			break;
		}

		System.out.println("Charger Type: \n" +
			"(1) Fast \n" +
			"(2) Normal");
		optionC = sc.nextInt();
		switch (optionC) {
		case 1:
			chargertype += "Fast";
			break;
		case 2:
			chargertype += "Normal";
			break;
		}
		System.out.println("Enter the battery life (Per Km)");
		batteryDuration = sc.nextDouble();
		System.out.println("Tank capacity");
		capacity = sc.nextDouble();
		System.out.println("Gasoline Type: \n" +
			"(1) Extra \n" + 
			"(2) Current \n" + 
			"(3) Diesel ");
		optionG = sc.nextInt();
		switch (optionG) {
		case 1:
			typeGasoline += "Extra";
			break;
		case 2:
			typeGasoline += "Current";
			break;
		case 3:
			typeGasoline += "Diesel";
			break;			
		}
		System.out.println(concessionaire.addHybridCar(numMotor,basePrice,salePrice,mark,model,cylinder,mileage,type,plate,typeVh,numDoor,polarized,capacity,typeGasoline,chargertype,batteryDuration,price,year,soatImage,coverageAmount,priceMR,yearMR,mechanicalImage,releasedGases,propertyCard));
	}

	public void showVehicules(){
		System.out.println(concessionaire.showVehicules());
	}

	public void showReportCar(){
		System.out.println(concessionaire.generateReportCar());
	}
	public void showReportMotorcycle(){
		System.out.println(concessionaire.generateReportMotorcycle());
	}
	public void showReportGasoline(){
		System.out.println(concessionaire.generateReportGasoline());
	}
	public void showReportElectric(){
		System.out.println(concessionaire.generateReportElectric());
	}
	public void showReportHybrid(){
		System.out.println(concessionaire.generateReportHybrid());
	}
	public void showReportNew(){
		System.out.println(concessionaire.generateReportNew());
	}
	public void showReportUsed(){
		System.out.println(concessionaire.generateReportUsed());
	}
	public void showReportDocuments(){
		System.out.println("Enter the engine number (ID)");
		String id = sc.next();
		System.out.println(concessionaire.documentsById(id));
	}


	public void createParkingMap(){
		System.out.println(concessionaire.createParkingLot());
	}


	public void generateReportByYears(){
		System.out.println(concessionaire.createReportByYears());
	}
	public void generateReportByModel(){
		System.out.println(concessionaire.createReportByModel());
	}
	public void generateReportByOcupation(){
		int ocupation = concessionaire.lotParkingOcupation();
		double ocupationPercentage = (ocupation/50)*100;
		System.out.println("The occupation of the parking lot is at " + ocupationPercentage +"%");

	}






	
}

