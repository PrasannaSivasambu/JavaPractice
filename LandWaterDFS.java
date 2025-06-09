public class LandWaterDFS {

    // Directions for moving up, down, left, and right
    static int[] rowDirections = {-1, 1, 0, 0};
    static int[] colDirections = {0, 0, -1, 1};

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        // Traverse the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If we find a land cell that is not visited
                if (grid[i][j] == '1') {
                    islandCount++;  // We found a new island
                    dfs(grid, i, j, rows, cols); 
                    System.out.println(i+" "+j); // Perform DFS to mark all connected land
                }
            }
        }

        return islandCount;
    }

    // Perform DFS to mark all connected land ('1') as visited
    private static void dfs(char[][] grid, int i, int j, int rows, int cols) {
        // Check if current cell is out of bounds or is water ('0')
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
            return;
        }
        
        // Mark the current cell as visited by setting it to '0'
        grid[i][j] = '0';

        // Visit all 4 adjacent cells (up, down, left, right)
        for (int k = 0; k < 4; k++) {
            int newRow = i + rowDirections[k];
            int newCol = j + colDirections[k];
            dfs(grid, newRow, newCol, rows, cols);  // Recursive DFS call
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '1'},
            {'0', '0', '0', '1', '1'}
        };
        
        System.out.println(numIslands(grid));  // Output: 1
    }
}
