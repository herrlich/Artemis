public class Solution {
    public String getPermutation(int n, int k) {
        int total = 1;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; ++i) {
            total *= i;
            list.add(i);
        }
        if (n < 1 || n > 9 || k <= 0 || k > total) return null;
        StringBuilder sb = new StringBuilder();
        k = k - 1;
        for (int i = n; i >= 1; --i) {
            total = total / i;
            int tmp = k / total;
            sb.append(list.get(tmp));
            list.remove(tmp);
            k = k % total;
        }
        return new String(sb);
    }
}