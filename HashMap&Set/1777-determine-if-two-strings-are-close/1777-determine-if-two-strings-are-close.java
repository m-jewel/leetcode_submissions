class Solution {
    public boolean closeStrings(String word1, String word2) {
        // Check if the lengths of the words are different
        if (word1.length() != word2.length()) {
            return false;
        }

        HashMap<Character, Integer> wrd1 = new HashMap<>();
        HashMap<Character, Integer> wrd2 = new HashMap<>();

        // Fill the frequency map for word1
        for (char w1 : word1.toCharArray()) {
            wrd1.put(w1, wrd1.getOrDefault(w1, 0) + 1);
        }

        // Fill the frequency map for word2
        for (char w2 : word2.toCharArray()) {
            wrd2.put(w2, wrd2.getOrDefault(w2, 0) + 1);
        }

        // Check if both maps have the same set of keys (characters)
        if (!wrd1.keySet().equals(wrd2.keySet())) {
            return false;
        }

        // Check if the frequency counts (values) are the same
        if (!wrd1.values().stream().sorted().toList().equals(wrd2.values().stream().sorted().toList())) {
            return false;
        }

        return true;
    }
}
