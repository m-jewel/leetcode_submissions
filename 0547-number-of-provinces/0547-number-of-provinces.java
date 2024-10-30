class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for(int node = 0; node < n; node++){
            if(!visited[node]){
                // Each DFS traversal represents one new province
                Stack<Integer> stack = new Stack<>();
                stack.push(node);

                while(!stack.isEmpty()){
                    int currentNode = stack.pop();

                    if(!visited[currentNode]){
                        visited[currentNode] = true;

                        // Traverse all neighbors of currentNode
                        for(int neighbor = 0; neighbor < n; neighbor++){
                            if(isConnected[currentNode][neighbor] == 1 && !visited[neighbor]){
                                stack.push(neighbor);
                            }
                        }
                    }
                }
                // Increment province count after finishing the DFS for this component
                provinces++;
            }
        }

        return provinces;
    }
}
