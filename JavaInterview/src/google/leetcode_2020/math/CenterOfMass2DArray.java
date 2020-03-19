package google.leetcode_2020.math;

/**
 * center of mass 2d array java
 * 
 * Centroid of matrix
 * 
 * 
 * @author hbhavsar
 *
 */
public class CenterOfMass2DArray {
	
	
	public static void main(String[] args) {
		double[][] matrix = new double[][]{
		    {0.70,0.75,0.70,0.75,0.80},
		    {0.55,0.30,0.20,0.10,0.70},
		    {0.80,0.10,0.40,0.10,0.80},
		    {0.70,0.00,0.00,0.00,0.80},
		    {0.80,0.90,0.80,0.75,0.90}};
		    
		    CenterOfMass2DArray c = new CenterOfMass2DArray();
		    double ans = c.getCentroidOfMatrix(matrix);
		    System.out.println(ans);
		    
	}
	
	
	
	public double getCentroidOfMatrix(double[][] matrix) {

		double massVectorX = 0;
		double massVectorY = 0;
		double totalMass = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

				massVectorX += matrix[i][j] * i;
				massVectorY += matrix[i][j] * j;
				totalMass += matrix[i][j];
			}
		}

		int x = (int) (massVectorX / totalMass);
		int y = (int) (massVectorY / totalMass);

		return matrix[x][y];
	}

}
