public class ValidWordAbbr {
    String[] dictionary;

    public ValidWordAbbr(String[] dictionary) {
        this.dictionary = dictionary;
    }

    public boolean isUnique(String word) {
        if (word == null || word.length() == 0) return false;
        int len = word.length();
        for (int i = 0; i < dictionary.length; ++i) {
            if (dictionary[i].length() == len) {
                if (word.charAt(0) == dictionary[i].charAt(0) && word.charAt(len - 1) == dictionary[i].charAt(len - 1)) {
                    if (!word.equals(dictionary[i])) {//A word's abbreviation is unique if no OTHER word from the dictionary has the same abbreviation.
                        return false;
                    }
                }
            }
        }
        return true;
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");