import java.util.*;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;
        for (int i = 0; i < n; i++) {
            int papers = n - i;        // number of papers with ≥ citations[i]
            if (citations[i] >= papers) {
                h = papers;
                break;
            }
        }
        return h;
    }
}
