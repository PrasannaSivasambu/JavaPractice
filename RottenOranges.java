import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static class Pair {
        int row, col, time;
        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int freshCount = 0, minutes = 0;

        // Step 1: Add all initially rotten oranges to queue & count fresh ones
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // Step 2: Define directions for 4-way adjacency (Up, Down, Left, Right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Step 3: Perform BFS
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int r = p.row, c = p.col, time = p.time;
            minutes = Math.max(minutes, time);

            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                // If the adjacent cell is fresh, rot it
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 2; // Make it rotten
                    queue.add(new Pair(newRow, newCol, time + 1)); // Add to queue with incremented time
                    freshCount--; // Reduce fresh count
                }
            }
        }

        // Step 4: If fresh oranges remain, return -1, else return minutes
        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println(orangesRotting(grid)); // Output: 4
    }
}
