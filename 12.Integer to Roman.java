public class Solution {
    public String intToRoman(int num) {
        if (num < 1) return null;
        
        StringBuilder sb = new StringBuilder();
        
        String[] str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        for (int i = 0; i < str.length; ++i) {
            while (num >= val[i]) {
                sb.append(str[i]);
                num -= val[i];
            }
        }
        
        return new String(sb);
    }
}