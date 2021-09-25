package S191220137;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Scene {
    public static void main(String[] args) throws IOException {

        Line line = new Line(256);
        Gourd[] gourds = new Gourd[256];

        Integer[] a = new Integer[256];
        for (int i = 0; i < 256; i++) {
            a[i] = i;
            int r = i;
            int g = 255-i;
            int b = 255;
            gourds[i] = new Gourd(r, g, b, i);
        }
        Comparator<Integer> cmp = new MyComparator();
        Arrays.sort(a, cmp);
        for (int i = 0; i < 256; i++) {
            line.put(gourds[i], a[i]);
        }

        Geezer theGeezer = Geezer.getTheGeezer();

        Sorter sorter = new QuickSorter();

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
