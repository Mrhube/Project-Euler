import java.util.*;

/*

10001st Prime

====================================================================================================================

Approach: Again this is a straightforward problem where not repeating calculations is important because of the
high upper limit on the number of test cases. It can be solved using brute force because there is not an equation
that can find all the necessary prime numbers. Run time can be improved my minimizing the number of values that are
iterated over. For example, no even number except 2 can be prime, so the code will only check odd numbers. The
function to determine if a number is prime from Euler problem 3 can be reused.

Time complexity: It is difficult to determine the time-complexity because the code utilizes a while loop that will
run until it finds the specified number of prime numbers. The run time increases with increasing values of N.

Space complexity: The space complexity is O(N) because this approach saves all of the prime numbers to an array to
make solving multiple test cases faster.

 */

public class Euler007 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		long[] primes = new long[10001];
		primes[1] = 2;
		primes[2] = 3;
		int numOfPrimesFound = 2;

		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();

			while (n > numOfPrimesFound) {

				long x = primes[numOfPrimesFound] + 2;	// Increment by 2 to check next odd number

				while (!isPrime(x)) {

					x += 2;
				}

				numOfPrimesFound++;
				primes[numOfPrimesFound] = x;

			}

			System.out.println(primes[n]);

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