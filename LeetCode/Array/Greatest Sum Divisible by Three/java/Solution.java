class Solution {
    public int maxSumDivThree(int[] nums) {
        int total = 0;

        // Use large values but not MAX_VALUE to avoid overflow
        int[] rem1 = {1000000000, 1000000000};
        int[] rem2 = {1000000000, 1000000000};

        for (int x : nums) {
            total += x;
            int r = x % 3;

            if (r == 1) {
                if (x < rem1[0]) {
                    rem1[1] = rem1[0];
                    rem1[0] = x;
                } else if (x < rem1[1]) {
                    rem1[1] = x;
                }
            } else if (r == 2) {
                if (x < rem2[0]) {
                    rem2[1] = rem2[0];
                    rem2[0] = x;
                } else if (x < rem2[1]) {
                    rem2[1] = x;
                }
            }
        }

        int mod = total % 3;

        if (mod == 0) return total;

        if (mod == 1) {
            int removeOne = rem1[0];
            int removeTwo = rem2[0] + rem2[1];
            int remove = Math.min(removeOne, removeTwo);
            return remove >= 1000000000 ? 0 : total - remove;
        }

        // mod == 2
        int removeOne = rem2[0];
        int removeTwo = rem1[0] + rem1[1];
        int remove = Math.min(removeOne, removeTwo);
        return remove >= 1000000000 ? 0 : total - remove;
    }
}
