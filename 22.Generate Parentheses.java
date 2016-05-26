public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n <= 0) return res;
        generate(res, 0, 0, n, "");
        return res;
    }
    
    public void generate(List<String> list, int left, int right, int n, String s) {
        if (left == n) {
            for (int i = 0; i < n - right; ++i) s = s + ")";
            list.add(s);
        }
        else {
            generate(list, left + 1, right, n, s + "(");
            if (left > right) generate(list, left, right + 1, n, s + ")");
        }
    }
}