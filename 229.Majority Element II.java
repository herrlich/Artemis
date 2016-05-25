public class Solution {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return list;
        int n1 = 0, n2 = 0;
        int c1 = 1, c2 = 0;
        int pos = 0;
        n1 = nums[pos++];
        while (pos < nums.length) {
        	if (nums[pos] == n1) {
        		++c1;
        		++pos;
        	}
        	else break;
        }
        if (pos == nums.length) {
        	list.add(n1);
        	return list;
        }
        
        n2 = nums[pos++];
        c2 = 1;
        while (pos < nums.length) {
        	if (nums[pos] == n2) {
        		++c2;
        		++pos;
        	}
        	else break;
        }
        if (pos == nums.length) {
        	if (c1 > nums.length / 3) list.add(n1);
        	if (c2 > nums.length / 3) list.add(n2);
        	return list;
        }
        for (int i = pos; i < nums.length; ++i) {
            if (nums[i] == n1) {
                ++c1;
                continue;
            }
            if (nums[i] == n2) {
                ++c2;
                continue;
            }
        	if (c1 == 0) {
	        	n1 = nums[i];
	        	++c1;
        	}
        	else {
        	    if (c2 == 0) {
	        		n2 = nums[i];
	        		++c2;
        		}
        		else {
        		    --c1;
        		    --c2;
        		}
        	}
        }
        c1 = 0; c2 = 0;
        for (int i = 0; i < nums.length; ++i) {
        	if (nums[i] == n1) ++c1;
        	if (nums[i] == n2) ++c2;
        }
        if (c1 > nums.length / 3) list.add(n1);
        if (c2 > nums.length / 3) list.add(n2);
        return list;
    }
}