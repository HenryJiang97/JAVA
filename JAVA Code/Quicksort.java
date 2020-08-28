import java.util.*;

public class Main {
    private static void quicksort(int[] arr, int lo, int hi) {
        if (lo >= hi)    return;
        int mid = partition(arr, lo, hi);

        quicksort(arr, lo, mid - 1);
        quicksort(arr, mid + 1, hi);
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int i = lo + 1, j = hi;

        while (true) {
            while (j >= lo + 1 && arr[j] >= pivot)    j--;
            while (i <= hi && arr[i] <= pivot)    i++;
            if (i >= j)    break;

            // Exchange arr[i] and arr[j]
            exchange(arr, i, j);
        }

        // Exchange pivot and arr[j]
        exchange(arr, lo, j);

        return j;
    }

    private static void exchange(int[] arr, int p1, int p2) {
        int temp = arr[p1];    arr[p1] = arr[p2];    arr[p2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {7, 2, 1, 6, 8, 5, 2, 4};

        quicksort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }
}