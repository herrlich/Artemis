public class Solution {
    public List<Integer> getRow(int rowIndex) {
        ++rowIndex;
        List<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 1) return list;
        int[] arr = new int[rowIndex];
        arr[0] = 1;
        for (int i = 1; i < rowIndex; ++i) {
            for (int j = i; j >= 1; --j) {
                arr[j] += arr[j - 1];
            }
        }
        for (int i = 0; i < rowIndex; ++i) list.add(arr[i]);
        return list;
    }
}