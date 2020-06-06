import java.util.*;

/*

Largest Product in a Grid

====================================================================================================================

Approach: This is a straightforward problem that can be solved with for loops. The code doesn't need to find the
product of values in the up or left directions, they are the same as down and right starting at different points. It
is necessary to check both diagonals.

Time complexity: The time complexity is roughly O(N*M) where N and M are the dimensions of the grid.

Space complexity: The space complexity of this approach is also O(N*M).

 */

public class Euler011 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] grid = new int[20][20];
		for(int grid_i=0; grid_i < 20; grid_i++){
			for(int grid_j=0; grid_j < 20; grid_j++){
				grid[grid_i][grid_j] = in.nextInt();
			}
		}

		int downProduct, rightProduct, diag1Product, diag2Product;
		int max = 0;

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (j < 17 && i < 17) {
					diag1Product = grid[i][j] * grid[i+1][j+1] * grid[i+2][j+2] * grid[i+3][j+3];
					diag2Product = grid[i+3][j] * grid[i+2][j+1] * grid[i+1][j+2] * grid[i][j+3];
					if (diag1Product > max) max = diag1Product;
					if (diag2Product > max) max = diag2Product;
				}
				if (i < 17) {
					downProduct = grid[i][j] * grid[i+1][j] * grid[i+2][j] * grid[i+3][j];
					if (downProduct > max) max = downProduct;
				}
				if (j < 17) {
					rightProduct = grid[i][j] * grid[i][j+1] * grid[i][j+2] * grid[i][j+3];
					if (rightProduct > max) max = rightProduct;
				}
			}
		}

		System.out.println(max);

	}
}