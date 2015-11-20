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
        if (buf == null || n <= 0) return 0;
        char[] tmp = new char[4];
        int pos = 0, len = 0;
        while (n >= 0) {
            len = read4(tmp);
            for (int i = 0; i < Math.min(len, n); ++i) buf[pos++] = tmp[i];
            if (len < 4) return pos;
            n -= 4;
        }
        return pos;
    }
}