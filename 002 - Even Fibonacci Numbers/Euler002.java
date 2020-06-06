import java.util.ArrayList;
import java.util.Scanner;

public class Euler002 {

	/*

	https://projecteuler.net/problem=2

	Problem: By considering the terms in the Fibonacci sequence whose values do not exceed N, find the sum of the
	even-valued terms.

	Input Format: First line contains T that denotes the number of test cases. This is followed by T lines, each
	containing an integer, N.

	Constraints:
	1 <= T <= 10^5
	10 <= N <= 4 x 10^16

	====================================================================================================================

	Approach: The upper limit of N is quite high, so it is beneficial to save time calculating the next number in the
	sequence. Every third number in the series will be even, so an equation can be derived to find the next even number
	given the previous even numbers of the sequence. The number of test cases T, can also be high, so it is important
	to save the values of the Fibonacci sequence to an array so they don't need to be recalculated. An ArrayList will
	be used to store the values because the number of even numbers that do not exceed N is unknown.

	Time complexity: Calculating values in the Fibonacci sequence up to N makes this O(N) for each test case

	Space complexity: Storing the even numbers in the sequence takes up O(N) space

	Notes: For each test case this code is recalculating the sum of the even numbers. At the cost of more space used
	to store these sums in an array the first time they are calculated, the time needed to run many test cases could
	be reduced.

	 */

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		ArrayList<Long> list = new ArrayList<>();

		// Pre-populate the arraylist with the first 3 even numbers so an equation can be used to generate the next even
		// number in the series
		list.add(2l);
		list.add(8l);
		list.add(34l);

		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			long n = in.nextLong();

			while (list.get(list.size()-1) <= n) {
				int i = list.size();
				list.add(list.get(i-1)*3 + list.get(i-2)*5+list.get(i-3)); // Mathematical equation for next even number
			}

			long result = 0;
			int i = 0;

			while (list.get(i) < n) {
				result += list.get(i);
				i++;
			}

			System.out.println(result);
		}
	}
}