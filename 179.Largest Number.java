public class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder res = new StringBuilder();
        if (nums == null || nums.length == 0) return new String(res);
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) str[i] = String.valueOf(nums[i]);
        Arrays.sort(str, new Cmp());
        for (int i = 0; i < str.length; ++i) res.append(str[i]);
        String ans = new String(res);
        int start = 0;
        while (start < ans.length()) {
            if (ans.charAt(start) != '0') break;
            else ++start;
        }
        if (start == ans.length()) return "0";
        return ans.substring(start);
    }
}

class Cmp implements Comparator<String>{  
    @Override
    public int compare(String a, String b) {
        String str1 = a + b;
        String str2 = b + a;
        for (int i = 0; i < str1.length(); ++i) {
            if (str1.charAt(i) > str2.charAt(i)) return -1;
            if (str1.charAt(i) < str2.charAt(i)) return 1;
        }
        return 0;
    }
}