public class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) return false;
        Set<Integer> set = new HashSet<Integer>();
        int res = 0, tmp = 0;
        while (!set.contains(n)) {
            set.add(n);
            if (n == 1) return true;
            res = 0;
            while (n > 0) {
                tmp = n % 10;
                res += tmp * tmp;
                n = n / 10;
            }
            n = res;
        }
        return false;
    }
}