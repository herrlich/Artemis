public class Solution {
    public String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            --n;
            char c = (char)(n % 26 + 'A');
            sb.insert(0, c);
            n = n / 26;
        }
        return new String(sb);
    }
}