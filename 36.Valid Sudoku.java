public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return false;
        int[] row = new int[9];
        int[] col = new int[9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') ++row[(board[i][j] - '0') - 1];
                if (board[j][i] != '.') ++col[(board[j][i] - '0') - 1];
            }
            for (int k = 0; k < 9; ++k) {
                if (row[k] > 1 || col[k] > 1) return false;
                row[k] = 0;
                col[k] = 0;
            }
        }
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                for (int k = 0; k < 3; ++k) {
                    for (int t = 0; t < 3; ++t) {
                        if (board[3 * i + k][3 * j + t] != '.')
                            ++row[(board[3 * i + k][3 * j + t] - '0') - 1];
                    }
                }
                for (int k = 0; k < 9; ++k) {
                    if (row[k] > 1) return false;
                    row[k] = 0;
                }
            }
        }
        return true;
    }
}