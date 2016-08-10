public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (n <= 0) return res;
        int[] array = new int[n];
        for (int i = 0; i < n; ++i) array[i] = -1;
        getQueens(0, array, res);
        return res;
    }
    
    public void getQueens(int row, int[] arr, List<List<String>> res) {
        if (row == arr.length) {
            List<String> tmp = new ArrayList<String>();
            for (int r = 0; r < arr.length; ++r) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arr.length; ++i) {
                    if (i == arr[r]) sb.append("Q");
                    else sb.append(".");
                }
                tmp.add(new String(sb));
            }
            res.add(tmp);
            return;
        }
        for (int i = 0; i < arr.length; ++i) {
            if (checkOK(arr, row, i)) {
                arr[row] = i;
                getQueens(row + 1, arr, res);
                arr[row] = -1;
            }
        }
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