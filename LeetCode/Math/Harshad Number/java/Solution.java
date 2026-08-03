class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int n=x;
        int rev=0;
        while(x!=0){
         int last=x%10;
         rev=rev+last;
         x/=10;

             
        }
         if(n%rev!=0){
            return -1;
            
         } 
         
         

        return rev;
         
        
    }
}