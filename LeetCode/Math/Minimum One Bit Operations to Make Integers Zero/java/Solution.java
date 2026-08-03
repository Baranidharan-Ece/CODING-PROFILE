class Solution {
    public int minimumOneBitOperations(int n) {
        if (n == 0) return 0;
        int mask = 1;
        while ((mask << 1) <= n) mask <<= 1;
        return ((mask << 1) - 1) - minimumOneBitOperations(n ^ mask);
    }
}
