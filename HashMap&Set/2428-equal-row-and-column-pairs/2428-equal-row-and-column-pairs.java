import java.util.*;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;
        
        // HashMap to store rows as keys and their frequencies
        HashMap<List<Integer>, Integer> rowMap = new HashMap<>();
        
        // Store the rows in the HashMap
        for (int[] row : grid) {
            List<Integer> rowList = new ArrayList<>();
            for (int num : row) {
                rowList.add(num);
            }
            rowMap.put(rowList, rowMap.getOrDefault(rowList, 0) + 1);
        }
        
        // Compare each column with the rows stored in the HashMap
        for (int col = 0; col < n; col++) {
            List<Integer> colList = new ArrayList<>();
            for (int row = 0; row < n; row++) {
                colList.add(grid[row][col]);
            }
            
            // If the column matches a row in the HashMap, add the frequency to the count
            if (rowMap.containsKey(colList)) {
                count += rowMap.get(colList);
            }
        }
        
        return count;
    }
}
