package PlanetBound.GameLogic.Dados.Nave;

import PlanetBound.GameLogic.Utils.Enums;

public class Explorer extends Nave {

    private final static int CombustivelMax = 53;
    private final static int shieldsMax = 18;
    private final static int WeaponMax = 9;


    public Explorer () {
        super();
        initialize();
    }

    public void initialize(){
        setCombustivelMax();
        setShieldsMax();
        setWeaponMax();
    }



    @Override
    public void setCombustivelMax() {
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
        return Enums.ShipType.Explorer.name();
    }

    @Override
    public int getWeaponMax() {
        return WeaponMax;
    }

    // Explorer tem 3 niveis de upgrate
    // Validar se já está no max Cargo
    // Upgrate carga
    public boolean upgrateCarga () throws Exception {

        if (getOfficers() < 4)
            throw new Exception("Esta Secção não possui officer");

        if (getCarga().getCargoLvl() <= 3)
            return getCarga().setUpgrate();
        return false;
    }


}
