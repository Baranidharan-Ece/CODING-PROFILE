import java.util.*;

class Solution {
    int[][] rects;
    int[] prefix;
    int total;
    Random rand;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.prefix = new int[rects.length];
        this.rand = new Random();
        
        int sum = 0;
        for (int i = 0; i < rects.length; i++) {
            int[] r = rects[i];
            int count = (r[2] - r[0] + 1) * (r[3] - r[1] + 1);
            sum += count;
            prefix[i] = sum;
        }
        this.total = sum;
    }

    public int[] pick() {
        int r = rand.nextInt(total) + 1; 
        int idx = binarySearch(r);
        
        int[] rect = rects[idx];
        int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];
        
        int x = x1 + rand.nextInt(x2 - x1 + 1);
        int y = y1 + rand.nextInt(y2 - y1 + 1);
        
        return new int[]{x, y};
    }

    private int binarySearch(int val) {
        int l = 0, r = prefix.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (prefix[mid] < val) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
