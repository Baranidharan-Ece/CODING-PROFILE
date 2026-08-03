import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> path, int k, int remain, int start) {
        if (remain == 0 && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (remain < 0 || path.size() > k) return;

        for (int i = start; i <= 9; i++) {
            path.add(i);
            backtrack(res, path, k, remain - i, i + 1);
            path.remove(path.size() - 1); 
        }
    }
}
