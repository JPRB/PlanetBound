package PlanetBound.GameLogic.Dados.Setor.Planetas;

import PlanetBound.GameLogic.Dados.Aliens.Alien;
import PlanetBound.GameLogic.Dados.Aliens.FactoryAlien;
import PlanetBound.GameLogic.Dados.Nave.Drone;
import PlanetBound.GameLogic.Dados.Resources.Resources;
import PlanetBound.GameLogic.Utils.Dice;

import java.util.Arrays;

public class PlanetSuperficie {

    private int[][] fields = new int[6][6];
    private Resources resource;
    private final int resourceId = 1;
    private Drone drone;
    private Alien alien;


    public PlanetSuperficie (Resources resource, Drone drone) {
        this.resource = new Resources(resource.getCor());

        setResourcePos();
        setDrone(drone);
        setAlien();
    }

    private void initFields () {
        for (int i = 0; i < fields.length; i++)
            for (int j = 0; j < fields.length; j++) {
                fields[i][j] = 0;
            }
    }

    public void setResourcePos () {
        int[] pos = getRandomPos();
        this.fields[pos[0]][pos[1]] = this.resourceId;
    }

    public int[] getResourcePos () {
        return getPos(resourceId);
    }

    public Resources getResource () {
        return resource;
    }


    // DRONE METHODS


    public int[] getDronePos () {
        return drone.getXY();
    }

    public void setDronePos (int x, int y) throws ArrayIndexOutOfBoundsException {

        try {
            drone.setPos(x, y);

            Alien();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ui ui");
        }
    }

    public void setDrone (Drone drone) {
        int[] pos = getRandomPos();
        this.drone = drone;


        drone.setPos(pos[0], pos[1]);
    }


    // ALIENNNNN

    private void setAlien () {
        int[] pos = getRandomPos();

        alien = FactoryAlien.criaAlien();
        if (alien != null)
            alien.setPos(pos[0], pos[1]);
    }


    public int[] getAlienPos () {
        return alien.getXY();
    }

    // Podem estar na mesma celula a lutar apenas
    public void Alien () {
        int[] dronePos = getDronePos();

        if (alien.getDied() == 1)
            setAlien();

        if (alien.getX() - dronePos[0] == 0 && alien.getY() - dronePos[1] == -1 ||
                alien.getX() - dronePos[0] == 1 && alien.getY() - dronePos[1] == 0 ||
                alien.getX() - dronePos[0] == -1 && alien.getY() - dronePos[1] == 0 ||
                alien.getX() - dronePos[0] == 0 && alien.getY() - dronePos[1] == 1) {
            // Enquanto alien vivo ou drone com vida
            while (alien.getDied() == 0 && drone.getLife() > 0) {
                if (alien.attack() == 0) {
                    System.out.println("Drone atacado..");
                    drone.attacked();
                }
            }
        } else if (alien.getX() - dronePos[0] != 0 && alien.getY() - dronePos[1] != 0) {
            alien.moveAlien(drone);
        }


    }


    private void setPos (int x, int y, int val) throws ArrayIndexOutOfBoundsException {
        this.fields[x][y] = val;
    }

    public boolean getPosOcupied (int x, int y) {
        // Field
        boolean ocupado;
        //recurso?
        ocupado = this.fields[x][y] != 0;

        //Alien?
        if (alien.getX() == x && alien.getY() == y)
            ocupado = true;
        // Drone?
        if (drone.getX() == x && drone.getY() == y)
            ocupado = true;

        return ocupado;
    }


    // Aux Method
    private int[] getPos (int val) {
        int[] pos = new int[2];

        for (int i = 0; i < fields.length; i++)
            for (int j = 0; j < fields.length; j++)
                if (this.fields[i][j] == val) {
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
        return pos;
    }

    // METHOD AUX
    private int[] getRandomPos () {
        int[] pos = new int[2];

        do {
            pos[0] = Dice.rollD6() - 1;
            pos[1] = Dice.rollD6() - 1;
        } while (getPosOcupied(pos[0], pos[1]));

        return pos;
    }

}
