public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '1') {
                    ++res;
                    bfs(grid, i, j);
                }
            }
        }
        return res;
    }
    
    private void bfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) return;
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            bfs(grid, i - 1, j);
            bfs(grid, i + 1, j);
            bfs(grid, i, j - 1);
            bfs(grid, i, j + 1);
        }
    }
}