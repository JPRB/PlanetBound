package PlanetBound.GameLogic.Dados.Resources;

import java.util.Objects;

public class Resources {

    private int n;
    private String cor;
    private int resource;


    public Resources (String cor) {
        ++n;
        this.cor = cor;
    }

    public Resources (String cor, int val) {
        this(cor);
        this.resource = val;
    }

    public int getNum() {
        return resource;
    }

    public String getCor() {
        return cor;
    }

    public void addResource(int resource) {
        this.resource += resource;
    }

    public void addMaxResource (int maxR) {
        this.resource = maxR;
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
        return cor + " resource: " + resource;
    }

    // public abstract String getResourceInfo();
}
