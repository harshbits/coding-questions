package google.leetcode_2020.onsite;

public class CountSquareSubMatrices {

    public static void main(String[] args) {
        int[][] matrix1 = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        int num1 = 1;
        int ans1 = new CountSquareSubMatrices().countSquares(matrix1, num1);
        System.out.println(ans1);

        int[][] matrix2 = {
                {0, 1, 0},
                {1, 0, 0},
                {0, 0, 0}
        };
        int num2 = 0;
        int ans2 = new CountSquareSubMatrices().countSquares(matrix2, num2);
        System.out.println(ans2);
    }

    public int countSquares(int[][] matrix, int num) {

        StringBuilder sb = new StringBuilder();
        
        return 0;
    }

}
