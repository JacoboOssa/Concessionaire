package model;

public class Vehicule{

	
	protected String numMotor;
	protected double basePrice;
	protected double salePrice;
	protected String mark;
	protected int model;
	protected double cylinder;
	protected double mileage;
	protected String type;
	protected String plate;	
	protected String propertyCard;
	protected Soat soat;
	protected MechanicalReview mReview;
	public static final int MAX_DOCUMENT = 3;
	private Document [] carDocuments;


	public Vehicule(String numMotor, double basePrice,double salePrice, String mark, int model, double cylinder, double mileage,String type, String plate, Soat soat, MechanicalReview mReview,String propertyCard){
		this.numMotor = numMotor;
		this.basePrice = basePrice;
		this.salePrice = salePrice;
		this.mark = mark;
		this.model = model;
		this.cylinder = cylinder;
		this.mileage = mileage;
		this.type = type;
		this.plate = plate;
		this.soat = soat;
		this.mReview = mReview;
		this.propertyCard = propertyCard;
		carDocuments = new Document[MAX_DOCUMENT];
	}

	public void addSoat(Soat dSoat){
		carDocuments[0] = dSoat;
	}
	public void addMechanicalReview(MechanicalReview dMechanicalR){
		carDocuments[1] = dMechanicalR;
	}

	public String getType(){
		return type;
	}
	public String getNumMotor(){
		return numMotor;
	}

	public int getSoatYear(){
		return soat.getYear();
	}

	public String getSoatInfo(){
		return soat.toString();
	}

	public int getMechanicalrYear(){
		return mReview.getYear();
	}

	public String getMechanicalrInfo(){
		return mReview.toString();
	}
	
	public String getPropertyCard() {
        return propertyCard;
    }

    public int getModel(){
    	return model;
    }
	

		
}