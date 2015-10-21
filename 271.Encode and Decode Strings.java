/*
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function: 
string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function: vector<string> decode(string s) {
  //... your code
  return strs;
}


So Machine 1 does: 
string encoded_string = encode(strs);


and Machine 2 does: 
vector<string> strs2 = decode(encoded_string);


strs2 in Machine 2 should be the same as strs in Machine 1. 

Implement the encode and decode methods. 

Note:

1.The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
2.Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
3.Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
*/

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null) return "-1#";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); ++i) {
            sb.append(strs.get(i).length());
            sb.append("#");
            sb.append(strs.get(i));
        }
        return new String(sb);
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s.equals("-1#")) return null;
        List<String> res = new ArrayList<String>();
        int pos = 0; int end = 0;
        while (pos < s.length()) {
            while (s.charAt(end) != '#') ++end;
            int len = Integer.parseInt(s.substring(pos, end));
            if (len == 0) {
                res.add("");
                pos += 2;
                end = pos;
                continue;
            }
            pos = end + 1;
            String tmp = s.substring(pos, pos + len);
            res.add(tmp);
            pos += len;
            end = pos;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));