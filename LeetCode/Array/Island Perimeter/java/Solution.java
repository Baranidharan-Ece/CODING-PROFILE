class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4; // each land cell has 4 edges

                    // check top neighbor
                    if (i > 0 && grid[i - 1][j] == 1)
                        perimeter -= 2; // shared edge removes 2 sides

                    // check left neighbor
                    if (j > 0 && grid[i][j - 1] == 1)
                        perimeter -= 2; // shared edge removes 2 sides
                }
            }
        }

        return perimeter;
    }
}
