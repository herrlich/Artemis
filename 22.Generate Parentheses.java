public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n <= 0) return res;
        getPar(0, 0, n, "", res);
        return res;
    }
    
    public void getPar(int left, int right, int n, String tmp, List<String> res) {
        if (left == n) {
            for (int i = right; i < n; ++i) tmp += ")";
            res.add(tmp);
            return;
        }
        getPar(left + 1, right, n, tmp + "(", res);
        if (left > right) getPar(left, right + 1, n, tmp + ")", res);
    }
}