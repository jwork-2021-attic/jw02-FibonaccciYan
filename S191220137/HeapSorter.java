package S191220137;

public class HeapSorter implements Sorter {

    private int[] a;
    private String plan = "";

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    @Override
    public void sort() {
        for (int i = (a.length - 2) / 2; i >= 0; i--) {
            adjustDownToUp(a, i, a.length);
        }
        for (int i = a.length - 1; i > 0; i--) {
            swap(0, i);
            adjustDownToUp(a, 0, i);
        }
    }

    private void adjustDownToUp(int[] a, int k, int length) {
        for (int i = 2 * k + 1; i < length; i = 2 * i + 1) {
            if (i < length - 1 && a[i] < a[i + 1]) {
                i++;
            }
            if (a[k] >= a[i]) {
                break;
            } else {
                swap(i, k);
                k = i;
            }
        }
    }

    public void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    @Override
    public String getPlan() {
        return this.plan;
    }
}
