public class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int totalTime = 0;
        int i = 0;

        while (i < n) {
            char c = colors.charAt(i);
            int sum = 0;
            int maxTime = 0;

          
            while (i < n && colors.charAt(i) == c) {
                sum += neededTime[i];
                if (neededTime[i] > maxTime) maxTime = neededTime[i];
                i++;
            }

            totalTime += (sum - maxTime);
        }

        return totalTime;
    }

   
    public static void main(String[] args) {
        Solution sol = new Solution();
        String colors = "aabaa";
        int[] neededTime = {1, 2, 3, 4, 1};
        System.out.println(sol.minCost(colors, neededTime)); 
    }
}
