package PlanetBound.GameLogic.Dados.Nave;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

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


    private int _combustivel; // nr fuel

    private int shields;

    private int weapon;

    private CargoHold carga;

    // Enum de officers [6]
    //List<CrewMember> officers = new ArrayList<>();

    public Nave () {
        carga = new CargoHold();
    }

    public Nave (int fuel, int shield, int weapon, CargoHold carga) {
        this._combustivel = fuel;
        this.shields = shield;
        this.weapon = weapon;
        this.carga = carga;
    }

    public abstract boolean upgrateCarga (int val);

    public abstract void setCombustivelMax();

    public abstract void setShieldsMax();

    public abstract void setWeaponMax();

    public void setCombustivel(int combustivel) {
        this._combustivel = combustivel;
    }

    public void setShields(int shields) {
        this.shields = shields;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString () {
        return "combustivel=" + _combustivel +
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


    public void convertResources() {

        // ask if we have Cargo Holder office

        // Yes - Can Convert


        //No - CANNOT Convert

    }









    // Convert resources into fuel
    public void convertIntoFuel (){
        // black + red + green
    }


    public void convertIntoShield (){
        // black + green + blue
    }

    public void convertIntoAMMO (){
        // black + blue
    }




}
