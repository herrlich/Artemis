public class Solution {
    public String numberToWords(int num) {
        if (num < 0) return null;
        if (num == 0) return "Zero";
        
        String res = "";
        int round = 0, tmp = 0;
        while (num > 0) {
            tmp = num % 1000;
            num = num / 1000;
            if (tmp > 0) res = ThreeDigits(tmp, round) + " " + res;
            ++round;
        }
        return res.trim();
    }
    
    public String ThreeDigits(int num, int round) {
        StringBuilder sb = new StringBuilder();
        String[] str = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        int[] val = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50, 60, 70, 80, 90};
        String[] ends = {"", "Thousand", "Million", "Billion"};
        if (num / 100 > 0) {
            sb.append(str[num / 100 - 1] + " Hundred");
            num = num % 100;
        }
        int n1 = num, n2 = 0;
        if (num > 20) {
            n2 = num % 10;
            n1 = num - n2;
        }
        for (int i = val.length - 1; i >= 0; --i) {
            if (n1 == val[i] || (n2 != 0 && n2 == val[i])) {
                if (sb.length() > 0) sb.append(" ");
                sb.append(str[i]);
            }
        }
        String s = new String(sb);
        return (s + " " + ends[round]).trim();
    }
}