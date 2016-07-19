public class Solution {
    public int getSum(int a, int b) {
        int ans = 0;
        while (b != 0) {
            ans = a ^ b;
            b = (a & b) << 1;
            a = ans;
        }
        return ans;
    }
}