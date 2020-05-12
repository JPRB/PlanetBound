package PlanetBound.GameLogic.Dados.Resources;

import PlanetBound.GameLogic.Dados.Setor.Planetas.*;
import PlanetBound.GameLogic.Util.Dice;
import PlanetBound.GameLogic.Util.Util;

public class Resources {

    private int n;
    private String cor;
    private int resourceValue;


    public Resources (String cor) {
        ++n;
        this.cor = cor;
    }

    public Resources (String cor, int val) {
        this(cor);
        this.resourceValue = val;
    }

    public String getCor() {
        return cor;
    }



    public void addResource(int resource) {
        setResourceVal(getResourceVal()+resource);
    }

    public int getResourceVal () {
        return resourceValue;
    }

    public void setResourceVal (int resource) {
        this.resourceValue = resource;
    }

    public void removeResourceVal(int resource) {
        setResourceVal(getResourceVal()-resource);
    }

    public void addMaxResource (int maxR) {
        this.resourceValue = maxR;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Resources resources = (Resources) o;

        return cor.equals(resources.cor);
    }

    @Override
    public int hashCode() {
        return n;
    }

    @Override
    public String toString() {
        String ret = cor;

        if (resourceValue > 0)
            ret += " resource: " + resourceValue;

        return ret;
    }

    public static Resources randomResource (int val) {

        switch (Util.probability(4)){
            case 1: return new Resources("Black", val);
            case 2: return new Resources("Blue", val);
            case 3: return new Resources("Red", val);
            case 4: return new Resources("Green", val);
            default: return null;
        }
    }


    // public abstract String getResourceInfo();
}
