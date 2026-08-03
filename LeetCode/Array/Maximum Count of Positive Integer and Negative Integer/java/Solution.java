class Solution {
    public int maximumCount(int[] nums) {
        int positivecount=0;
        int negativecount=0;
        int count=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                positivecount++;
            }
            else if(nums[i]<0){
                negativecount++;
            }
            else{
                count++;
            }
        }
        int Max=Math.max(positivecount,negativecount);
         return Max;
    }
   
}