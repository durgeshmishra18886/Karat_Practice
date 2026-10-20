//Single discconnected zeoes
public class FindRectangles {
    public static int[][] findRectangle(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 0) {
                    int rEnd = r;
                    int cEnd = c;

                    while (rEnd < rows && board[rEnd][c] == 0)
                        rEnd++;
                    while (cEnd < cols && board[r][cEnd] == 0)
                        cEnd++;

                    return new int[][]{{r, c}, {rEnd - 1, cEnd - 1}};
                }
            }
        }
        return new int[][]{};
    }

    public static void main(String[] args) {
        // Sample input grid (1s representing background, 0s representing the rectangle)
        int[][] board = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };

        // Calling the static method
        int[][] result = findRectangle(board);

        // Printing the top-left and bottom-right coordinates
        if (result.length > 0) {
            System.out.println("Top-left coordinate: [" + result[0][0] + ", " + result[0][1] + "]");
            System.out.println("Bottom-right coordinate: [" + result[1][0] + ", " + result[1][1] + "]");
        } else {
            System.out.println("No rectangle found.");
        }
    }
}



