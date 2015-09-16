public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return null;
        if (num1.equals("0") || num2.equals("0")) return "0";
        int len1 = num1.length(), len2 = num2.length();
        int len = len1 + len2;
        int[] res = new int[len];
        for (int i = 0; i < len1; ++i) {
            int n1 = num1.charAt(len1 - 1 - i) - '0';
            for (int j = 0; j < len2; ++j) {
                int n2 = num2.charAt(len2 - 1 - j) - '0';
                res[len - 1 - i - j] += n1 * n2;
            }
        }
        for (int i = len - 1; i > 0; --i) {
            res[i - 1] += (res[i] / 10);
            res[i] = res[i] % 10;
        }
        StringBuilder sb = new StringBuilder();
        if (res[0] != 0) sb.append(res[0]);
        for (int i = 1; i < len; ++i) sb.append(res[i]);
        return sb.toString();
    }
}