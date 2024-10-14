import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Step 1: Create a frequency map to count occurrences of each number
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a set to check for unique occurrence counts
        HashSet<Integer> occurrenceSet = new HashSet<>();
        for (int count : frequencyMap.values()) {
            // If the count is already in the set, return false
            if (!occurrenceSet.add(count)) {
                return false;
            }
        }

        // Step 3: If all counts are unique, return true
        return true;
    }
}
