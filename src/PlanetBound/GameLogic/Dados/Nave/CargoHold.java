package PlanetBound.GameLogic.Dados.Nave;

import PlanetBound.GameLogic.Dados.Resources.*;
import PlanetBound.GameLogic.Utils.Enums;

import java.util.ArrayList;
import java.util.List;

public class CargoHold {

    private int upgrade = 0; // initial 0
    private int maxCargo = 6;


    //private Map<Enums.EResources, int> resources1;

    private List<Resources> resources = new ArrayList<>();

    public CargoHold () {
        cargaInitial();
    }

    private void cargaInitial () {

        resources.add(new Resources(Enums.EResources.red.name(), 5));
        resources.add(new Resources(Enums.EResources.blue.name(), 5));
        resources.add(new Resources(Enums.EResources.green.name(), 5));
        resources.add(new Resources(Enums.EResources.black.name(), 5));
        resources.add(new Resources(Enums.EResources.artifact.name(), 0));
    }



     /*
    ################## Begin #################
    ############# Resources Methods ##########
    ##########################################
    */


    public Resources getResource (String name) {
        return resources.stream()
                .filter(resource -> resource.getCor().equals(name))
                .findAny()
                .orElse(null);
    }

    // False: Cannot add Resource
    public boolean addResource (String name, int value) throws NullPointerException {
        Resources x = getResource(name);

        if (x == null)
            throw new NullPointerException("Recurso não encontrado");

        // Se encontrou o recurso e se não excedeu a capacidade
        if ((x.getResourceVal() + value) <= getMaxCargo() && (x.getResourceVal() + value) >= 0)
            x.addResource(value);
        else {
            x.addMaxResource(getMaxCargo());
            return false;
        }
        return true;
    }

    public boolean addResource (Resources r) throws NullPointerException {

        return addResource(r.getCor(), r.getResourceVal());
    }

    public boolean removeResources (String name, int value) throws NullPointerException {
        Resources recurso = getResource(name);

        if (recurso == null) throw new NullPointerException("Recurso não encontrado");

        if ((recurso.getResourceVal() - value) >= 0) {
            recurso.removeResourceVal(value);
            return true;
        }

        return false;
    }

    public boolean removeResources (Resources r) throws NullPointerException {
        return removeResources(r.getCor(), r.getResourceVal());
    }


     /*
    ################## Begin #################
    ############## Upgrade Methods ###########
    ##########################################
    */


    public int getCargoLvl () {
        return upgrade;
    }

    // Upgrate lvl carga and maxElementos
    public boolean setUpgrate () {
        updateMaxCargo();
        this.upgrade += 1;
        return true;
    }

    /*
    ################## Begin #################
    ############# MaxCarga Methods ###########
    ##########################################
    */

    public int getMaxCargo () {
        return maxCargo;
    }

    private void updateMaxCargo () {
        this.maxCargo += 6;
    }


    @Override
    public String toString () {
        return String.format("[Porão] lvl cargo: %d Capacidade: %d Resources: %s", upgrade, maxCargo, resources.toString());
    }
}
