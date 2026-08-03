class Solution {
    public boolean sumOfNumberAndReverse(int num) {

          for(int i=0;i<=num;i++) {
              int n=i; int rev=0;
            while (n>0) {
                int digit=n%10;
                rev = rev * 10 +digit;
                n = n / 10;
            }
          


            if ( i+rev == num){
               return true;
            }
          }
            
            return false;
        

    }
}