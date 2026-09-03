class Solution {
    public boolean checkDivisibility(int n) {
        boolean ans=false;
        int a=n;
        int sum=0;
        int pro=1;
         while (n>0){
            int temp=n%10;
            sum+=temp;
            pro=pro*temp;
            n/=10;
            }
            int max=sum+pro;
            if(a%max==0){
                ans = true;
            }
            else {
                ans=false;
                }
                return ans;
    }
}