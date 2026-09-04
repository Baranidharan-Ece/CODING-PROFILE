class Solution {
    public void moveZeroes(int[] arr) {
       
        
        
        
        int end=0;
        
        for(int start=0;start<arr.length;start++){
            if(arr[start]!=0){
                
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            
            end++;
        }
        }
    System.out.println(Arrays.toString(arr));
    
    }
}