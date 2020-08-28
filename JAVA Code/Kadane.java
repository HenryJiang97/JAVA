class Solution {
    private int kadane(int[] arr) {
        int MAX = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = Math.max(sum + arr[i], arr[i]);
            MAX = Math.max(MAX, sum);
        }
        return MAX;
    }
}