package S191220137;

import S191220137.Line.Position;

public class Gourd implements Linable {

    private final int r;
    private final int g;
    private final int b;

    private int rank;

    private Position position;

    Gourd(int r, int g, int b, int rank) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.rank = rank;
    }

    public Gourd getGourdByRank(int rank) {
        if (this.rank == rank)
            return this;
        return null;
    }

    @Override
    public String toString() {
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + this.rank + "  \033[0m";
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    public void swapPosition(Gourd another) {
        Position p = another.position;
        this.position.setLinable(another);
        p.setLinable(this);
    }

    @Override
    public int getValue() {
        return this.rank;
    }

}