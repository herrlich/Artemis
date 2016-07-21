public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<String>();
        if (s == null || s.length() < 3 || s.length() > 12) return list;
        getIP(s, list, "", 4);
        return list;
    }
    
    public void getIP(String s, List<String> list, String tmp, int num) {
        if (num == 1) {
            if (check(s)) {
                list.add(tmp + s);
                return;
            }
        }
        for (int i = 1; i < Math.min(4, s.length()); ++i) {
            String cur = s.substring(0, i);
            if (check(cur)) {
                getIP(s.substring(i, s.length()), list, tmp + cur + ".", num - 1);
            }
        }
    }
    
    public boolean check(String s) {
        if (s.length() <= 0 || (s.charAt(0) == '0' && s.length() > 1)) return false;
        int num = Integer.parseInt(s);
        if (num >= 0 && num <= 255) return true;
        else return false;
    }
}