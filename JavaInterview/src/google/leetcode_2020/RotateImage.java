package google.leetcode_2020;

/*Given input matrix =
        [
        [1,2,3],
        [4,5,6],
        [7,8,9]
        ],

        rotate the input matrix in-place such that it becomes:
        [
        [7,4,1],
        [8,5,2],
        [9,6,3]
        ]
*/

/* Explanation



0th row
0, 0 --> 1 -->  0, 2  =>  0th row to n - 1 column; column to row
0, 1 --> 2 -->  1, 2
0, 2 --> 3 -->  2, 2


0, 2 --> 3
1, 2 --> 6
2, 2 --> 9

1st row
1, 0 --> 4 -->  0, 1 =>  1st row to n - 1 - 1 column; column to row
1, 1 --> 5 -->  1, 1
1, 2 --> 6 -->  2, 1

0, 1 --> 3
1, 1 --> 6
2, 1 --> 9

2nd row
2, 0 --> 7 -->  0, 0 =>  2nd row to n - 1 - 1 - 1 column; column to row
2, 1 --> 8 -->  1, 0
2, 2 --> 9 -->  2, 0


temp =>



 */
public class RotateImage {

    //1
    // step1. transpose the matrix
    // step2. reverse the element in the row
    // O(n*n); o(1)

    // 2
    // diagonal swap of elements
    // O(n*n); o(1)
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        for(int i =0; i<(n + 1)/2; i++){
            for(int j =0; j<n/2; j++){
                int temp = matrix[n - 1- j][i];
                matrix[n-1-j][i] = matrix[n - 1 - i ][n - j - 1];
                matrix[n - 1 - i ][n - j - 1] = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}


/*
        [
        [1,2,3],
        [4,5,6],
        [7,8,9]
        ],

        n - 1 - j = 3 - 1 - 0 = 2, 0 => 7 = tmp
        2, 0 = 2, 2 => 9 => [9, 8, 9]
        2, 2 = 0, 2 => 3 => [9, 8, 3]
        0, 2 = 0, 0 => 1 => [1, 2, 1]
        0, 0 = tmp = 7 => [7, 2, 3]


        [
        [7,2,1],
        [4,5,6],
        [9,8,3]
        ],



 */