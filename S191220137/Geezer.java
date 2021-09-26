package S191220137;

public class Geezer {

    private static Geezer theGeezer;

    public static Geezer getTheGeezer() {
        if (theGeezer == null) {
            theGeezer = new Geezer();
        }
        return theGeezer;
    }

    private Geezer() {

    }

    private Sorter sorter;

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public String lineUp(Line line, Gourd[] gourds) {

        String log = new String();

        if (sorter == null) {
            return null;
        }

        Linable[] linables = line.toa();
        int[] ranks = new int[linables.length];

        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
        }

        sorter.load(ranks);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());

        for (String step : sortSteps) {
            this.execute(step, gourds);
            System.out.println(line.toString());
            log += line.toString();
            log += "\n[frame]\n";
        }

        return log;

    }

    public String matrixUp(Matrix matrix, Gourd[] gourds) {

        String log = new String();

        if (sorter == null) {
            return null;
        }

        Linable[] linables = matrix.toa();
        int[] ranks = new int[linables.length];

        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
        }

        sorter.load(ranks);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());

        for (String step : sortSteps) {
            this.execute(step, gourds);
            System.out.println(matrix.toString());
            log += matrix.toString();
            log += "\n[frame]\n";
        }

        return log;

    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(String step, Gourd[] gourds) {
        String[] couple = step.split("<->");
        int temp1 = -1, temp2 = -1;
        for (int i = 0; i < gourds.length; i++) {
            if (gourds[i].getValue() == Integer.parseInt(couple[0])) {
                temp1 = i;
            }
            if (gourds[i].getValue() == Integer.parseInt(couple[1])) {
                temp2 = i;
            }
        }
        gourds[temp1].swapPosition(gourds[temp2]);
    }

}
