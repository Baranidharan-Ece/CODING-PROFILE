class Solution {
    private static final long MOD = 1_000_000_007L;
    public int countPermutations(int[] complexity) {
        int n = complexity.length;

        
        int minVal = Integer.MAX_VALUE;
        for (int x : complexity) 
        if (x < minVal) minVal = x;

       
        if (complexity[0] != minVal) 
        return 0;
        int countMin = 0;
        for (int x : complexity){
         if (x == minVal){ 
            countMin++;
        if (countMin > 1) {
        return 0;
        }
     }
    }


        
        long fact = 1;
        for (int i = 2; i <= n-1; i++) 
        fact = (fact * i) % MOD;
        return (int) fact;
    }
}
