import java.util.*;

class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        int len = n.length();

        Set<Long> candidates = new HashSet<>();
        candidates.add((long) Math.pow(10, len) + 1);
        candidates.add((long) Math.pow(10, len - 1) - 1);

        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));

        for (long i = prefix - 1; i <= prefix + 1; i++) {
            String firstHalf = String.valueOf(i);
            StringBuilder sb = new StringBuilder(firstHalf);
            if (len % 2 == 1)
                sb.deleteCharAt(sb.length() - 1);
            sb.reverse();
            String pal = firstHalf + sb.toString();
            candidates.add(Long.parseLong(pal));
        }

        long closest = -1;
        for (long cand : candidates) {
            if (cand == num) continue;
            if (closest == -1 ||
                Math.abs(cand - num) < Math.abs(closest - num) ||
                (Math.abs(cand - num) == Math.abs(closest - num) && cand < closest)) {
                closest = cand;
            }
        }

        return String.valueOf(closest);
    }
}
