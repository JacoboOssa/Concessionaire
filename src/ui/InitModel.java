
package ui; 

import model.*;

public class InitModel {
    
    public InitModel() { }


    public Vehicule[] createVehicule(){
        Vehicule[] vehicules = new Vehicule[6];

        vehicules[0] = new Gasoline("1234",650000,"Ford",2015,1.6,0,"Nuevo",2022,50000,100000,2021,30000,20,"Sedan",4,"Si",8,"Corriente");
      /*
        vehicules[1] = new Gasoline();
        vehicules[2] = new Electric();
        vehicules[3] = new Hybrid();
        vehicules[4] = new Motorcycle();
        vehicules[5] = new Hybrid();
        */
        return vehicules;
    }

}
