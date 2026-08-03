class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cou=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                cou++;
                ans=Math.max(ans,cou);
            }
            else{
                cou=0;
            }
        }
        return ans;
    }
}