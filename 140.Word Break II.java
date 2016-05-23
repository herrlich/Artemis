public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0) return res;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j <= i; ++j) {
                if (dp[j] && wordDict.contains(s.substring(j, i + 1))) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        if (!dp[s.length()]) return res; //If the word can not be divided, then jus stop the program and save the time of DFS.
        List<String> tmp = new ArrayList<String>();
        tryBreak(s, 0, s.length(), wordDict, tmp, res);
        return res;
    }

    
    public void tryBreak(String s, int start, int end, Set<String> wordDict, List<String> tmp, List<String> res) {
        if (start == end) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tmp.size() - 1; ++i) {
                sb.append(tmp.get(i));
                sb.append(" ");
            }
            sb.append(tmp.get(tmp.size() -1));
            String ans = sb.toString();
            res.add(ans);
            return;
        }
        for (int i = start + 1; i <= end; ++i) {
            if (wordDict.contains(s.substring(start, i))) {
                tmp.add(s.substring(start, i));
                tryBreak(s, i, end, wordDict, tmp, res);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}


-----------------------------------------------------------------------------
// I think the following method is better, since I utilized the information in "dp" array to save time for useless searchings.

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> list = new ArrayList<String>();
        if (s == null || s.length() == 0) return list;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); ++i) {
            for (int j = 0; j <= i; ++j) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        if (!dp[s.length()]) return res; 
        getBreak(s, wordDict, list, dp, "");
        return list;
    }
    
    public void getBreak(String s, Set<String> wordDict, List<String> list, boolean[] dp, String words) {
        if (s.equals("")) {
            list.add(words.trim());
            return;
        }
        for (int i = s.length() - 1; i >= 0; --i) {
            if (wordDict.contains(s.substring(i, s.length())) && dp[i]) {
                String newwords = " " + s.substring(i, s.length()) + words;
                getBreak(s.substring(0, i), wordDict, list, dp, newwords);
            }
        }
    }
}