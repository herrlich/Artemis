public class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) return false;
        HashSet<Integer> set = new HashSet<Integer>();
        int tmp = n;
        while (true) {
            int sum = 0;
            while (tmp > 0) {
                sum += (tmp % 10) * (tmp % 10);
                tmp /= 10;
            }
            if (set.contains(sum)) {
                if (sum == 1) return true;
                else return false;
            }
            else set.add(sum);
            tmp = sum;
        }
    }
}