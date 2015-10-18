public class WordDictionary {
    TreeNode root = new TreeNode('s');
    
    public WordDictionary() {}

    // Adds a word into the data structure.
    public void addWord(String word) {
        if (word == null || word.length() == 0) return;
        TreeNode par = root, cur = null;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            cur = par.map.get(c);
            if (cur == null) {
                cur = new TreeNode(c);
                par.map.put(c, cur);
            }
            par = cur;
        }
        par.leaf = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        return searchNode(root, word);
    }
    
    private boolean searchNode(TreeNode root, String word) {
        TreeNode par = root, cur = null;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (c != '.') {
                cur = par.map.get(c);
                if (cur == null) return false;
                else par = cur;
            }
            else {
                for (char ch : par.map.keySet()) {
                    TreeNode t = par.map.get(ch);
                    if (searchNode(t, word.substring(i + 1))) return true;
                }
                return false;
            }
        }
        return par.leaf;
    }
}

class TreeNode {
    char val;
    HashMap<Character, TreeNode> map;
    boolean leaf = false;
    
    public TreeNode(char val) {
        this.val = val;
        map = new HashMap<Character, TreeNode>();
    }
}
// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");