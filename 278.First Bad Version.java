/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}


// Another method

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n < 0) return -1;
        return findFirst(1, n);
    }
    
    private int findFirst(int start, int end) {
        if (start == end) return start;
        int mid = start + (end - start) / 2;
        if (isBadVersion(mid)) return findFirst(start, mid);
        else return findFirst(mid + 1, end);
    }
}