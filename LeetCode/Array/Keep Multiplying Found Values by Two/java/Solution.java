class Solution {
    public int findFinalValue(int[] nums, int original) {
        // Use a HashSet for O(1) lookups
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        // Keep doubling while present
        while (set.contains(original)) {
            original *= 2;
        }

        return original;
    }
}
