public class Solution {
    public int superPow(int a, int[] b) {
        if (a <= 0 || b.length <= 0) return 1;
        int res = 1, round = a % 1337;
        for (int i = 0; i < b.length; ++i) {
            int tmp = 1;
            for (int j = 0; j < b[b.length - 1 - i]; ++j) {
                tmp = (tmp * round) % 1337;
            }
            res = (res * tmp) % 1337;
            tmp = round;
            for (int k = 0; k < 9; ++k) {
                round = (round * tmp) % 1337;
            }
        }
        return res;
    }
}