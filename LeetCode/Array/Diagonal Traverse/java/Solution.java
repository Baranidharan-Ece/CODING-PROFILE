class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];
        
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int r = 0, c = 0, dir = 1; 
        
        for (int i = 0; i < m * n; i++) {
            result[i] = mat[r][c];
            
            if (dir == 1) {
                if (c == n - 1) {  
                    r++;
                    dir = -1;
                } else if (r == 0) {  
                    c++;
                    dir = -1;
                } else {
                    r--;
                    c++;
                }
            } else { 
                if (r == m - 1) {  
                    c++;
                    dir = 1;
                } else if (c == 0) {  
                    r++;
                    dir = 1;
                } else {
                    r++;
                    c--;
                }
            }
        }
        return result;
    }
}
