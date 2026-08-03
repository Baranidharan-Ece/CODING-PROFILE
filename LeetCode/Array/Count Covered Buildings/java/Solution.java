import java.util.*;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();

        // Build row and column maps
        for (int[] b : buildings) {
            rowMap.computeIfAbsent(b[0], k -> new ArrayList<>()).add(b[1]);
            colMap.computeIfAbsent(b[1], k -> new ArrayList<>()).add(b[0]);
        }

        // Sort for binary search
        for (List<Integer> list : rowMap.values()) Collections.sort(list);
        for (List<Integer> list : colMap.values()) Collections.sort(list);

        int count = 0;

        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            List<Integer> rowList = rowMap.get(x);
            List<Integer> colList = colMap.get(y);

            // Binary search positions
            int colIndex = Collections.binarySearch(rowList, y);
            int rowIndex = Collections.binarySearch(colList, x);

            boolean hasLeft = colIndex > 0;
            boolean hasRight = colIndex < rowList.size() - 1;

            boolean hasAbove = rowIndex > 0;
            boolean hasBelow = rowIndex < colList.size() - 1;

            if (hasLeft && hasRight && hasAbove && hasBelow)
                count++;
        }

        return count;
    }
}
