public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strings == null || strings.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strings.length; ++i) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < strings[i].length(); ++j) {
                sb.append(Integer.toString((strings[i].charAt(j) - strings[i].charAt(0) + 26) % 26));
                sb.append(" "); //otherwise "abc" will be the same with "am" => both "12";
            }
            String tmp = sb.toString();
            if (map.containsKey(tmp)) {
                map.get(tmp).add(strings[i]);
            }
            else {
                List<String> newlist = new ArrayList<String>();
                newlist.add(strings[i]);
                map.put(tmp, newlist);
            }
        }
        
        for (String s : map.keySet()) {
            Collections.sort(map.get(s));
            res.add(map.get(s));
        }
        return res;
    }
}

/* The above is a solution from the internet, belows are my first solution.
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strings == null || strings.length == 0) {
            return res;
        }
        boolean[] checked = new boolean[strings.length];
        for (int i = 0; i < strings.length; ++i) {
            if (checked[i]) continue;
            int len = strings[i].length();
            List<String> tmp = new ArrayList<String>();
            tmp.add(strings[i]);
            for (int j = i + 1; j < strings.length; ++j) {
                if (strings[j].length() == len) {
                    boolean same = true;
                    int dist = (strings[i].charAt(0) - strings[j].charAt(0) + 26) % 26;
                    for (int k = 0; k < len; ++k) {
                        if ((strings[i].charAt(k) - strings[j].charAt(k) + 26) % 26 == dist) continue;
                        else {
                            same = false;
                            break;
                        }
                    }
                    if (same) {
                        checked[j] = true;
                        tmp.add(strings[j]);
                    }
                }
            }
            Collections.sort(tmp);
            res.add(tmp);
        }
        return res;
    }
}
*/