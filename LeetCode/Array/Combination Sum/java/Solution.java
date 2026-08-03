class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] candidates, int remain, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(temp)); 
            return;
        } else if (remain < 0) {
            return; 
        }

        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]); // choose
            backtrack(result, temp, candidates, remain - candidates[i], i); // not i+1, can reuse
            temp.remove(temp.size() - 1); // backtrack
        }
    }
}
