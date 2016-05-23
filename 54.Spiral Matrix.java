public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) return list;
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
        int x = 0, y = 0;
        while (left <= right && up <= down) {
            for (int i = left; i <= right; ++i) list.add(matrix[up][i]);
            for (int i = up + 1; i <= down; ++i) list.add(matrix[i][right]);
            if (up != down) {
                for (int i = right - 1; i >= left; --i) list.add(matrix[down][i]);
            }
            if (left != right) {
                for (int i = down - 1; i >= up + 1; --i) list.add(matrix[i][left]);
            }
            ++left; --right;
            ++up; --down;
        }
        return list;
    }
}