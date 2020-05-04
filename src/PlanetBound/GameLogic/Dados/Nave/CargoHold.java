package PlanetBound.GameLogic.Dados.Nave;

import PlanetBound.GameLogic.Dados.Resources.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CargoHold {

    private int upgrade = 0; // initial 0
    private int maxCargo = 6;

    private List<Resources> resources = new ArrayList<>();

    public CargoHold () {
        cargaInitial();
    }

    public void cargaInitial ()
    {
        resources.add(new Resources("red", 1));
        resources.add(new Resources("blue", 1));
        resources.add(new Resources("green", 1));
        resources.add(new Resources("black", 1));
        resources.add(new Resources("purple", 0));
    }

    // False: Cannot add Resource
    public boolean addResource(String name, int value) {
        Resources x = resources.stream()
                .filter(resource -> resource.getCor().equals(name))
                .findFirst()
                .orElse(null);

        // Se encontrou o recurso e se não excedeu a capacidade
        if (x != null){
            if (x.getNum()+value <= getMaxCargo())
                x.addResource(value);
            else
                x.addMaxResource(getMaxCargo());

            return true;
        }

        return false;
    }


    // Upgrate lvl carga and maxElementos
    public boolean setUpgrate() {
        setMaxCargo(6);
        this.upgrade += 1;
        return true;
    }

    public int getUpgrade() {
        return upgrade;
    }

    private void setMaxCargo(int maxCargo) {
        this.maxCargo += maxCargo;
    }

    public int getMaxCargo() {
        return maxCargo;
    }

    @Override
    public String toString () {
        return "lvl cargo: " + upgrade + " Capacidade: " + maxCargo +
                "resources" + resources.toString();
    }
}
