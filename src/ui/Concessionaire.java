package ui;


import java.util.Scanner;
import model.Controller;

public class Concessionaire{

	private Controller concessionaire;
	private Scanner sc;

	public Concessionaire(){
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
				"(3) Mostrar Vehiculos registrados \n"+
				"(4) Generar Informes\n"+
				"(5) \n" +  
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
			System.out.println("Tipo de Vehiculo a registrar: \n" +
				"(1) Gasolina \n" +
				"(2) Electrico \n" +
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
			showVehicules();
			
			break;

		case 4:
			System.out.println("Generar informe:  \n" +
			"(1) Tipo de Vehiculo \n" +
			"(2) Tipo de Combustible \n" +
			"(3) Auto Nuevo \n" + 
			"(4) Auto Usado ");
			int optionInf = sc.nextInt();
			switch (optionInf){
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;

			case 4:

				break;	
			}
			break;

		case 5:
			
			break;
		
		default:
			System.out.println("Error, opción no válida");
		
		}
	}

	public void registerMotorcycle(){
		double basePrice,salePrice,cylinder,mileage,capacity,consume;
		String mark,plate,propertyCard;
		int model,optionT,optionM;
		String type = "";
		String typeM = "";

		System.out.println("Ingrese el precio base:");
		basePrice = sc.nextDouble();
		System.out.println("Ingrese el precio de venta");
		salePrice = sc.nextDouble();
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
			break;
		}
		if (optionT==1) {
			plate = null;
		}else{
			System.out.println("Ingrese la placa de la moto");
			plate = sc.next();
		}
		if (optionT==1){
			propertyCard = null;
		}else {
			System.out.println("Ingrese la tarjeta de propiedad");
			propertyCard = sc.next();
		}

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
		System.out.println(concessionaire.addMotorcycle(basePrice,salePrice,mark,model,cylinder,mileage,type,plate,propertyCard,typeM,capacity));
	}

	public void registerGasolineCar(){
		double basePrice,salePrice,cylinder,mileage,capacity,consume;
		String mark,plate,propertyCard,numDoor;
		int model,optionT,optionVe,optionP,optionG;
		String typeGasoline ="";
		String polarized = "";
		String typeVh = "";
		String type = "";

		System.out.println("Ingrese el precio base:");
		basePrice = sc.nextDouble();
		System.out.println("Ingrese el precio de venta");
		salePrice = sc.nextDouble();
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
			break;
		}
		if (optionT==1) {
			plate = null;
		}else{
			System.out.println("Ingrese la placa del Carro");
			plate = sc.next();
		}
		if (optionT==1){
			propertyCard = null;
		}else {
			System.out.println("Ingrese la tarjeta de propiedad");
			propertyCard = sc.next();
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
		System.out.println(concessionaire.addGasolineCar(basePrice,salePrice,mark,model,cylinder,mileage,type,plate,propertyCard,typeVh,numDoor,polarized,capacity,typeGasoline));
	}

	public void registerElectricCar(){
		double basePrice,salePrice,cylinder,mileage,batteryDuration,consume;
		String mark,plate,propertyCard,numDoor;
		int model,optionT,optionVe,optionP,optionC;
		String chargertype = "";
		String polarized = "";
		String typeVh = "";
		String type = "";

		System.out.println("Ingrese el precio base:");
		basePrice = sc.nextDouble();
		System.out.println("Ingrese el precio de venta");
		salePrice = sc.nextDouble();
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
			break;
		}
		if (optionT==1) {
			plate = null;
		}else{
			System.out.println("Ingrese la placa del Carro");
			plate = sc.next();
		}
		if (optionT==1){
			propertyCard = null;
		}else {
			System.out.println("Ingrese la tarjeta de propiedad");
			propertyCard = sc.next();
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
		

		System.out.println(concessionaire.addElectricCar(basePrice,salePrice,mark,model,cylinder,mileage,type,plate,propertyCard,typeVh,numDoor,polarized,chargertype,batteryDuration));
	}

	public void registerHybridCar(){
		double basePrice,salePrice,cylinder,mileage,batteryDuration,capacity;
		String mark,plate,propertyCard,numDoor;
		int model,optionT,optionVe,optionP,optionC,optionG;
		String typeGasoline = "";
		String chargertype = "";
		String polarized = "";
		String typeVh = "";
		String type = "";

		System.out.println("Ingrese el precio base:");
		basePrice = sc.nextDouble();
		System.out.println("Ingrese el precio de venta");
		salePrice = sc.nextDouble();
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
			break;
		}
		if (optionT==1) {
			plate = null;
		}else{
			System.out.println("Ingrese la placa del Carro");
			plate = sc.next();
		}
		if (optionT==1){
			propertyCard = null;
		}else {
			System.out.println("Ingrese la tarjeta de propiedad");
			propertyCard = sc.next();
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
		System.out.println(concessionaire.addHybridCar(basePrice,salePrice,mark,model,cylinder,mileage,type,plate,propertyCard,typeVh,numDoor,polarized,capacity,typeGasoline,chargertype,batteryDuration));
	}

	public void showVehicules(){
		System.out.println(concessionaire.showVehicules());
	}




	
}

