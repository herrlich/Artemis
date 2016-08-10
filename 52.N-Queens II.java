public class Solution {
    public int totalNQueens(int n) {
        int res = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) arr[i] = -1;
        res = getNum(arr, 0);
        return res;
    }
    
    public int getNum(int[] arr, int row) {
        if (row == arr.length) return 1;
        int sum = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (checkOK(arr, row, i)) {
                arr[row] = i;
                sum += getNum(arr, row + 1);
                arr[row] = -1;
            }
        }
        return sum;
    }
    
    public boolean checkOK(int[] arr, int row, int col) {
        for (int i = 0; i < row; ++i) {
            if (arr[i] == col) return false;
            if (arr[i] + i == row + col) return false;
            if (arr[i] - i == col - row) return false;
        }
        return true;
    }
}