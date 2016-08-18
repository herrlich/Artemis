/*The API: int read4(char *buf) reads 4 characters at a time from a file. 

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file. 

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file. 

Note:
 The read function will only be called once for each test case. 
*/

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if (buf == null || n < 0) return 0;
        int res = 0;
        char[] tmp = new char[4];
        while (n > 0) {
            int num = read4(tmp);
            for (int i = 0; i < Math.min(num, n); ++i) buf[res++] = tmp[i];
            if (num < 4) break;
            n -= 4;
        }
        return res;
    }
}