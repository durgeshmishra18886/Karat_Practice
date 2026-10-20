public class WordSearchDfs {

    public static boolean wordSearch(char[][] grid, String word) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(grid, word, r, c, 0)) {
                    return true; // Return true immediately when a valid path is found
                }
            }
        }

        return false; // Return false if no match is found after checking all starting points
    }

    private static boolean dfs(char[][] grid, String word, int r, int c, int index) {
        if (index == word.length()) {
            return true;
        }
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = grid[r][c];
        grid[r][c] = '#'; // Mark cell as visited

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            if (dfs(grid, word, r + dir[0], c + dir[1], index + 1)) {
                grid[r][c] = temp; // Restore before returning true
                return true;
            }
        }

        grid[r][c] = temp; // Restore before returning false
        return false;
    }

    public static void main(String args[]) {
        char[][] grid = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";

        System.out.println("Grid contains \"" + word1 + "\": " + wordSearch(grid, word1)); // true
        System.out.println("Grid contains \"" + word2 + "\": " + wordSearch(grid, word2)); // true
        System.out.println("Grid contains \"" + word3 + "\": " + wordSearch(grid, word3)); // false
    }
}