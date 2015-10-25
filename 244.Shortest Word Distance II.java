/*
This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"]. 

Given word1 = ¡°coding¡±, word2 = ¡°practice¡±, return 3.
 Given word1 = "makes", word2 = "coding", return 1. 

Note:
 You may assume that word1 does not equal to word2, and word1 and word2 are both in the list. 
*/

public class WordDistance {
    private HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    
    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; ++i) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            }
            else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int p1 = 0, p2 = 0;
        int dist = Integer.MAX_VALUE;
        while (p1 < l1.size() && p2 < l2.size()) {
            dist = Math.min(dist, Math.abs(l1.get(p1) - l2.get(p2)));
            if (l1.get(p1) > l2.get(p2)) ++p2;
            else ++p1;
        }
        return dist;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");