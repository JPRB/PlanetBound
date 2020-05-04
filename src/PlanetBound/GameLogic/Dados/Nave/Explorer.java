package PlanetBound.GameLogic.Dados.Nave;

public class Explorer extends Nave {

    public Explorer () {
        super();
        setCombustivelMax();
        setShieldsMax();
        setWeaponMax();
    }


    @Override
    public void setCombustivelMax() {
        setCombustivel(53);
    }

    @Override
    public void setShieldsMax() {
        setShields(18);
    }

    @Override
    public void setWeaponMax() {
        setWeapon(9);
    }


    // Explorer tem 3 niveis de upgrate
    // Validar se já está no max Cargo
    // Upgrate carga
    public boolean upgrateCarga (int val) {
        /*Boolean officerAlive = officers.stream().filter(officer -> officer.name()
                .equals("Cargo_hold")).findFirst().orElse(null).isAlive();*/

        if (getCarga().getUpgrade() <= 3 /*&& officerAlive*/)
            return getCarga().setUpgrate();
        return false;
    }

}
