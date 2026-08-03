class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int x : nums) sum += x;
        
        int rem = sum % k;
        return rem;  
    }
}
