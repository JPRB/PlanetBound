package PlanetBound.GameLogic.Dados.Aliens;

import PlanetBound.GameLogic.Dados.Nave.Drone;

public abstract class Alien {

    private int x;
    private int y;
    private int died = 0;

    protected Alien () {

    }


    public void setPos (int x, int y) throws ArrayIndexOutOfBoundsException {
        if ((x > 5) || (x < 0) || (y > 5) || (y < 0)) {
            throw new ArrayIndexOutOfBoundsException("Posição inválida");
        }

        this.x = x;
        this.y = y;
    }


    public int[] getXY () {

        return new int[]{x, y};
    }

    public int getX () {
        return x;
    }

    public int getY () {
        return y;
    }

    public int getDied () {
        return died;
    }

    public void setDie () {
        this.died = 1;
    }

    public void moveAlien (Drone drone) {
        int[] dronePos = drone.getXY();

        AlienBrain(dronePos);

    }


    private void AlienBrain (int[] dronePos) {

        // Cima
        if (distance(getXY(), dronePos) > distance(getX(), getY() - 1, dronePos)) {

            setPos(getX(), getY() - 1);
        }
        // baixo
        else if (distance(getXY(), dronePos) > distance(getX(), getY() + 1, dronePos)) {

            setPos(getX(), getY() + 1);
        }
        // Esquerda
        else if (distance(getXY(), dronePos) > distance(getX() - 1, getY(), dronePos)) {
            setPos(getX() - 1, getY());
        }
        //Direita
        else {
            setPos(getX() + 1, getY());
        }
    }

    private double distance (int x, int y, int[] b) {
        int[] pos = {x, y};
        return distance(pos, b);
    }


    private double distance (int[] a, int[] b) {

        // A(xa, ya)
        // B(xb, yb)
        // sqrt ((xb-xa)^2 + (yb-ya)^2)

        double x, y;

        x = b[0] - a[0];
        y = b[1] - a[1];

        return Math.sqrt((x * x) + (y * y));
    }


    public abstract int attack ();


}
