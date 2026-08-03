class Solution {
    public int[] countBits(int n) {
        int[] arr=new int[n+1];
        for(int i=0;i<=n;i++){
            int j=i;
            int sum=0;
            while(j>0){
               sum+=j&1;
               j>>=1;
            }                      
               arr[i]=sum; 
        }

        
        return arr;

    }
    
}