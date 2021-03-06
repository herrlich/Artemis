public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    ++res;
                    checkAround(grid, i ,j);
                }
            }
        }
        return res;
    }
    
    public void checkAround(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return;
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
            checkAround(grid, x - 1, y);
            checkAround(grid, x + 1, y);
            checkAround(grid, x, y - 1);
            checkAround(grid, x, y + 1);
        }
        
    }
}