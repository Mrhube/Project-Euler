import java.util.*;

public class Euler004 {

	/*

	https://projecteuler.net/problem=4

	Problem: Find the largest palindrome made from the product of two 3-digit numbers which is less than N.

	Input Format: First line contains T that denotes the number of test cases. This is followed by T lines, each
	containing an integer, N.

	Constraints:
	1 <= T <= 100
	101101 < N < 1000000

	====================================================================================================================

	Approach: Will be faster to work the problem backwards by finding the largest palindrome less than N and checking
	if it has a pair of 3-digit factors.

	Time complexity: Finding the next lowest palindrome is not dependent on the size of N, and neither is checking if
	that palindrome has a 3-digit factor pair. Therefore the time complexity is O(1)

	Space complexity: The space needed is also independent of N, so the space complexity is O(1)

	 */

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();

			int palindrome = FindLargestPalindrome(n);

			while (!hasThreeDigitFactorPair(palindrome)) {
				palindrome = FindLargestPalindrome(palindrome);
			}
			System.out.println(palindrome);

		}
	}

	public static int FindLargestPalindrome(int N) {

		// Check that input is within problem bounds
		if (101101 >= N || N >= 1000000) {
			System.out.println("Bad Input");
			return 0;
		}

		// Subtract one so this function only returns palindromes less than N
		N--;

		// Convert integer to a character array to make comparison easier
		char[] num = Integer.toString(N).toCharArray();

		// Modify until it is a palindrome
		if (num[0] == num[5]) {
			//Do nothing
		} else if(num[0] < num[5]) {
			num[5] = num[0];
		} else {
			int numAsInt = Integer.parseInt(new String(num));
			numAsInt -= (10 + num[5] - num[0] );
			num = Integer.toString(numAsInt).toCharArray();
			if (num[0] < num[5]) num[5] = num[0];
		}

		if (num[1] == num[4]) {
			//Do nothing
		} else if(num[1] < num[4]) {
			num[4] = num[1];
		} else {
			int numAsInt = Integer.parseInt(new String(num));
			numAsInt -= (100 + (num[4] - num[1]) * 10);
			num = Integer.toString(numAsInt).toCharArray();
			if (num[1] < num[4]) num[4] = num[1];
		}

		if (num[2] == num[3]) {
			// Do nothing
		} else if(num[2] < num[3]) {
			num[3] = num[2];
		} else {
			num[2]--;
			num[3] = num[2];
		}

		return Integer.parseInt(new String(num));

	}

	// This function could be further optimized
	public static boolean hasThreeDigitFactorPair(int N) {
		int factor,i;

		for (i = 100; i <= 999; i++) {
			if (N % i == 0) {
				factor = N / i;
				if (factor >= 100 && factor <= 999) return true;
			}
		}

		return false;
	}
}
