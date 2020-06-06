import java.util.Scanner;

/*

Multiples of 3 and 5

====================================================================================================================

Approach: The sum can be found by adding all the multiples of 3 and the all the multiples of 5 and subtracting
the overlap, which is the sum of the multiples of 15

Time complexity: The triangular number formula can be used to quickly find the sum of multiples with no loops,
giving a time complexity of O(1)

Space complexity: Again, the triangular number formula makes calculations easy, resulting in a space complexity
of O(1)

 */

public class Euler001 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			long a,b,c,result;

			// Calculate sum of factors of 3
			a = (n-1) / 3;          // Find greatest multiple
			b = (a * a + a) / 2;    // Calculate triangle number
			c = b * 3;              // Multiply triangle number by 3
			result = c;

			// Add the sum of factors of 5
			a = (n-1) / 5;         	// Find greatest multiple
			b = (a * a + a) / 2;    // Calculate triangle number
			c = b * 5;              // Multiply triangle number by 5
			result += c;

			// Subtract the sum of factors of 15 (these are counted twice by above code, but should only count once)
			a = (n-1) / 15;         // Find greatest multiple
			b = (a * a + a) / 2;    // Calculate triangle number
			c = b * 15;             // Multiply triangle number by 5
			result -= c;

			System.out.println(result);
		}
	}
}