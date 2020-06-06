import java.math.BigInteger;
import java.util.Scanner;

/*

Power Digit Sum

====================================================================================================================

Approach: There may be an elegant mathematical solution to this, but this seemed like a good opportunity to try
using Java's BigInteger class

Time complexity: The time complexity of this solution matches the time complexity of the BigInteger.pow() function,
though I haven't tried to determine what that is.

Space complexity: The space complexity is also dependent on the space complexity of BigInteger.pow()

 */

public class Euler016 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int result = 0;
			String product = BigInteger.valueOf(2).pow(n).toString();
			for (char c : product.toCharArray()) {
				result += Character.getNumericValue(c);
			}
			System.out.println(result);
		}

	}

}
