package S191220137;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Scene {
    public static void main(String[] args) throws IOException {

        Line line = null;
        // Matrix matrix;
        if (args[0].equals("Line")) {
            line = new Line(256);
        } else if(args[0].equals("Matrix")){

        }
        if(line == null){
            System.out.println(args[0]+" "+args[1]+" "+"line null\n");
        }
        
        Gourd[] gourds = new Gourd[256];
        Integer[] a = new Integer[256];

        for (int i = 0; i < 256; i++) {
            int r = 0, b = 0, g = 0;
            if (i < (double) 256 / 3) {
                r = 255;
                g = (int) Math.ceil(255 * 3 * i / 256);
                b = 0;
            } else if (i < (double) 256 / 2) {
                r = (int) Math.ceil(750 - i * 250 * 6 / 256);
                g = 255;
                b = 0;
            } else if (i < (double) 256 * 2 / 3) {
                r = 0;
                g = 255;
                b = (int) Math.ceil(i * 250 * 6 / 256 - 750);
            } else if (i < (double) 256 * 5 / 6) {
                r = 0;
                g = (int) Math.ceil(1250 - i * 250 * 6 / 256);
                b = 255;
            } else {
                r = (int) Math.ceil(150 * i * 6 / 256 - 750);
                g = 0;
                b = 255;
            }
            gourds[i] = new Gourd(r, g, b, i);
            a[i] = i;
        }

        Comparator<Integer> cmp = new MyComparator();
        Arrays.sort(a, cmp);
        for (int k = 0; k < 256; k++) {
            if (args[0].equals("Line")) {
                line.put(gourds[k], a[k]);
            } else {

            }
        }

        Geezer theGeezer = Geezer.getTheGeezer();

        Sorter sorter = null;
        if (args[1].equals("1")) {
            sorter = new QuickSorter();
        } else if (args[1].equals("2")) {
            sorter = new HeapSorter();
        }
        theGeezer.setSorter(sorter);

        String log = theGeezer.lineUp(line, gourds);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();
    }

    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Math.random() < 0.5 ? 1 : -1;
        }
    }
}
