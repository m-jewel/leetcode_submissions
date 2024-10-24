class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;  
    }

    public void backtrack(int start, int remainingSum, int k, List<Integer> path, List<List<Integer>> result){
        // Base Case
        if(path.size() == k && remainingSum == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        // If the remaining sum becomes negative or the size exceeds k, stop
        if(remainingSum < 0 || path.size() > k){
            return;
        }

        for(int i = start; i <= 9; i++){
            path.add(i);
            backtrack(i + 1, remainingSum - i, k, path, result);
            path.remove(path.size() - 1);
        }
    }
}