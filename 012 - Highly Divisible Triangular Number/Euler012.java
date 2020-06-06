import java.util.*;

public class Euler012 {

	/*

	https://projecteuler.net/problem=12

	Problem: What is the value of the first triangle number to have over N divisors?

	Input Format: First line T, the number of testcases. Each testcase consists of N in one line.

	Constraints:
	1 <= T <= 10
	1 <= N <= 10^3

	====================================================================================================================

	Approach: I originally attempted to approach this problem using the prime factorization method of determining the
	number of factors of each triangle number. However, as the values of the triangular numbers grew larger, the
	speed of finding the prime factorization decreased drastically until using brute force to check every factor up to
	the square root of the number became significantly faster.

	The code creates an array such that array[N] = the value of the first triangle number to have over N divisors. This
	makes handling multiple test cases very fast. It also always generates the solution for all values of N up to
	N = 1000 to test that it can pass the Hackerrank time limit in the worst-case scenario.

	Time complexity: The time complexity is difficult to determine because the number of triangular numbers that will
	need to be calculated and checked for factors can't be written as an equation of N.

	Space complexity: The space complexity is O(1) and is determined by the upper limit of N.

	This solution could be modified to use less time and space by only allocating an array for solutions up to the
	highest value of N received across all test cases, instead of the upper limit of N.

	 */

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int index = 1;
		int lastIndex = 0;
		int[] solution = new int[1001];
		do {

			int triangular = index * (index + 1) / 2;
			int numOfFactors = CountNumberOfFactors(triangular);


			if (numOfFactors > lastIndex) {
				for (int i = lastIndex + 1; i < numOfFactors && i <= 1000; i++) {
					solution[i] = triangular;
				}
				lastIndex = numOfFactors - 1;
			}
			index++;

		} while (lastIndex <= 1001);

		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();

			System.out.println(solution[n]);

		}

	}

	public static int CountNumberOfFactors(int n) {
		int count = 0;
		for (int i = 1; i < Math.sqrt(n); i++) {
			if (n % i == 0) count += 2;
		}
		if (n / Math.sqrt(n) == (int)Math.sqrt(n) ) count++;
		return count;
	}


//	public static int CalcNumberOfFactors(int n) {
//		if (n == 1) return 1;
//		int result = 1;
//		Map<Integer,Integer> factors = PrimeFactorization(n);
//		for (int value : factors.values()) {
//			result *= 1 + value;
//		}
//		return result;
//	}
//
//	public static Map<Integer, Integer> PrimeFactorization(int n) {
//		boolean done = false;
//		int primeFactor = 2;
//		int exponent = 0;
//		//int temp = n;
//		Map<Integer,Integer> factors = new HashMap<>();
//		while (!isPrime(n)) {
//
//			exponent = 0;
//
//			while (n % primeFactor == 0) {
//				exponent++;
//				n /= primeFactor;
//			}
//
//			if (exponent > 0) {
//				factors.put(primeFactor,exponent);
//			}
//
//			primeFactor = nextPrime(primeFactor);
//
//		}
//
//		if (n != 1)	factors.put(n,1);
//
//		return factors;
//
//	}

	public static boolean isPrime(long x) {
		if (x == 1 || x == 2) return true;
		if (x % 2 == 0) return false;
		for (int i = 3; i <= Math.sqrt(x); i += 2) {
			if (x % i == 0) return false;
		}
		return true;
	}

	public static int nextPrime(int x) {
		if (x == 2) return 3;
		do {
			x += 2;
		} while (!isPrime(x));
		return x;
	}


}