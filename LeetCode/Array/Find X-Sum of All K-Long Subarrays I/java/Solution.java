
import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i + k <= n; i++) {
            Map<Integer, Integer> freq = new HashMap<>();

            // build freq map for current window
            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            // list of (value, frequency)
            List<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
                list.add(new int[]{e.getKey(), e.getValue()});
            }

            // sort by frequency desc, then value desc
            list.sort((a, b) -> {
                if (a[1] == b[1]) return b[0] - a[0];
                return b[1] - a[1];
            });

            // sum value * frequency for top x entries
            long sum = 0;
            for (int t = 0; t < Math.min(x, list.size()); t++) {
                int val = list.get(t)[0];
                int f = list.get(t)[1];
                sum += (long) val * f;
            }

            // fits in int per problem constraints, but cast to int
            result[i] = (int) sum;
        }

        return result;
    }
}
