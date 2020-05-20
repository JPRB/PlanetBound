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

    public boolean hasDied () {
        return died == 1;
    }

    public void setDie () {
        this.died = 1;
    }


    public void interaction (Drone drone) {
        int[] dronePos = drone.getXY();


        if (alienNextToDrone(dronePos)) {
            // Enquanto alien vivo ou drone com vida
            while (!hasDied() && drone.getLife() > 0) {

                if (attack() == 0) {
                    System.out.println("Drone atacado..");
                    drone.attacked();
                }
            }
        } else /*if (((this.getX() - dronePos[0]) != 0) && ((this.getY() - dronePos[1]) != 0)) */ {
            moveAlien(dronePos);
        }

    }

    // Move Alien
    private void moveAlien (int[] dronePos) {
        int val = minorDistance(dronePos);

        switch (val) {
            // TOP
            case 1:
                setPos(getX(), getY() - 1);
                break;
            // RIGHT
            case 2:
                setPos(getX() + 1, getY());
                break;
            // BOT
            case 3:
                setPos(getX(), getY() + 1);
                break;
            // LEFT
            case 4:
                setPos(getX() - 1, getY());
                break;
            // Stay
            default:
        }
    }


    // Get alien side by side w/ DRONE
    private boolean alienNextToDrone (int[] dronePos) {
        if (this.getX() - dronePos[0] == 0 && this.getY() - dronePos[1] == -1) {
            return true;
        } else if (((this.getX() - dronePos[0]) == -1) && ((this.getY() - dronePos[1]) == 0)) {
            return true;
        } else if (((this.getX() - dronePos[0]) == 1) && ((this.getY() - dronePos[1]) == 0))
            return true;
        else
            return ((this.getX() - dronePos[0]) == 0) && ((this.getY() - dronePos[1]) == 1);
    }

    public abstract int attack ();



    // AUX: CALCULATE DISTANCEs
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

    // AUX: CALCULATE MINOR DISTANCE TO MOVE
    private int minorDistance (int[] dronePos) {
        int ret = 0;
        double minorDistance = distance(getXY(), dronePos);

        double Top = distance(getX(), getY() - 1, dronePos);
        double right = distance(getX() + 1, getY(), dronePos);
        double bot = distance(getX(), getY() + 1, dronePos);
        double left = distance(getX() - 1, getY(), dronePos);


        // Cima
        if (minorDistance > Top) {
            minorDistance = Top;
            ret = 1;
        }

        //Direita
        else if (minorDistance > right) {
            minorDistance = right;
            ret = 2;
        }

        // Baixo
        else if (minorDistance > bot) {
            minorDistance = bot;
            ret = 3;

        }

        // Esquerda
        else if (minorDistance > left) {
            ret = 4;
        }

        return ret;
    }


}
