package PlanetBound.GameLogic.Dados.Resources;

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

    public int getNum() {
        return resourceValue;
    }

    public String getCor() {
        return cor;
    }

    public void addResource(int resource) {
        this.resourceValue += resource;
    }

    public void setResourceVal (int resource) {
        this.resourceValue = resource;
    }

    public int getResourceVal () {
        return resourceValue;
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
        return cor + " resource: " + resourceValue;
    }

    // public abstract String getResourceInfo();
}
