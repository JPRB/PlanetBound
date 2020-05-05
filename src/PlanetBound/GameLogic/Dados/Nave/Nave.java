package PlanetBound.GameLogic.Dados.Nave;

import PlanetBound.GameLogic.Dados.Resources.Resources;

/*enum Officers {
    Captian(1),
    Navigation,
    LandingParty,
    Shields,
    Weapons,
    Cargo_hold;

    //private int n;

    *//*Officers(int alive) {
        this.n = alive;
    }*//*

    public boolean isAlive() {
        return alive;
    }

    @Override
    public String toString() {
        if (alive)
            return "Sim";
        return "Não";
    }
}*/

public abstract class Nave {


    private int combustivel; // nr fuel

    private int shields;

    private int weapon;

    private CargoHold carga;

    // Enum de officers [6]
    //List<CrewMember> officers = new ArrayList<>();

    public Nave () {
        carga = new CargoHold();
    }

    public Nave (int fuel, int shield, int weapon, CargoHold carga) {
        this.combustivel = fuel;
        this.shields = shield;
        this.weapon = weapon;
        this.carga = carga;
    }

    public abstract boolean upgrateCarga (int val);

    public abstract void setCombustivelMax();

    public abstract void setShieldsMax();

    public abstract void setWeaponMax();


    public abstract int getCombustivelMax();

    public abstract int getshieldsMax ();

    public abstract int getWeaponMax();



    public void setCombustivel(int combustivel) {
        this.combustivel = combustivel;
    }

    public void setShields(int shields) {
        this.shields = shields;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString () {
        return "combustivel=" + combustivel +
                ", shields=" + shields +
                ", weapon=" + weapon +
                ", carga=" + carga.toString();
    }

    public void wasteFuel(int val){
        setCombustivel(-val);
    }

    public CargoHold getCarga() {
        return carga;
    }

    public boolean collectResource (String name, int resourceVal) {
        if (getCarga().getMaxCargo() > resourceVal) {
           return getCarga().addResource(name, resourceVal);
        }

        return false;
    }


    public boolean convertResources() {

        // ask if we have Cargo Holder office

        // Yes - Can Convert


        //No - CANNOT Convert
        return false;
    }









    // Convert resources into fuel
    public boolean convertIntoFuel (){
        // black + red + green
        Resources black = getCarga().getResource("black");
        Resources red = getCarga().getResource("red");
        Resources green = getCarga().getResource("green");

        if (black.getResourceVal() > 0 && red.getResourceVal() > 0 && green.getResourceVal() > 0)
        {
            if (getCombustivelMax() > combustivel){
                setCombustivel(combustivel+1);

                black.setResourceVal(black.getResourceVal()-1);
                red.setResourceVal(red.getResourceVal()-1);
                green.setResourceVal(green.getResourceVal()-1);

                return true;
            }
        }
        return false;
    }


    public boolean convertIntoShield (){
        // black + green + blue
        Resources black = getCarga().getResource("black");
        Resources blue = getCarga().getResource("blue");
        Resources green = getCarga().getResource("green");

        if (black.getResourceVal() > 0 && blue.getResourceVal() > 0 && green.getResourceVal() > 0)
        {
            if (getshieldsMax() > shields){
                setShields(shields+1);

                black.setResourceVal(black.getResourceVal()-1);
                blue.setResourceVal(blue.getResourceVal()-1);
                green.setResourceVal(green.getResourceVal()-1);

                return true;
            }
        }
        return false;

    }

    public boolean convertIntoAMMO (){
        // black + blue
        Resources black = getCarga().getResource("black");
        Resources blue = getCarga().getResource("blue");

        if (black.getResourceVal() > 0 && blue.getResourceVal() > 0)
        {
            if (getWeaponMax() > weapon){
                setWeapon(weapon+1);

                black.setResourceVal(black.getResourceVal()-1);
                blue.setResourceVal(blue.getResourceVal()-1);
                return true;
            }
        }
        return false;
    }




}
