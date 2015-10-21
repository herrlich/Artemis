/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
*/

public class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) return false;
        int start = 0, end = num.length() - 1;
        while (start < end) {
            char c1 = num.charAt(start);
            char c2 = num.charAt(end);
            ++start;
            --end;
            if (c1 == '6' && c2 == '9') continue;
            if (c1 == '9' && c2 == '6') continue;
            if (c1 == '8' && c2 == '8') continue;
            if (c1 == '0' && c2 == '0') continue;
            if (c1 == '1' && c2 == '1') continue;
            return false;
        }
        if (start == end) {
            char c = num.charAt(start);
            if (c != '0' && c != '1' && c != '8') return false;
        }
        return true;
    }
}