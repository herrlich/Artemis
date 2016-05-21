public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        double num = Math.log(n) / Math.log(3);
        return (Math.abs(num - Math.round(num)) < 1e-10);
    }
}