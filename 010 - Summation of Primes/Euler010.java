import java.util.*;

	/*

	https://projecteuler.net/problem=10

	Problem: Find the sum of all the primes not greater than given N.

	Input Format: The first line contains an integer T i.e. number of test cases.
	The next T lines will contain an integer N.

	Constraints:
	1 <= T <= 10^4
	1 <= N <= 10^6

	====================================================================================================================

	Approach: Because of the large upper limit on the number of test cases, it is important to avoid repeating
	calculations. To save time checking if numbers are prime, only odd values will be tested. To keep the code simple
	and to demonstrate it can run quickly in the worst-case scenario of 10000 test cases, the solution will calculate
	a running sum of primes for every value of N and store it in an array such that array[N] = the sum of all primes
	not greater than N.

	Time complexity: The time complexity of a single test case is roughly O(N^(3/2))

	Space complexity: The space complexity of this approach is O(1) and is determined by the upper limit of N, because
	it pre-calculates every possible solution.

	This approach could be optimized to use less time and space by only calculating values up to the highest value of N
	across all the received test cases.

	It could also save space by only computing the result for odd values of N, because the output for any even value of
	N is the same as the result for N - 1

	 */

public class Euler010 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		long[] sums = new long[1000001];
		sums[2] = 2;
		for (int i = 3; i <= 1000000; i+=2) {
			if (isPrime(i)) {
				sums[i] = sums[i-1] + i;
			} else {
				sums[i] = sums[i-1];
			}
			sums[i+1] = sums[i];
		}

		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
				System.out.println(sums[n]);
		}
	}

	// To check if a value is prime, only need to look for factors up to the square root of the value
	// Also, 2 is the only even prime number
	public static boolean isPrime(long x) {
		if (x == 1 || x == 2) return true;
		if (x % 2 == 0) return false;
		for (int i = 3; i <= Math.sqrt(x); i += 2) {
			if (x % i == 0) return false;
		}
		return true;
	}

}