package PlanetBound.GameLogic.Dados.Nave;

public class Drone {
    private int x;
    private int y;
    private int life=6;

    public Drone () {

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

    public void setLife (int life) {
        this.life = life;
    }

    public int getLife () {
        return life;
    }

    // When drone is attacked
    public void attacked () {
        life--;
    }
}
