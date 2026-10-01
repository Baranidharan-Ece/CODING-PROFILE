class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int c = 0;
        int n = 0;

        map.put(0, 1);

        for (int x : nums) {
            n += x % 2;
            c += map.getOrDefault(n - k, 0);
            map.put(n, map.getOrDefault(n, 0) + 1);

        }

        return c;
    }
}