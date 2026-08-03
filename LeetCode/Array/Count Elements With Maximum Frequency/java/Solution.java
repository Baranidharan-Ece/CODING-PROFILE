class Solution {
    public int maxFrequencyElements(int[] nums) {
        // Step 1: find the maximum number to size the freq array
        int maxVal = 0;
        for (int n : nums) {
            if (n > maxVal) maxVal = n;
        }

        // Step 2: count frequencies using an array
        int[] freq = new int[maxVal + 1];
        for (int n : nums) {
            freq[n]++;
        }

        // Step 3: find the maximum frequency
        int maxFreq = 0;
        for (int f : freq) {
            if (f > maxFreq) maxFreq = f;
        }

        // Step 4: sum frequencies of numbers having max frequency
        int total = 0;
        for (int f : freq) {
            if (f == maxFreq) total += f;
        }

        return total;
    }
}
