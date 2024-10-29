class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        visited[0] = true;

        // DFS
        while(!stack.isEmpty()){
            int currentRoom = stack.pop();
            for(int key : rooms.get(currentRoom)){
                if(!visited[key]){
                    visited[key] = true;
                    stack.push(key);
                }
            }
        }

        for(boolean wereVisited : visited){
            if(!wereVisited){
                return false;
            }
        }

        return true;
    }
}