package model;
import java.util.Random;

public class Document{

	protected double price;
	protected String year;
	protected int [][] documents;

	public Document(double price,String year){
		this.price = price;
		this.year = year;
		documents = new int[4][4];
	}

	public void createDocuments(){
		Random r = new Random();

		for (int i=0;i < 4;i++ ){
			for (int j=0;j < 4;j++) {
				documents[i][j] = r.nextInt(100); 				
			}
		}
	}

    public int[][] getMatrixDocument(){
    	return documents;
    }

}