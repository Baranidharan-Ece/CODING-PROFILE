class Solution {
    public int maxArea(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        int max = 0;
    while (start < end) {
            int min=Math.min(arr[start],arr[end]);
            int wid=end-start;
            max=Math.max(min*wid,max);

            if(arr[start]<arr[end]){
                start++;
            }
            else{
                end--;
            }
    }
        return max;

    }
}