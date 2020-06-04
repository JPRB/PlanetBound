package PlanetBound.GameLogic.Dados.Resources;

import PlanetBound.GameLogic.Utils.Enums;
import PlanetBound.GameLogic.Utils.Util;

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

        Resources resource = (Resources) o;

        return cor.equals(resource.cor);
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
            case 1: return new Resources(Enums.EResources.black.name(), val);
            case 2: return new Resources(Enums.EResources.blue.name(), val);
            case 3: return new Resources(Enums.EResources.red.name(), val);
            case 4: return new Resources(Enums.EResources.green.name(), val);
            default: return null;
        }
    }


    // public abstract String getResourceInfo();
}
