import java.util.*;

/*

Special Pythagorean Triplet

====================================================================================================================

Approach: Instead of guessing values of a, b, and c, the two equations can be used to solve for a in terms of b and
N. Since N is a known number, the problem can be solved by looping through values of b.

The value of b must be less than N/2 because b + c < N and b < c

a^2 + b^2 = c^2
a + b + c = N  ->  c = N - a - b

a^2 + b^2 = (N - a - b)^2
a^2 + b^2 = a^2 + b^2 + 2ab - 2aN - 2bN + b^2
0 = 2ab - 2aN - 2bN + b^2
2aN - 2ab = N^2 - 2bn
a = (N^2 - 2bn) / (2N - 2b)

Time complexity: Using this method the time complexity is O(N)

Space complexity: The space complexity is O(1)

 */

public class Euler009 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			int a, c;
			int result = -1;
			for (int b = 1; b < n / 2; b++) {

				a = (n * n - 2 * n * b) / (2 * n - 2 * b);
				c = n - a - b;

				// Since values of b are guesses, need to verify it solves the original equation

				if (a * a + b * b == c * c) {
					result = Math.max(a * b * c, result);
				}

			}
			System.out.println(result);
		}
	}
}