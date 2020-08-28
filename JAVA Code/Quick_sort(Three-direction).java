import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class Solution {
    // Randomly shuffle the array
    private static void shuffleArray(int[] ar)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }


    ////////////////////////////////////////////////////////
    // Quick sort functions
    private static void exch(int[] nums, int i, int j) {
        int temp = nums[i];

        nums[i] = nums[j];
        nums[j] = temp;
    }


    private static int partition(int[] nums, int low, int high) {
        int i = low;
        int j = high + 1;

        int v = nums[low];

        while (true) {
            while (nums[++i] < v)
                if (i == high)
                    break;

            while (nums[--j] > v)
                if (j == low)
                    break;

            if (i >= j)
                break;

            exch(nums, i, j);
        }

        exch(nums, low, j);

        return j;
    }


    // QuickSort function (Standard quick sort)
    private static void quickSort(int[] nums, int low, int high) {
        if (high <= low)    return;

        // Do a partition to seperate the array into two parts
        int j = partition(nums, low, high);

        // Recursion
        quickSort(nums, low, j - 1);
        quickSort(nums, j + 1, high);
    }


    // Main function (Three-direction quick sort)
    private static void quickSort_td(int[] nums, int low, int high) {
        if (high <= low)    return;
        
        int lt = low, i = low + 1, gt = high;
        int v = nums[low];

        while (i <= gt) {
            if (nums[i] < v)       exch(nums, lt++, i++);
            else if (nums[i] > v)  exch(nums, i, gt--);
            else                   i++;
        }

        quickSort_td(nums, low, lt - 1);
        quickSort_td(nums, gt + 1, high);
    }


    /////////////////////////////////////////////////////////////
    // Main function 
    public void main(int[] nums) {

        shuffleArray(nums);
        quickSort(nums, 0, nums.length - 1);
        
    }
}