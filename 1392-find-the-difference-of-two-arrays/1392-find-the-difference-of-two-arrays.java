class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Create sets to store distinct values from both arrays
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        // Add elements from nums1 to set1
        for (int num : nums1) {
            set1.add(num);
        }
        
        // Add elements from nums2 to set2
        for (int num : nums2) {
            set2.add(num);
        }
        
        // Create lists for the result
        List<Integer> diff1 = new ArrayList<>();
        List<Integer> diff2 = new ArrayList<>();
        
        // Find elements in set1 that are not in set2
        for (int num : set1) {
            if (!set2.contains(num)) {
                diff1.add(num);
            }
        }
        
        // Find elements in set2 that are not in set1
        for (int num : set2) {
            if (!set1.contains(num)) {
                diff2.add(num);
            }
        }
        
        // Prepare the final answer
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(diff1);
        answer.add(diff2);
        
        return answer;
    }
}
