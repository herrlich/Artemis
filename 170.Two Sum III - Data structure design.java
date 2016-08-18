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
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    private List<Integer> list = new ArrayList<Integer>();
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    if (map.containsKey(number)) map.put(number, map.get(number) + 1);
	    else {
	        list.add(number);
	        map.put(number, 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int i : list) {
	        if (map.containsKey(value - i) && (value != 2 * i || map.get(i) > 1)) return true;
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);