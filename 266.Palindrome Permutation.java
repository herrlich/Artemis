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
        int[] arr = new int[256];
        for (int i = 0; i < s.length(); ++i) arr[(int)s.charAt(i)] ^= 1;
        int numOf1 = 0;
        for (int i = 0; i < 256; ++i) if (arr[i] == 1) ++numOf1;
        if (numOf1 == 0 || (numOf1 == 1 && s.length() % 2 == 1)) return true;
        else return false;
    }
}