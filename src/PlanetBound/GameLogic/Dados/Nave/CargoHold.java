package PlanetBound.GameLogic.Dados.Nave;

import PlanetBound.GameLogic.Dados.Resources.*;
import PlanetBound.GameLogic.Util.Enums;

import java.util.ArrayList;
import java.util.List;

public class CargoHold {

    private int upgrade = 0; // initial 0
    private int maxCargo = 6;

    private List<Resources> resources = new ArrayList<>();

    public CargoHold () {
        cargaInitial();
    }

    public void cargaInitial ()
    {
        resources.add(new Resources(Enums.PlanetResources.red.name(), 1));
        resources.add(new Resources(Enums.PlanetResources.blue.name(), 1));
        resources.add(new Resources(Enums.PlanetResources.green.name(), 1));
        resources.add(new Resources(Enums.PlanetResources.black.name(), 1));
        resources.add(new Resources(Enums.PlanetResources.artifact.name(), 0));
    }



     /*
    ################## Begin #################
    ############# Resources Methods ##########
    ##########################################
    */


    public Resources getResource (String name) {
        return resources.stream()
                .filter(resource -> resource.getCor().equals(name))
                .findFirst()
                .orElse(null);
    }

    // False: Cannot add Resource
    public boolean addResource(String name, int value) {
        Resources x = getResource(name);


        try {
            // Se encontrou o recurso e se não excedeu a capacidade
            if ((x.getResourceVal() + value) <= getMaxCargo() && (x.getResourceVal() + value) >= 0)
                x.addResource(value);
            else
                x.addMaxResource(getMaxCargo());
            return true;
        }
        catch(NullPointerException e){
            return false;
        }
    }

    public boolean addResource(Resources r){

        return addResource(r.getCor(), r.getResourceVal());
    }

    public boolean removeResources (String name, int value) {
        Resources recurso = getResource(name);

        if (recurso != null){
            recurso.removeResourceVal(value);
            return true;
        }

        return false;
    }

    public boolean removeResources(Resources r){
        return removeResources(r.getCor(), r.getResourceVal());
    }


     /*
    ################## Begin #################
    ############## Upgrade Methods ###########
    ##########################################
    */


    public int getUpgrade() {
        return upgrade;
    }

    // Upgrate lvl carga and maxElementos
    public boolean setUpgrate() {
        setMaxCargo(6);
        this.upgrade += 1;
        return true;
    }

    /*
    ################## Begin #################
    ############# MaxCarga Methods ###########
    ##########################################
    */

    public int getMaxCargo() {
        return maxCargo;
    }

    private void setMaxCargo(int maxCargo) {
        this.maxCargo += maxCargo;
    }


    @Override
    public String toString () {
        return "lvl cargo: " + upgrade + " Capacidade: " + maxCargo +
                "resources" + resources.toString();
    }
}
