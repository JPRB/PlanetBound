package PlanetBound.GameLogic.Dados.Nave;

import PlanetBound.GameLogic.Dados.Resources.Resources;

public abstract class Nave {

    // Officers
    private int officers = 6;

    private int combustivel; // nr fuel

    private int shields;

    private int weapon;

    private CargoHold carga;

    private Drone drone;

    public Nave () {
        carga = new CargoHold();
        drone = new Drone();
    }

    public abstract boolean upgrateCarga () throws Exception;

    public abstract int getCombustivelMax();

    public abstract void setCombustivelMax();

    public abstract int getshieldsMax ();

    public abstract void setShieldsMax();

    public abstract int getWeaponMax();

    public abstract void setWeaponMax();

    public Drone getDrone () {
        return drone;
    }

    /*
    ################## Begin #################
    ############ CrewMember Methods ##########
    ##########################################
    */

    public int getOfficers () {
        return officers;
    }

    private void setOfficers (int officers) {
        this.officers = officers;
    }

    public void crewMemberDie () {
        setOfficers(getOfficers()-1);
    }

    public void addCrewMember () {
        setOfficers(getOfficers()+1);
    }

    /*
    ################## END ###################
    ############ CrewMember Methods ##########
    ##########################################
    */

    public int getCombustivel () {
        return combustivel;
    }

    public void setCombustivel(int combustivel) {
        this.combustivel = combustivel;
    }

    public int getShields () {
        return shields;
    }

    public void setShields(int shields) {
        this.shields = shields;
    }

    public int getWeapon () {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString () {

        return "Total Officers: "+ officers +" combustivel: " + combustivel +
                ", shields: " + shields +
                ", weapon: " + weapon +
                ", carga: " + carga.toString();
    }

    public void wasteFuel(int val){
        setCombustivel(getCombustivel()-val);
    }

    public CargoHold getCarga() {
        return carga;
    }

    public boolean collectResource (String name, int resourceVal) throws NullPointerException {
        if (getCarga().getMaxCargo() > resourceVal) {
           return getCarga().addResource(name, resourceVal);
        }
        return false;
    }

    public boolean collectResource (Resources resource) throws NullPointerException {
        return collectResource(resource.getCor(), resource.getResourceVal());
    }




    public boolean convertResources() throws Exception {

        // ask if we have Cargo Holder office
        if (getOfficers() < 4)
            throw new Exception("Não tem oficial para esta tarefa.");
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

                black.removeResourceVal(1);
                red.removeResourceVal(1);
                green.removeResourceVal(1);

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

                black.removeResourceVal(1);
                blue.removeResourceVal(1);
                green.removeResourceVal(1);

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

                black.removeResourceVal(1);
                blue.removeResourceVal(1);
                return true;
            }
        }
        return false;
    }

    public abstract void reset ();
}
