import java.util.*;

public class Euler005 {

	/*

	https://projecteuler.net/problem=5

	Problem: What is the smallest positive number that is evenly divisible by all of the numbers from 1 to N ?

	Input Format: First line contains T that denotes the number of test cases. This is followed by T lines, each
	containing an integer, N.

	Constraints:
	1 <= T <= 10
	1 <= N <= 40

	====================================================================================================================

	Approach: The solution must be a multiple of the product of all the prime numbers less than N, so calculate the
	product and then check all of its multiples. The upper limit of N is very low, so the list of prime numbers can
	be hardcoded.

	Time complexity: The time complexity of this solution is difficult to determine because it relies on a while loop
	that runs an unknown number of times.

	Space complexity: This approach uses a hardcoded array of prime numbers, so it's space complexity is O(1) and is
	determined by the upper limit of N.

	 */

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37}; // List of all prime values less than or equal to 40
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();

			// Handle the case of n=1 manually to avoid divide by zero errors

			if (n == 1) {
				System.out.println(1);
				continue;
			}

			// Calculate the product of the prime numbers and then check all of its multiples

			int product = 1;
			int i = 0;
			int prime = primes[i];

			while (prime < n) {
				product *= prime;
				i++;
				prime = primes[i];
			}

			// Only need to check the quotient of the numbers from n/2 to n, the values in the second half are multiples
			// of the values in the first half

			int result = 0;
			boolean done;

			do {
				result += product;
				done = true;
				for (int j = n / 2; j <= n; j++) {
					if (result % j != 0) done = false;
				}
			} while (!done);

			System.out.println(result);

		}
	}
}
