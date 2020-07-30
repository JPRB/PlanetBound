package PlanetBound.GameLogic.Dados.Setor.Planetas;

import PlanetBound.GameLogic.Dados.Aliens.Alien;
import PlanetBound.GameLogic.Dados.Factories.FactoryAlien;
import PlanetBound.GameLogic.Dados.Nave.Drone;
import PlanetBound.GameLogic.Dados.Resources.Resources;
import PlanetBound.GameLogic.Utils.Dice;

public class PlanetSuperficie {

    private int[][] fields = new int[6][6];
    private Resources resource;
    private final int resourceId = 1;
    private Drone drone;
    private Alien alien;


    public PlanetSuperficie (Resources resource, Drone drone) {
        this.resource = new Resources(resource.getCor());

        setAlien();
        setDrone(drone);
        setResourcePos();


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
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("A superficie só tem 6 quadrados");
        }
    }

    public void setDrone (Drone drone) {
        int[] pos = getRandomPos();
        this.drone = drone;


        drone.setPos(pos[0], pos[1]);
    }


    // CREATE ALIEN

    public void setAlien () {

        alien = FactoryAlien.criaAlien();
        int[] pos = getRandomPos();


        if (alien != null)
            alien.setPos(pos[0], pos[1]);
    }


    public int[] getAlienPos () {
        return alien.getXY();
    }

    public Alien getAlien () {
        return alien;
    }


    private void setPos (int x, int y, int val) throws ArrayIndexOutOfBoundsException {
        this.fields[x][y] = val;
    }

    public boolean getPosOcupied (int x, int y) {
        // Field
        boolean ocupado;
        //recurso?
        ocupado = (this.fields[x][y] != 0);

        //Alien?
        if (alien != null)
            if (alien.getX() == x && alien.getY() == y)
                ocupado = true;
        // Drone?
        if (drone != null)
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
