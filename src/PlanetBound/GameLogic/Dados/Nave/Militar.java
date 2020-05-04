package PlanetBound.GameLogic.Dados.Nave;

public class Militar extends Nave {


    public Militar () {
        super();
        setCombustivelMax();
        setShieldsMax();
        setWeaponMax();
    }


    @Override
    public void setCombustivelMax() {
        setCombustivel(35);
    }

    @Override
    public void setShieldsMax() {
        setShields(9);
    }

    @Override
    public void setWeaponMax() {
        setWeapon(9);
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
