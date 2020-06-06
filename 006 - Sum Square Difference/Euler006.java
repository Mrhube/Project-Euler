import java.util.*;

/*

Sum Square Difference

====================================================================================================================

Approach: The problem is quite straightforward, but there could be up to 10000 test cases so it is important to
avoid repeating calculations. The sum of the first N natural numbers can be easily calculated using the triangular
number formula, but the sum of the squares will be saved to an array such that array[i] = the sum of the squares of
the first i	natural numbers. Additionally, the value of array[i+1] can be quickly calculated from the value of
array[i].

This solution is set up to demonstrate that it will always pass the time limit set by Hackerrank in the worst-case
scenario that N = 10000, by always calculating the sum of squares up to	10000. This also keeps the code very simple.
To better optimize the time and space used by this approach, the sum of squares could instead be calculated only up
to the highest value of N across all the received test cases.

Time complexity: The time complexity for each test case is O(N) because it calculates the sum of the squares from
1 to N.

Space complexity: The space complexity for this solution is O(1) but is dependent on the upper bound of N.
A solution that was more optimized for space would dependent on the highest value of N across all test cases.

 */

public class Euler006 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		// Just calculate all the sums of squares ahead of time to test worst-case scenario
		// This could easily be optimized to only calculate up to the highest value of N

		// Use an array because the number of values that need to be calculated is known and
		// lookup can be done quickly by index

		long[] sumOfSquares = new long[10001];
		for (int i = 1; i <= 10000; i++) {
			sumOfSquares[i] = sumOfSquares[i-1] + i * i;
		}

		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();

			System.out.println((long)Math.pow(TriangularNumber(n),2) - sumOfSquares[n]);

		}
	}

	public static long TriangularNumber(long n) {
		return n * (n + 1) / 2;
	}

}
