package facebook.leetcode_2020.matrix;

public class KthSmallestInMatrix {
    public static void main(String[] args) {

    }


    // No extra space
    // O(n log (max_element-max_elements))
    public int kthSmallest(int[][] matrix, int k) {
        //[low, high)
        int low = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix[0].length - 1] + 1;

        while (low < high) {
            // mid
            int mid = low + (high - low) / 2;
            int count = 0, j = matrix[0].length - 1;

            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += (j + 1);
            }
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
