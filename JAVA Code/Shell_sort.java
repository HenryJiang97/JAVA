class Solution {
    public static void ShellSort(char[] ch) {
        int n = ch.length;
        int h = 1;

        // 1, 4, 7, 13, ...
        while (h < n / 3)
            h = h * 3 + 1;
        
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                // Insertion
                for (int j = i; j >= h && ch[j] < ch[j - h]; j -= h) {
                    // Exchange
                    char temp = ch[j];
                    ch[j] = ch[j - h];
                    ch[j - h] = temp;
                }
            }

            h /= 3;
        }
    }


    // Main function
    public void main(char[] n) {

        ShellSort(n);
        
    }
}