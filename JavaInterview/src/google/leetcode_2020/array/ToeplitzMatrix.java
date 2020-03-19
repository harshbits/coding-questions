package google.leetcode_2020.array;

public class ToeplitzMatrix {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}};
        boolean ans = new ToeplitzMatrix().isToeplitzMatrix(matrix);
        System.out.println(ans);

        int[][] matrix1 = {{1, 2}, {2, 2}};
        ans = new ToeplitzMatrix().isToeplitzMatrix(matrix1);
        System.out.println(ans);
    }
    public boolean isToeplitzMatrix(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return true;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
