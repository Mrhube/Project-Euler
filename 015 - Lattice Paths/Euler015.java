import java.util.*;

/*

Lattice Paths

====================================================================================================================

Approach: This can be solved using a sub-problem approach and recursion. The number of paths for transversing a
lattice is the sum of the number of paths remaining if you move right + the number of paths remaining if you move
down. When one dimension of the lattice = 1, the number of paths is 1 + the other dimension. The symmetry of the
problem can be used to reduce the number of calculations needed, as a NxM lattice and a MxN lattice have the same
number of paths.

It is necessary to use memoization to avoid repeating calculations, because otherwise the run time increases
exponentially with N and M.

Time complexity: If using memoization, the time complexity is roughly O(N*M) because the code only needs to
calculate the number of paths once for each lattice of size N x M or smaller.

Space complexity: The space complexity is also O(N*M) because of the map used to save calculations.

 */

public class Euler015 {

	public static Map<String,Long> savedCalcs;

	public static void main(String[] args) {
		savedCalcs = new HashMap<>();
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int m = in.nextInt();
			System.out.println(CountPaths(n, m));
		}
	}

	public static long CountPaths(int rows, int cols) {
		// Handle base cases
		if (rows == 1) return cols + 1;
		if (cols == 1) return rows + 1;
		// Check previous calculations
		if (savedCalcs.containsKey(rows + "," + cols)) return savedCalcs.get(rows + "," + cols);
		if (savedCalcs.containsKey(cols + "," + rows)) return savedCalcs.get(cols + "," + rows);
		// Use sub problem
		long result = CountPaths(rows - 1, cols) + CountPaths(rows, cols - 1);
		result = result % (long)(Math.pow(10,9) + 7);
		savedCalcs.put(rows + "," + cols, result);
		return result;
	}
}