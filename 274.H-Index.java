public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int num = 0;
        for (int i = citations.length - 1; i >= 0 ; --i) {
            if (citations[i] > num) ++num;
            else break;
        }
        return num;
    }
}

// better method
public class Solution {
    public int hIndex(int[] citations) {
        int[] arr = new int[citations.length + 1];
        for (int i = 0; i < citations.length; ++i) {
            if (citations[i] <= citations.length) ++arr[citations[i]];
            else ++arr[citations.length];
        }
        for (int i = citations.length; i >= 0; --i) {
            if (arr[i] >= i) return i;
            else arr[i - 1] += arr[i];
        }
        return 0;
    }
}