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
        System.out.println("Nombre Concesionario");
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
				"Seleccione una opción para empezar\n" +
				"(1) Para Registrar Carro\n" +
                "(2) Para Registrar Moto\n" +
				"(3) Generar Informes\n"+
				"(4) Mostrar estado Documentos\n" +  
				"(5) Crear mapa Parqueadero\n" +
				"(6) Generar informes Parqueadero\n" +
				"(0) Para salir"
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
			System.out.println("Tipo de Vehiculo a registrar:\n" +
				"(1) Gasolina\n" +
				"(2) Electrico\n" +
				"(3) Hibrido");
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
			System.out.println("Generar informe:  \n" +
			"(1) Tipo de Vehiculo \n" +
			"(2) Tipo de Combustible \n" +
			"(3) Auto Nuevo/Usado");
			int optionInf = sc.nextInt();
			switch (optionInf){
			case 1:
				System.out.println("(1) Carro\n" +
					"(2) Moto");
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
				System.out.println("(1) Gasolina\n" +
					"(2) Electrico\n" +
					"(3) Hibrido");
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
				System.out.println("(1) Nuevo\n" +
					"(2) Usado");
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
			System.out.println("Generar informe: \n" +
				"(1) Rango de agnos\n" +
				"(2) Antiguedad\n" +
				"(3) Ocupacion del Parqueadero");
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
			System.out.println("Error, opción no válida");
		
		}
	}

	public void registerMotorcycle(){
		double basePrice,salePrice = 0,cylinder,mileage,capacity,consume,price,coverageAmount,priceMR,releasedGases;
		String numMotor,mark,plate;
		int model,optionT,optionM,optionS,year,yearMR;
		String type = "";
		String typeM = "";
		String propertyCard = "";

		System.out.println("Ingrese el numero del motor (ID)");
		numMotor = sc.next();
		System.out.println("Ingrese el precio base:");
		basePrice = sc.nextDouble();
		salePrice = basePrice;
		System.out.println("Ingrese la marca de la moto");
		mark = sc.next();
		System.out.println("Ingrese el modelo (año) de la moto");
		model = sc.nextInt();
		System.out.println("Ingrese el cilindraje de la moto");
		cylinder = sc.nextDouble();
		System.out.println("Ingrese el kilometraje de la moto");
		mileage = sc.nextDouble();
		System.out.println("El vehiculo es: \n" +
		"(1) Nuevo \n" +
		"(2) Usado" );
		optionT = sc.nextInt();
		switch(optionT){
		case 1:
			type += "Nuevo";
			break;
		case 2:
			type += "Usado";
			salePrice += basePrice - (basePrice*0.02);
			break;
		}
		if (optionT==1) {
			plate = null;
		}else{
			System.out.println("Ingrese la placa de la moto");
			plate = sc.next();
		}

		System.out.println("El vehiculo ha sido vendido: " + "\n" +
			"(1) Si \n" +
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
		System.out.println("Ingrese el año del SOAT");
		year = sc.nextInt();
		System.out.println("Ingrese el precio del SOAT");
		price = sc.nextDouble();
		System.out.println("Ingrese la cobertura del SOAT");
		coverageAmount = sc.nextDouble();
		String soatImage = concessionaire.generateSoatCode();
		System.out.println(soatImage);
		System.out.println("Ingrese el año de la Revision-Tecnicomecanica");
		yearMR = sc.nextInt();
		System.out.println("Ingrese el precio de la Revision-Tecnicomecanica");
		priceMR = sc.nextDouble();
		System.out.println("Ingrese los niveles de gases arrojados");
		releasedGases = sc.nextDouble();
		String mechanicalImage = concessionaire.generateMechanicalCode();
		System.out.println(mechanicalImage);

		if (year<2022 || yearMR<2022){
			salePrice += 500000;	
		}
		salePrice += salePrice + (basePrice*0.04);

		System.out.println("Tipo de Moto: \n" +
			"(1) Estandar \n" + 
			"(2) Deportiva \n" +
			"(3) Scooter \n" + 
			"(4) Cross \n");
		optionM = sc.nextInt();
		switch(optionM){
		case 1:
			typeM += "Estandar";
			break;
		case 2:
			typeM += "Deportiva";
			break;
		case 3:
			typeM += "Scooter";
			break;
		case 4:
			typeM += "Cross";
			break;
		}
		System.out.println("Capacidad de Gasolina (Por galon)");
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

		System.out.println("Ingrese el numero del motor (ID)");
		numMotor = sc.next();
		System.out.println("Ingrese el precio base:");
		basePrice = sc.nextDouble();
		salePrice = basePrice;
		System.out.println("Ingrese la marca del Carro");
		mark = sc.next();
		System.out.println("Ingrese el modelo (año) del Carro");
		model = sc.nextInt();
		System.out.println("Ingrese el cilindraje del Carro");
		cylinder = sc.nextDouble();
		System.out.println("Ingrese el kilometraje del Carro");
		mileage = sc.nextDouble();
		System.out.println("El vehiculo es: \n" +
		"(1) Nuevo \n" +
		"(2) Usado" );
		optionT = sc.nextInt();
		switch(optionT){
		case 1:
			type += "Nuevo";
			break;
		case 2:
			type += "Usado";
			salePrice += basePrice - (basePrice*0.10);
			break;
		}
		if (optionT==1) {
			plate = null;
		}else{
			System.out.println("Ingrese la placa del Carro");
			plate = sc.next();
		}

		System.out.println("El vehiculo ha sido vendido: " + "\n" +
			"(1) Si \n" +
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
		System.out.println("Ingrese el año del SOAT");
		year = sc.nextInt();
		System.out.println("Ingrese el precio del SOAT");
		price = sc.nextDouble();
		System.out.println("Ingrese la cobertura del SOAT");
		coverageAmount = sc.nextDouble();
		String soatImage = concessionaire.generateSoatCode();
		System.out.println(soatImage);
		System.out.println("Ingrese el año de la Revision-Tecnicomecanica");
		yearMR = sc.nextInt();
		System.out.println("Ingrese el precio de la Revision-Tecnicomecanica");
		priceMR = sc.nextDouble();
		System.out.println("Ingrese los niveles de gases arrojados");
		releasedGases = sc.nextDouble();
		String mechanicalImage = concessionaire.generateMechanicalCode();
		System.out.println(mechanicalImage);

		if (year<2022 || yearMR<2022){
			salePrice += basePrice + 500000;	
		}

		System.out.println("Tipo de Automovil \n" + 
			"(1) Sedan \n" +
			"(2) Camioneta");
		optionVe = sc.nextInt();

		switch(optionVe){
		case 1:
			typeVh += "Sedan";
			break;
		case 2:
			typeVh += "Camioneta";
			break;
		}
		System.out.println("Ingrese el numero de puertas");
		numDoor = sc.next();
		System.out.println("El vehiculo es Polarizado: \n" +
			"(1) Si \n" +
			"(2) No");
		optionP = sc.nextInt();
		switch(optionP){
		case 1:
			polarized += "Polarizado";
			break;
		case 2:
			polarized += "NO Polarizado";
			break;
		}
		System.out.println("Capacidad del tanque");
		capacity = sc.nextDouble();
		System.out.println("Tipo de Gasolina: \n" +
			"(1) Extra \n" + 
			"(2) Corriente \n" + 
			"(3) Diesel ");
		optionG = sc.nextInt();
		switch (optionG) {
		case 1:
			typeGasoline += "Extra";
			break;
		case 2:
			typeGasoline += "Corriente";
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

		System.out.println("Ingrese el numero del motor (ID)");
		numMotor = sc.next();
		System.out.println("Ingrese el precio base:");
		basePrice = sc.nextDouble();
		salePrice = basePrice;
		System.out.println("Ingrese la marca del Carro");
		mark = sc.next();
		System.out.println("Ingrese el modelo (año) del Carro");
		model = sc.nextInt();
		System.out.println("Ingrese el cilindraje del Carro");
		cylinder = sc.nextDouble();
		System.out.println("Ingrese el kilometraje del Carro");
		mileage = sc.nextDouble();
		System.out.println("El vehiculo es: \n" +
		"(1) Nuevo \n" +
		"(2) Usado" );
		optionT = sc.nextInt();
		switch(optionT){
		case 1:
			type += "Nuevo";
			break;
		case 2:
			type += "Usado";
			salePrice += basePrice - (basePrice*0.10);
			break;
		}
		if (optionT==1) {
			plate = null;
		}else{
			System.out.println("Ingrese la placa del Carro");
			plate = sc.next();
		}
		
		System.out.println("El vehiculo ha sido vendido: " + "\n" +
			"(1) Si \n" +
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
		System.out.println("Ingrese el año del SOAT");
		year = sc.nextInt();
		System.out.println("Ingrese el precio del SOAT");
		price = sc.nextDouble();
		System.out.println("Ingrese la cobertura del SOAT");
		coverageAmount = sc.nextDouble();
		String soatImage = concessionaire.generateSoatCode();
		System.out.println(soatImage);
		System.out.println("Ingrese el año de la Revision-Tecnicomecanica");
		yearMR = sc.nextInt();
		System.out.println("Ingrese el precio de la Revision-Tecnicomecanica");
		priceMR = sc.nextDouble();
		System.out.println("Ingrese los niveles de gases arrojados");
		releasedGases = sc.nextDouble();
		String mechanicalImage = concessionaire.generateMechanicalCode();
		System.out.println(mechanicalImage);

		if (year<2022 || yearMR<2022){
			salePrice += basePrice + 500000;	
		}
		salePrice += basePrice + (basePrice*0.20);

		System.out.println("Tipo de Automovil \n" + 
			"(1) Sedan \n" +
			"(2) Camioneta");
		optionVe = sc.nextInt();

		switch(optionVe){
		case 1:
			typeVh += "Sedan";
			break;
		case 2:
			typeVh += "Camioneta";
			break;
		}
		System.out.println("Ingrese el numero de puertas");
		numDoor = sc.next();
		System.out.println("El vehiculo es Polarizado: \n" +
			"(1) Si \n" +
			"(2) No");
		optionP = sc.nextInt();
		switch(optionP){
		case 1:
			polarized += "Polarizado";
			break;
		case 2:
			polarized += "NO Polarizado";
			break;
		}
		System.out.println("Tipo de cargador: \n" +
			"(1) Rapido \n" +
			"(2) Normal");
		optionC = sc.nextInt();
		switch (optionC) {
		case 1:
			chargertype += "Rapido";
			break;
		case 2:
			chargertype += "Normal";
			break;
		}
		System.out.println("Ingrese la duracion de la bateria (Por Km)");
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

		System.out.println("Ingrese el numero del motor (ID)");
		numMotor = sc.next();
		System.out.println("Ingrese el precio base:");
		basePrice = sc.nextDouble();
		salePrice = basePrice;
		System.out.println("Ingrese la marca del Carro");
		mark = sc.next();
		System.out.println("Ingrese el modelo (año) del Carro");
		model = sc.nextInt();
		System.out.println("Ingrese el cilindraje del Carro");
		cylinder = sc.nextDouble();
		System.out.println("Ingrese el kilometraje del Carro");
		mileage = sc.nextDouble();
		System.out.println("El vehiculo es: \n" +
		"(1) Nuevo \n" +
		"(2) Usado" );
		optionT = sc.nextInt();
		switch(optionT){
		case 1:
			type += "Nuevo";
			break;
		case 2:
			type += "Usado";
			salePrice += basePrice - (basePrice*0.10);
			break;
		}
		if (optionT==1) {
			plate = null;
		}else{
			System.out.println("Ingrese la placa del Carro");
			plate = sc.next();
		}
		
		System.out.println("El vehiculo ha sido vendido: " + "\n" +
			"(1) Si \n" +
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
		System.out.println("Ingrese el año del SOAT");
		year = sc.nextInt();
		System.out.println("Ingrese el precio del SOAT");
		price = sc.nextDouble();
		System.out.println("Ingrese la cobertura del SOAT");
		coverageAmount = sc.nextDouble();
		String soatImage = concessionaire.generateSoatCode();
		System.out.println(soatImage);
		System.out.println("Ingrese el año de la Revision-Tecnicomecanica");
		yearMR = sc.nextInt();
		System.out.println("Ingrese el precio de la Revision-Tecnicomecanica");
		priceMR = sc.nextDouble();
		System.out.println("Ingrese los niveles de gases arrojados");
		releasedGases = sc.nextDouble();
		String mechanicalImage = concessionaire.generateMechanicalCode();
		System.out.println(mechanicalImage);

		if (year<2022 || yearMR<2022){
			salePrice += basePrice + 500000;	
		}
		salePrice += basePrice + (basePrice*0.15);

		System.out.println("Tipo de Automovil \n" + 
			"(1) Sedan \n" +
			"(2) Camioneta");
		optionVe = sc.nextInt();

		switch(optionVe){
		case 1:
			typeVh += "Sedan";
			break;
		case 2:
			typeVh += "Camioneta";
			break;
		}
		System.out.println("Ingrese el numero de puertas");
		numDoor = sc.next();
		System.out.println("El vehiculo es Polarizado: \n" +
			"(1) Si \n" +
			"(2) No");
		optionP = sc.nextInt();
		switch(optionP){
		case 1:
			polarized += "Polarizado";
			break;
		case 2:
			polarized += "NO Polarizado";
			break;
		}
		System.out.println("Tipo de cargador: \n" +
			"(1) Rapido \n" +
			"(2) Normal");
		optionC = sc.nextInt();
		switch (optionC) {
		case 1:
			chargertype += "Rapido";
			break;
		case 2:
			chargertype += "Normal";
			break;
		}
		System.out.println("Ingrese la duracion de la bateria (Por Km");
		batteryDuration = sc.nextDouble();
		System.out.println("Capacidad del tanque");
		capacity = sc.nextDouble();
		System.out.println("Tipo de Gasolina: \n" +
			"(1) Extra \n" + 
			"(2) Corriente \n" + 
			"(3) Diesel ");
		optionG = sc.nextInt();
		switch (optionG) {
		case 1:
			typeGasoline += "Extra";
			break;
		case 2:
			typeGasoline += "Corriente";
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
		System.out.println("Ingrese el numero de motor (ID)");
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
		System.out.println("La ocupacion del Parqueadero esta al " + ocupationPercentage +"%");

	}






	
}

