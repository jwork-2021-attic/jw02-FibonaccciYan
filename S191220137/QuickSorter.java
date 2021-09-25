package S191220137;

public class QuickSorter implements Sorter {

    private int[] a;
    private String plan = "";

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    @Override
    public void sort() {
        int n = a.length;
        quickSort(a, 0, n - 1);
    }

    private void quickSort(int[] a, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int p = partition(a, begin, end);
        quickSort(a, begin, p - 1);
        quickSort(a, p + 1, end);
    }

    private int partition(int[] a, int begin, int end) {
        int pivot = a[end];
        int i = begin;
        for (int j = begin; j < end; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    swap(i, j);
                    ++i;
                }
            }
        }
        swap(i, end);
        return i;
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
