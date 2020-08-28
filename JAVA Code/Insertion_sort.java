class Solution {
    public static void InsertionSort(char[] ch) {
        for (int i = 1; i < ch.length; i++) {
            // Backup the item going to be inserted
            char backup = ch[i];

            // Find the right position for insertion
            int j;
            for (j = i - 1; j >= 0 && backup < ch[j]; j--) {
                ch[j + 1] = ch[j];
            }

            // Add item to its position
            ch[j + 1] = backup;
        }   
    }


    // Main function
    public void main(char[] n) {

        InsertionSort(n);
        
    }
}