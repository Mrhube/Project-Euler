import java.util.*;

public class Euler008 {

	/*

	https://projecteuler.net/problem=8

	Problem: Find the greatest product of K consecutive digits in the N digit number.

	Input Format: First line contains T that denotes the number of test cases. First line of each test case will contain
	two integers N & K . Second line of each test case will contain a N digit integer.

	Constraints:
	1 <= T <= 100
	1 <= K <= 7
	K <= N <= 10^3

	====================================================================================================================

	Approach: There's no need to perform (k - 1) multiplication operations to calculate each possible product, the next
	product can be calculated from the previous product by one multiplication and one division operation. However, this
	approach doesn't work if a digit can be 0, because it will cause divide by 0 errors. A work around for this is
	applying the above logic only to segments of the number that won't contain a 0. Segments that do contain a 0 can be
	ignored because their product is known to be 0.

	Time complexity: Using this method the time complexity is O(N)

	Space complexity: The space complexity is also O(N)

	 */

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			int k = in.nextInt();
			String num = in.next();
			String[] segments = num.split("0");
			long max = 0;
			for (String seg : segments) {

				if (seg.length() < k) {
					// Do nothing, any products calculated from this segment would contain a 0 and equal 0
				} else {
					max = Math.max(max, maxProductNoZeros(seg.length(), k, seg));
				}
			}

			System.out.println(max);

		}
	}

	public static long maxProductNoZeros(int n, int k, String num) {
		int[] products = new int[n - k + 1];
		products[0] = 1;
		for (int i = 0; i < k; i++) {
			products[0] *= Character.getNumericValue(num.charAt(i));
		}

		long max = products[0];

		for (int i = 0; i < n - k; i++) {
			products[i + 1] = products[i] / Character.getNumericValue(num.charAt(i)) * Character.getNumericValue(num.charAt(i + k));
			if (products[i + 1] > max) {
				max = products[i + 1];
			}
		}

		return max;
	}
}