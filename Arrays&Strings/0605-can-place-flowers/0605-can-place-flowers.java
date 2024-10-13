class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        
        int count = 0; 
        
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean isLeftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
                boolean isRightEmpty = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
                
                // If both neighbors are empty, plant a flower here
                if (isLeftEmpty && isRightEmpty) {
                    // Plant a flower
                    flowerbed[i] = 1;
                    // Increment the count of flowers planted
                    count++;
                    // If the count is equal to `n`, return true
                    if (count >= n) {
                        return true;
                    }

                    i++;
                }
            }
        }

        return false;

    }
}