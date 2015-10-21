/*
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language. 

For example,
 Given the following words in dictionary, 
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]



The correct order is: "wertf".

Note:

1.You may assume all letters are in lowercase.
2.If the order is invalid, return an empty string.
3.There may be multiple valid order of letters, return any one of them is fine.
*/

//单词之间按照字典序排序，但是每个单词的字母之间并没有按照字典序

public class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return null;
        HashMap<Character, Integer> indegree = new HashMap<Character, Integer>();
        HashMap<Character, Set<Character>> graph = new HashMap<Character, Set<Character>>();
        StringBuilder sb = new StringBuilder();
        int startnum = 0;
        for (int i = 0; i < words.length; ++i) {
            if (words[i].length() != 0) {
                startnum = i;
                break;
            }
        }
        String tmp = words[startnum];
        for (int i = 0; i < tmp.length(); ++i) {
            char tmpch = tmp.charAt(i);
            if (!graph.containsKey(tmpch)) {
                Set<Character> set = new HashSet<Character>();
                graph.put(tmpch, set);
            }
            if (!indegree.containsKey(tmpch)) {
                indegree.put(tmpch, 0);
            }
        }
        for (int i = startnum; i < words.length; ++i) {
            String next = words[i];
            for (int j = 0; j < next.length(); ++j) {
                char tmpch = next.charAt(j);
                if (!graph.containsKey(tmpch)) {
                    Set<Character> set = new HashSet<Character>();
                    graph.put(tmpch, set);
                }
                if (!indegree.containsKey(tmpch)) {
                    indegree.put(tmpch, 0);
                }
            }
            
            int pos = 0;
            while (pos < tmp.length() && pos < next.length()) {
                if (tmp.charAt(pos) != next.charAt(pos)) break;
                ++pos;
            }
            if (pos >= tmp.length() || pos >= next.length()) continue;
            char start = tmp.charAt(pos);
            char cur = next.charAt(pos);

            if (!graph.get(start).contains(cur))
                indegree.put(cur, indegree.get(cur) + 1);
            Set<Character> startset = graph.get(start);
            startset.add(cur);
            if (!graph.containsKey(cur)) {
                Set<Character> set = new HashSet<Character>();
                graph.put(cur, set);
            }
            tmp = next;
        }
        
        Queue<Character> queue = new LinkedList<Character>();
        int totalchar = 0;
        for (char c : indegree.keySet()) {
            System.out.println(c + "\t" + indegree.get(c));
            ++totalchar;
            if (indegree.get(c) == 0) {
                indegree.put(c, -1);
                queue.add(c);
            }
        }
        
        for (int i = 0; i < totalchar; ++i) {
            if (queue.isEmpty()) return "";
            char node = queue.poll();
            sb.append(node);
            Set<Character> nodeset = graph.get(node);
            if (nodeset.isEmpty()) continue;
            for (char c : nodeset) {
                int val = indegree.get(c);
                --val;
                if (val == 0) {
                    queue.add(c);
                    indegree.put(c, -1);
                }
                else indegree.put(c, val);
            }
        }
        if (!queue.isEmpty()) return "";
        String res = new String(sb);
        return res;
    }
}