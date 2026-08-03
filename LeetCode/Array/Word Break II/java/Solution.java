class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return dfs(s, set, memo);
    }

    private List<String> dfs(String s, Set<String> set, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);

        List<String> res = new ArrayList<>();
        if (s.isEmpty()) {
            res.add("");
            return res;
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (set.contains(prefix)) {
                List<String> rest = dfs(s.substring(i), set, memo);
                for (String r : rest) {
                    res.add(prefix + (r.isEmpty() ? "" : " ") + r);
                }
            }
        }

        memo.put(s, res);
        return res;
    }
}
