public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null) return false;
        boolean[][] checked = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (checkWords(board, word, i , j, checked, 0)) return true;
            }
        }
        return false;
    }
    
    public boolean checkWords(char[][] board, String word, int x, int y, boolean[][] checked, int pos) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || checked[x][y]) return false;
        if (word.charAt(pos) != board[x][y]) return false;
        if (pos == word.length() - 1) return true;
        checked[x][y] = true;
        if (checkWords(board, word, x - 1, y, checked, pos + 1)) return true;
        if (checkWords(board, word, x + 1, y, checked, pos + 1)) return true;
        if (checkWords(board, word, x, y - 1, checked, pos + 1)) return true;
        if (checkWords(board, word, x, y + 1, checked, pos + 1)) return true;
        checked[x][y] = false;
        return false;
    }
}