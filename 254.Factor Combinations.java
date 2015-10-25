/*
Numbers can be regarded as product of its factors. For example, 
8 = 2 x 2 x 2;
  = 2 x 4.


Write a function that takes an integer n and return all possible combinations of its factors. 

Note: 

1.Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2]. 
2.You may assume that n is always positive. 
3.Factors should be greater than 1 and less than n.


Examples: 
 input: 1
 output: 

[]

input: 37
 output: 
[]

input: 12
 output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]

input: 32
 output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
*/

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n <= 1) return res;
        res = getFrom(n, 2);
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(n);
        res.remove(tmp);
        return res;
    }
    
    public List<List<Integer>> getFrom(int n, int low) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (n < low) return list;
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(n);
        list.add(tmp);
        for (int i = low; i <= (int)Math.sqrt(n) + 1; ++i) {
            if (n % i == 0 && n / i >= i) {
                List<List<Integer>> cur = getFrom(n / i, i);
                for (int j = 0; j < cur.size(); ++j) {
                    tmp = new ArrayList<Integer>();
                    tmp.add(i);
                    tmp.addAll(cur.get(j));
                    list.add(tmp);
                }
            }
        }
        return list;
    }
}