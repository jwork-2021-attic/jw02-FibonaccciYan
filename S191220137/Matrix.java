package S191220137;

import S191220137.Line.Position;

public class Matrix {

    private Position[] positions;

    public Matrix(int length) {
        this.positions = new Position[length];
    }

    public void put(Linable linable, int i) {
        if (this.positions[i] == null) {
            this.positions[i] = new Position(null);
        }
        this.positions[i].setLinable(linable);
    }

    public Linable get(int i) {
        if ((i < 0) || (i >= positions.length)) {
            return null;
        } else {
            return positions[i].linable;
        }
    }

    @Override
    public String toString() {
        String lineString = "\t";
        int i = 0;
        for (Position p : positions) {
            lineString += p.linable.toString();
            i++;
            if (i % 16 == 0) {
                lineString += "\n\t";
            }
        }
        lineString += "\n";
        return lineString;
    }

    public Linable[] toa() {
        Linable[] linables = new Linable[this.positions.length];

        for (int i = 0; i < linables.length; i++) {
            linables[i] = positions[i].linable;
        }

        return linables;

    }
}
