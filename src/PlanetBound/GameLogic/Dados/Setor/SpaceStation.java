package PlanetBound.GameLogic.Dados.Setor;

import PlanetBound.GameLogic.Dados.Nave.Nave;
import PlanetBound.GameLogic.Utils.Enums;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpaceStation {


    private boolean cargoHoldUpgrate;

    public SpaceStation () {
        cargoHoldUpgrate = true;
    }


    public void setCargoHoldUpgrate () {
        this.cargoHoldUpgrate = !cargoHoldUpgrate;
    }

    public boolean canUpgrateCargoHold () {
        return cargoHoldUpgrate;
    }


    public boolean buyDrone (Nave nave) {
        // Buy a new drone for (2 or 3)? of each resource [red, black, green and blue]
        boolean canBuy = false;

        try {
            List<PlanetBound.GameLogic.Dados.Resources.Resources> resources = Stream.of(Enums.EResources.values())
                    .map(res -> nave.getCarga().getResource(res.name())).filter(res -> !res.getCor().equals(Enums.EResources.artifact.name())).collect(Collectors.toList());

            final long count = resources.stream().filter(r -> r.getResourceVal() >= 2).count();

            if (count == 4) {

                for (PlanetBound.GameLogic.Dados.Resources.Resources r : resources)
                    nave.getCarga().removeResources(r.getCor(), 2);

                nave.getDrone().setLife(6);
                canBuy = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return canBuy;
    }

    public boolean hireNewCrew (Nave nave) {
        boolean hiredOfficer = false;

        try {
            // Hire a single crew member that was lost for one of each resource [red, black, green and blue]
            List<PlanetBound.GameLogic.Dados.Resources.Resources> resources = Stream.of(Enums.EResources.values())
                    .map(res -> nave.getCarga().getResource(res.name())).filter(res -> !res.getCor().equals(Enums.EResources.artifact.name())).collect(Collectors.toList());

            final long count = resources.stream().filter(r -> r.getResourceVal() >= 1).count();

            if (count == 4) {

                for (PlanetBound.GameLogic.Dados.Resources.Resources r : resources)
                    hiredOfficer = nave.getCarga().removeResources(r.getCor(), 1);

                nave.addCrewMember();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return hiredOfficer;
    }

    public void upgradeWeapons () {
        // Upgrade your weapon system on the Military ship for two of each resource [red, black, green and blue]

    }

    public boolean upgradeCargoHold (Nave nave) throws Exception {
        boolean res = false;
        if (canUpgrateCargoHold()) {
            res = nave.upgrateCarga();
            setCargoHoldUpgrate();
        }

        return res;
    }


}
