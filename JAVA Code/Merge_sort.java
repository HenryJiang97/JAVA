import java.util.*;

class Solution {
    private static char[] backup;

    public static void Merge(char[] ch, int lo, int mid, int hi) {
        int a = lo;
        int b = mid + 1;

        // Copy the array
        backup = Arrays.copyOf(ch, ch.length);

        // Merge
        for (int i = lo; i <= hi; i++) {
            if (a > mid)
                ch[i] = backup[b++];
            else if (b > hi)
                ch[i] = backup[a++];
            else if (backup[a] > backup[b])
                ch[i] = backup[b++];
            else
                ch[i] = backup[a++];
        }
    }

    public static void divide(char[] ch, int lo, int hi) {
        if (hi <= lo)    return;

        int mid = (lo + hi) / 2;

        // Recursion
        divide(ch, lo, mid);
        divide(ch, mid + 1, hi);

        // Merge
        Merge(ch, lo, mid, hi);
    }


    // Main function
    public void main(char[] n) {

        // Initialize backup array
        backup = new char[n.length];

        divide(n, 0, n.length - 1);
        
    }
}