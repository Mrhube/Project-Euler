import java.util.*;

public class Euler013 {

	/*

	https://projecteuler.net/problem=13

	Problem: Work out the first ten digits of the sum of N 50-digit numbers.

	Input Format: First line contains N, next N lines contain a 50 digit number each.

	Constraints:
	1 <= N <= 10^3

	====================================================================================================================

	Approach: Adding together the full 50 digit numbers is more work than is necessary. The lowest digit places will be
	too insignificant to change the highest 10 digit places. The number of digit places beyond the first 10 that need to
	be added is a logarithmic function of N.

	Time complexity: The time complexity is O(N)

	Space complexity: The space complexity is O(log n), but is generally insignificant

	 */

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int numOfDigits = 11 + (int)Math.ceil(Math.log10(n));
		String str = in.nextLine();
		long sum = 0;

		for(int a0 = 0; a0 < n; a0++){
			str = in.nextLine();
			str = str.substring(0,numOfDigits+1);
			sum +=Long.parseLong(str);
		}

		System.out.println(Long.toString(sum).substring(0,10));

	}
}