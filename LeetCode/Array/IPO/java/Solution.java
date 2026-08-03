import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        
        Arrays.sort(projects, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>((a, b) -> b - a);
        int i = 0;
        
        for (int round = 0; round < k; round++) {
            
            while (i < n && projects[i][0] <= w) {
                maxProfitHeap.offer(projects[i][1]);
                i++;
            }
            
            if (maxProfitHeap.isEmpty()) break;  
            
            
            w += maxProfitHeap.poll();
        }
        
        return w;
    }
}
