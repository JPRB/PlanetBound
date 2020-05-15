package PlanetBound.GameLogic.Dados.Nave;

public class Drone {
    private int x;
    private int y;
    private int estado = 0;
    private int life=6;

    public Drone () {
        estado = 1;
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

    public int getEstado () {
        return estado;
    }

    public void setEstado (int estado) {
        this.estado = estado;
        life = 6;
    }

    public int getLife () {
        return life;
    }

    // When drone is attacked
    public void attacked () {
        life--;
    }
}
