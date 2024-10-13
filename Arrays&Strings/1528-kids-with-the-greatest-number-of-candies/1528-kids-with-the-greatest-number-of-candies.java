class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = candies[0];
        
        // Loop through the array to find the maximum candy count
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > maxCandy) {
                maxCandy = candies[i]; 
            }
        }

        List<Boolean> result = new ArrayList<>();
        
        // Loop through the array again to compare each candy count with maxCandy
        for (int candy : candies) {
            // Check if adding extraCandies makes it equal to or greater than maxCandy
            if (candy + extraCandies >= maxCandy) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}
