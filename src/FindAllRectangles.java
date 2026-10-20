import java.util.ArrayList;
import java.util.List;

//Multiple discconnected zeoes
public class FindAllRectangles {
    public static List<int[][]> findAllRectangles(int[][] board) {
        List<int[][]> rectangles = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 0) {
                    int rEnd = r;
                    int cEnd = c;
                    while (rEnd < rows && board[rEnd][c] == 0) {
                        rEnd++;
                    }
                    while (cEnd < cols && board[r][cEnd] == 0) {
                        cEnd++;
                    }
                    for (int i = r; i < rEnd; i++) {
                        for (int j = c; j < cEnd; j++) {
                            board[i][j] = 1;
                        }
                    }
                    rectangles.add(new int[][]{{r, c}, {rEnd - 1, cEnd - 1}});
                }

            }
        }
        return rectangles;
    }

    public static void main(String args[]) {
        int[][] arr = {{1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 1, 1, 1, 1, 0, 0}
        };

        List<int[][]> rectangles = findAllRectangles(arr);
        for (int i = 0; i < rectangles.size(); i++) {
            int[][] rect = rectangles.get(i);
            System.out.println("Rectangle " + (i + 1) + ": Top-Left = [" + rect[0][0] + ", " + rect[0][1] +
                    "], Bottom-Right = [" + rect[1][0] + ", " + rect[1][1] + "]");
        }


    }
}