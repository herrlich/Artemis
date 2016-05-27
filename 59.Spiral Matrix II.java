public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int start = 0, end = n - 1;
        int num = 1;
        while (start < end) {
            for (int i = start; i < end; ++i) res[start][i] = num++;
            for (int i = start; i < end; ++i) res[i][end] = num++;
            for (int i = end; i > start; --i) res[end][i] = num++;
            for (int i = end; i > start; --i) res[i][start] = num++;
            ++start;
            --end;
        }
        if (start == end) res[start][start] = num;
        return res;
    }
}

------------------------------------------------------------------------------------
public class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 1) return new int[0][0];
        int[][] res = new int[n][n];
        int x = 0, y = 0;
        int dir = 0;
        for (int i = 1; i <= n * n; ++i) {
            res[x][y] = i;
            if (dir == 0) {
                if (y + 1 < n && res[x][y + 1] == 0) ++y;
                else {
                    ++x;
                    dir = 1;
                }
                continue;
            }
            if (dir == 1) {
                if (x + 1 < n && res[x + 1][y] == 0) ++x;
                else {
                    --y;
                    dir = 2;
                }
                continue;
            }
            if (dir == 2) {
                if (y - 1 >= 0 && res[x][y - 1] == 0) --y;
                else {
                    --x;
                    dir = 3;
                }
                continue;
            }
            if (dir == 3) {
                if (x - 1 >= 0 && res[x - 1][y] == 0) --x;
                else {
                    ++y;
                    dir = 0;
                }
                continue;
            }
        }
        return res;
    }
}