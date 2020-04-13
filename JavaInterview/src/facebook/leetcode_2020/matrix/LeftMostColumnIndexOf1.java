package facebook.leetcode_2020.matrix;

public class LeftMostColumnIndexOf1 {

    public static void main(String[] args) {
        int[][] matrix1 = {
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 1},
                {0, 0, 0, 0}
        };

        int ans1 = new LeftMostColumnIndexOf1().leftmostColumn(matrix1);
        System.out.println(ans1);
        ans1 = new LeftMostColumnIndexOf1().leftmostColumnBinarySearch(matrix1);
        System.out.println(ans1);

        int[][] matrix2 = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        int ans2 = new LeftMostColumnIndexOf1().leftmostColumn(matrix2);
        System.out.println(ans2);
        ans2 = new LeftMostColumnIndexOf1().leftmostColumnBinarySearch(matrix2);
        System.out.println(ans2);

    }

    // Time: O(rows + cols)
    // Space: O(1)
    public int leftmostColumn(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int column = -1;

        // start from top right
        for (int r = 0, c = cols - 1; r < rows && c >= 0; ) {
            if (matrix[r][c] == 1) {
                column = c;
                c--;
            } else {
                r++;
            }
        }

        return column;
    }

    // Time: O(rows * log(cols))
    // Space: O(1)
    public int leftmostColumnBinarySearch(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // O(log (cols))
        int start = 0, end = cols;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isAllRowZero(matrix, rows, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start >= rows ? -1 : start;
    }

    // O(rows)
    private boolean isAllRowZero(int[][] matrix, int rows, int c) {
        for (int r = 0; r < rows; r++) {
            if (matrix[r][c] == 1) {
                return false;
            }
        }
        return true;
    }
}
