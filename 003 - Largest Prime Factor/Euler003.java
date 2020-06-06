import java.util.*;

public class Euler003 {

	/*

	https://projecteuler.net/problem=3

	Problem: What is the largest prime factor of a given number N?

	Input Format: First line contains T, the number of test cases. This is followed by T lines each containing an
	integer N.

	Constraints:
	1 <= T <= 10
	10 <= N <= 10^12

	====================================================================================================================

	Approach: The solution will need to identify prime numbers. There is no equation that will give all of the prime
	numbers up to 10^12, so an efficient function will be needed to check by brute force. To check if a number X is
	prime, if it is any even number other than 2 is known to not be prime. If the number is odd, the function will need
	to check if X has any odd factors. This can be accomplished by finding the modulus of each odd number up to the
	square root of X.

	The problem asks for the largest prime number multiple, but searching for the largest multiple and working down from
	there will be slow because of the amount of space between multiples. It should be faster to start searching for
	factors at i=1 and working upwards while checking if the corresponding factor is prime.

	Time complexity: The worst case for finding the largest prime factor is if the factor is the square root of N. The
	worst case for checking if a particular factor is prime requires checking each value up to the factor's square root.
	These are approximately O(N^1/2) and O((N^1/2)^1/2) respectively, giving an overall worst-case time complexity of
	O(N^3/4).

	Space complexity: This has O(1) space complexity.

	 */

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			long n = in.nextLong();

			if (isPrime(n)) {
				System.out.println(n);
				continue;
			}

			long x;
			long i = 1;

			do {
				i++;
				while (n % i != 0) {
					i++;
				}
				x = n / i;
			} while (!isPrime(x));

			System.out.println(x);

		}
	}

	public static boolean isPrime(long x) {

		if (x == 1 || x == 2) return true;

		if (x % 2 == 0) return false;

		for (int i = 3; i <= Math.sqrt(x); i += 2) {
			if (x % i == 0) return false;
		}

		return true;
	}
}
