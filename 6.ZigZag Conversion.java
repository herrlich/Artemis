public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() < 2 || numRows < 2) return s;
        String[] arr = new String[numRows];
        Arrays.fill(arr, "");
        int row = 0, step = 1;
        for (int i = 0; i < s.length(); ++i) {
            arr[row] += s.charAt(i);
            row += step;
            if (row >= numRows) {
                step = -1;
                row = numRows - 2;
            }
            if (row < 0) {
                step = 1;
                row = 1;
            }
        }
        
        String res = "";
        for (int i = 0; i < numRows; ++i) res += arr[i];
        return res;
    }
}

//Another method

public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() < 2) return s;
        if (numRows < 2) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j <= s.length() / (2 * numRows - 2); ++j) {
                if (i == 0) {
                    if ((2 * numRows - 2) * j < s.length()) {
                        sb.append(s.charAt((2 * numRows - 2) * j));
                        continue;
                    }
                    else break;
                }
                if (i == numRows - 1) {
                    if ((2 * numRows - 2) * j + numRows - 1 < s.length()) {
                        sb.append(s.charAt((2 * numRows - 2) * j + numRows - 1));
                        continue;
                    }
                    else break;
                }
                if ((2 * numRows - 2) * j + i < s.length()) {
                    sb.append(s.charAt((2 * numRows - 2) * j + i));
                }
                else break;
                if ((2 * numRows - 2) * (j + 1) - i < s.length()) {
                    sb.append(s.charAt((2 * numRows - 2) * (j + 1) - i));
                }
                else break;
            }
        }
        return new String(sb);
    }
}
