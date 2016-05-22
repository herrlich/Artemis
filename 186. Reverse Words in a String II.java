Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters. 

The input string does not contain leading or trailing spaces and the words are always separated by a single space. 

For example,
 Given s = "the sky is blue",
 return "blue is sky the". 

Could you do it in-place without allocating extra space? 


public class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length);
        int start = 0, end = 0;
        while (start < s.length) {
            end = start + 1;
            while (end < s.length && s[end] != ' ') ++end;
            reverse(s, start, end);
            start = end + 1;
        }
    }
    
    public void reverse(char[] s, int left, int right) {
        for (int i = left; i < (left + right) / 2; ++i) {
            char tmp = s[i];
            s[i] = s[right - 1 - (i - left)];
            s[right - 1 - (i - left)] = tmp;
        }
    }
}