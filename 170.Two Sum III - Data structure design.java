/*
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value. 

For example,

add(1); add(3); add(5);
find(4) -> true
find(7) -> false
*/

public class TwoSum {
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    if (map.containsKey(number)) {
	        int tmp = map.get(number);
	        map.put(number, tmp + 1);
	    }
	    else map.put(number, 1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	        int k = entry.getKey();
	        if (map.containsKey(value - k) && (value != 2 * k || (value == 2 * k && entry.getValue() > 1))) {
	            return true;
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);