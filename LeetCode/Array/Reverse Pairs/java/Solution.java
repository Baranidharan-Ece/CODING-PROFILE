class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

        
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2L * nums[j]) j++;
            count += j - (mid + 1);
        }

        // merge step
        int[] temp = new int[right - left + 1];
        int i = left, k = mid + 1, t = 0;
        while (i <= mid && k <= right) {
            if (nums[i] <= nums[k]) temp[t++] = nums[i++];
            else temp[t++] = nums[k++];
        }
        while (i <= mid) temp[t++] = nums[i++];
        while (k <= right) temp[t++] = nums[k++];
        System.arraycopy(temp, 0, nums, left, temp.length);

        return count;
    }
}
