class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = 0;
        int c = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int x : nums) {

            n += x % 2;

            c += map.getOrDefault(n - k, 0);

            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        return c;
    }
}