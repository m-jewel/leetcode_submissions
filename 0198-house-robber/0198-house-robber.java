class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        int recent = Math.max(nums[0], nums[1]);  // Rob the house with more money
        int old = nums[0];  // Only one house to rob
        
        for (int i = 2; i < n; i++) {
            int current = Math.max(recent, nums[i] + old);
            old = recent;
            recent = current;
        }
        
        return recent;
    }
}
