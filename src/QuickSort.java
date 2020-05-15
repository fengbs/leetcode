/**
 * Created by lideqing@xiaomi.com on 20-3-23
 */
public class QuickSort {
    int doOneSort(int a[], int start, int end) {
        int i = start;
        int middle = a[start];
        int j = end;
        if (start < end) {
            while (i < j) {
                while (j > i && a[j] > middle) {
                    --j;
                }
                if (j > i) {
                    a[i] = a[j];
                    ++i;
                }

                while (j > i && a[i] < middle) {
                    ++i;
                }
                if (i < j) {
                    a[j] = a[i];
                    --j;
                }

            }
            a[i] = middle;
        }
        return i;
    }

    private void sort(int a[], int start, int end) {
        if (start < end) {
            int middle = doOneSort(a, start, end);
            sort(a, start, middle - 1);
            sort(a, middle + 1, end);
        }
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] input = {5, 1, 3, 4, 90};
        quickSort.sort(input, 0, input.length - 1);
        for (int i = 0; i < input.length; ++i) {
            System.out.print(input[i] + " ");
        }
    }

}
