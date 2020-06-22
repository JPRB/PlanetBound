package PlanetBound.GameLogic.Dados.Nave;

public class Drone {
    private int x;
    private int y;
    private int maxLife = 6;
    private int life=maxLife;


    public Drone () {

    }

    public int getMaxLife () {
        return maxLife;
    }

    public void setPos (int x, int y) throws ArrayIndexOutOfBoundsException {
        if ((x <= 5) && (x >= 0) && (y <= 5) && (y >= 0)) {
            this.x = x;
            this.y = y;
        } else {
            throw new ArrayIndexOutOfBoundsException("Posição inválida");
        }
        System.out.println("fds!!!");
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
        if (life >= 0) life--;
    }
}
