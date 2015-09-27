public class Solution {
    public int numTrees(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                array[i] += array[j] * array[i - 1 - j]; 
            }
        }
        return array[n];
    }
}