class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] left = new int[26];
        int[] right = new int[26];
        
        Arrays.fill(left, -1);
        
        // record first and last positions
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (left[c] == -1) left[c] = i;
            right[c] = i;
        }
        
        int result = 0;
        
        for (int c = 0; c < 26; c++) {
            int l = left[c];
            int r = right[c];
            if (l != -1 && r - l >= 2) {
                boolean[] seen = new boolean[26];
                for (int i = l + 1; i < r; i++) {
                    seen[s.charAt(i) - 'a'] = true;
                }
                result += countTrue(seen);
            }
        }
        
        return result;
    }
    
    private int countTrue(boolean[] arr) {
        int c = 0;
        for (boolean x : arr) if (x) c++;
        return c;
    }
}
