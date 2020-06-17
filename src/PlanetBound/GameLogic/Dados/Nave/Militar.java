package PlanetBound.GameLogic.Dados.Nave;

import PlanetBound.GameLogic.Utils.Enums;

public class Militar extends Nave {

    private final static int CombustivelMax = 35;
    private final static int shieldsMax = 9;
    private final static int WeaponMax = 9;


    public Militar () {
        super();
        initialize();
    }

    public void initialize(){
        setCombustivelMax();
        setShieldsMax();
        setWeaponMax();
    }


    @Override
    public void setCombustivelMax()
    {
        setCombustivel(getCombustivelMax());
    }

    @Override
    public int getCombustivelMax() {
        return CombustivelMax;
    }

    @Override
    public void setShieldsMax() {
        setShields(getshieldsMax());
    }


    @Override
    public int getshieldsMax () {
        return shieldsMax;
    }

    @Override
    public void setWeaponMax() {
        setWeapon(getWeaponMax());
    }

    @Override
    public String getNaveType () {
        return Enums.ShipType.Militar.name();
    }

    @Override
    public int getWeaponMax() {
        return WeaponMax;
    }


    // Militar tem 2 niveis de upgrate
    // Validar se já está no max Cargo
    // Upgrate carga
    public boolean upgrateCarga () throws Exception {

        if (getOfficers() < 4)
            throw new Exception("Esta Secção não possui officer");

        if (getCarga().getCargoLvl() <= 1)
           return getCarga().setUpgrate();
        return false;
    }
}
