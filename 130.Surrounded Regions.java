public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[][] visited = new boolean[m][n];
        int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    List<Integer> list = new ArrayList<Integer>();
                    boolean surround = true;
                    visited[i][j] = true;
                    queue.add(i * n + j);
                    while (!queue.isEmpty()) {
                        int tmp = queue.poll();
                        list.add(tmp);
                        for (int k = 0; k < 4; ++k) {
                            int x = tmp / n + dir[k][0];
                            int y = tmp % n + dir[k][1];
                            if (x < 0 || x >= m || y < 0 || y >= n) {
                                surround = false;
                                continue;
                            }
                            if (board[x][y] == 'O' && !visited[x][y]) {
                                queue.add(x * n + y);
                                visited[x][y] = true;
                            }
                        }
                    }
                    
                    if (surround) {
                        for (int tmp : list) {
                            board[tmp / n][tmp % n] = 'X';
                        }
                    }
                }
            }
        }
    }
}