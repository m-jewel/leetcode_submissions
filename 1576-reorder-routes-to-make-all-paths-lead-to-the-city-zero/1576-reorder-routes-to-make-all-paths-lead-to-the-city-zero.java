class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            int a = connection[0], b = connection[1];
            graph.get(a).add(new int[]{b, 1}); // Original direction (needs reversal if traversed)
            graph.get(b).add(new int[]{a, 0}); // Reverse direction (doesn't need reversal)
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int currentCity, List<List<int[]>> graph, boolean[] visited) {
        visited[currentCity] = true;
        int reversals = 0;

        // Traverse all neighbors
        for (int[] neighbor : graph.get(currentCity)) {
            int nextCity = neighbor[0];
            int direction = neighbor[1];

            // Only continue DFS on unvisited cities
            if (!visited[nextCity]) {
                // Add to reversals if the direction is original (1)
                reversals += direction;
                // Continue DFS from the next city
                reversals += dfs(nextCity, graph, visited);
            }
        }

        return reversals;
    }
}
