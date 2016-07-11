public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) return 0;
        
        String[] v1 = version1.split("\\."); // the escape character here is really really important.
        String[] v2 = version2.split("\\.");
        
        int i = 0;
        int len1 = v1.length;
        int len2 = v2.length;
        
        while (i < len1 || i < len2) {
            int n1 = (i < len1) ? Integer.parseInt(v1[i]) : 0;
            int n2 = (i < len2) ? Integer.parseInt(v2[i]) : 0;
            if (n1 < n2) return -1;
            else {
                if (n1 > n2) return 1;
                else ++i;
            }
        }
        return 0;
    }
}