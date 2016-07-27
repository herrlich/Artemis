public class Solution {
    public String countAndSay(int n) {
        if (n < 1) return "";
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        for (int i = 1; i < n; ++i) {
            int len = queue.size();
            int count = 1, cur = queue.poll();
            for (int j = 1; j < len; ++j) {
                int tmp = queue.poll();
                if (cur == tmp) ++count;
                else {
                    queue.offer(count);
                    queue.offer(cur);
                    count = 1;
                    cur = tmp;
                }
            }
            queue.offer(count);
            queue.offer(cur);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : queue) sb.append(i);
        return new String(sb);
    }
}