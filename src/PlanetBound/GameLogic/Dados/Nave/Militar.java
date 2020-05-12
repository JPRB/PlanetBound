package PlanetBound.GameLogic.Dados.Nave;

public class Militar extends Nave {


    public Militar () {
        super();
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
        return 35;
    }

    @Override
    public void setShieldsMax() {
        setShields(getshieldsMax());
    }


    @Override
    public int getshieldsMax () {
        return 9;
    }

    @Override
    public void setWeaponMax() {
        setWeapon(getWeaponMax());
    }

    @Override
    public int getWeaponMax() {
        return 9;
    }


    // Militar tem 2 niveis de upgrate
    // Validar se já está no max Cargo
    // Upgrate carga
    public boolean upgrateCarga (int val) {
        if (getCarga().getUpgrade() <= 1)
           return getCarga().setUpgrate();
        return false;
    }
}
