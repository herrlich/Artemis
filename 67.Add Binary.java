public class Solution {
    public String addBinary(String a, String b) {
        if (a.length() > b.length()) return addBinary(b, a);
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int lena = a.length(), lenb = b.length();
        for (int i = 0; i < a.length(); ++i) {
            int aint = a.charAt(lena - 1 - i) - '0';
            int bint = b.charAt(lenb - 1 - i) - '0';
            int tmp = (aint + bint + carry) % 2;
            carry = (aint + bint + carry) / 2;
            sb.insert(0, String.valueOf(tmp));
        }
        for (int i = lenb - lena - 1; i >= 0; --i) {
            int bint = b.charAt(i) - '0';
            int tmp = (bint + carry) % 2;
            carry = (bint + carry) / 2;
            sb.insert(0, String.valueOf(tmp));
        }
        if (carry == 1) sb.insert(0, "1");
        return new String(sb);
    }
}