/* Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True. 

Hint:
1.Consider the palindromes of odd vs even length. What difference do you notice?
2.Count the frequency of each character.
3.If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
*/

public class Solution {
    public boolean canPermutePalindrome(String s) {
	if (s == null) return false;
        int[] chararray = new int[256];
        char tmp;
        boolean flag = false;
        for (int i = 0; i < s.length(); ++i) {
            tmp = s.charAt(i);
            chararray[(int)tmp] += 1;
        }
        for (int i = 0; i < 256; ++i) {
            if (chararray[i] % 2 == 1) {
                if (flag) return false;
                else flag = true;
            }
        }
        return true;
    }
}