/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n. 

For example,
 Given n = 2, return ["11","69","88","96"]. 
*/

public class Solution {
    public List<String> findStrobogrammatic(int n) {
        if (n < 1) return new ArrayList<String>();
        List<String> res = getnum(n);
        int pos = 0, len = res.size();
        if (n == 1) return res;
        for (int i = 0; i < len; ++i) {
            if (res.get(pos).charAt(0) == '0') {
                res.remove(pos);
            }
            else ++pos;
        }
        return res;
    }
    public List<String> getnum(int n) {
        if (n == 0) return new ArrayList<String>();
        if (n == 1) {
            List<String> res = new ArrayList<String>();
            res.add("1"); res.add("0"); res.add("8");
            return res;
        }
        if (n == 2) {
            List<String> res = new ArrayList<String>();
            String s1 = "69";
            String s2 = "96";
            String s3 = "00";
            String s4 = "11";
            String s5 = "88";
            res.add(s1); res.add(s2); res.add(s3);
            res.add(s4); res.add(s5);
            return res;
        }
        List<String> res = new ArrayList<String>();
        List<String> tmp = getnum(n - 2);
        for (int i = 0; i < tmp.size(); ++i) {
            String mid = tmp.get(i);
            String s1 = "6" + mid + "9";
            String s2 = "9" + mid + "6";
            String s3 = "0" + mid + "0";
            String s4 = "1" + mid + "1";
            String s5 = "8" + mid + "8";
            res.add(s1); res.add(s2); res.add(s3);
            res.add(s4); res.add(s5);
        }
        return res;
    }
}