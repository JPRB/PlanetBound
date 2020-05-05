package PlanetBound.GameLogic.Dados.Nave;

public class Explorer extends Nave {

    private final int CombustivelMax = 53;
    private final int shieldsMax = 18;
    private final int WeaponMax = 9;


    public Explorer () {
        super();
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
        return 53;
    }

    @Override
    public void setShieldsMax() {
        setShields(getshieldsMax());
    }


    @Override
    public int getshieldsMax () {
        return 18;
    }

    @Override
    public void setWeaponMax() {
        setWeapon(getWeaponMax());
    }

    @Override
    public int getWeaponMax() {
        return 9;
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
