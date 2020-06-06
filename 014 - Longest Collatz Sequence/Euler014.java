import java.util.*;

public class Euler014 {

	/*

	https://projecteuler.net/problem=14

	Problem: An iterative sequence is defined for the set of positive integers:

	n -> n/2 (if n is even)
	n -> 3n+1 (if n is odd)

	Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

	Which starting number, <= N produces the longest chain? If many possible such numbers are there print the maximum
	one. Note that once the chain starts the terms are allowed to go above N.

	Input Format: The first line contains an integer T, i.e., number of test cases.
	Next T lines will contain an integer N.

	Constraints:
	1 <= T <= 10^4
	1 <= N <= 5 * 10^6

	====================================================================================================================

	Approach: Calculating each value in the chain is straightforward, but will need to be done many times to solve each
	test case. By using memoization, repeating calculations can be avoided. I initially tried using a dictionary to
	store the next value in the chain for each value of n because it is unknown how high n will go. However this did not
	meet the time limit for Hackerrank. It was much faster to store the values in an array for faster lookup when n <= N
	and to just recalculate values for n > N when they occurred.

	Time complexity: The time complexity is difficult to determine because it is unknown how many values will be in each
	chain. The runtime will increase with increasing N.

	Space complexity: The space complexity is O(1), but is dependent on the upper bound of N.

	 */

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		int[] chainLengths = new int[5000001];
		int[] solution = new int[5000001];
		int[] maxChainLengths = new int[5000001];
		chainLengths[1] = 1;
		int maxN = 0;

		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			if (solution[n] == 0) {
				int maxChainLength = maxChainLengths[maxN];
				int maxSolution = solution[maxN];
				int chainLength;
				for (int i = maxN + 1; i <= n; i++) {
					chainLength = GetChainLength(i, chainLengths);

					if (chainLength >= maxChainLength) {
						maxSolution = i;
						maxChainLength = chainLength;
						solution[i] = i;
						maxChainLengths[i] = chainLength;
					} else {
						solution[i] = maxSolution;
						maxChainLengths[i] = maxChainLength;
					}
				}
			}
			maxN = n;
			System.out.println(solution[n]);
		}
	}

//	public static int GetChainLength(long i, Map<Long,Integer> chainLength) {
//		// Handle the base case
//		if (i == 1) return 1;
//		// If chain length has been found for this value before, look it up in the map
//		if (chainLength.containsKey(i)) return chainLength.get(i);
//		// Else, calculate the chain length using recursion and save the result for future use
//		int result = 1 + GetChainLength(CalculateNextValue(i), chainLength);
//		chainLength.put(i,result);
//		return result;
// 	}

	public static int GetChainLength(long i, int[] chainLengths) {
		if (i >= chainLengths.length) return 1 + GetChainLength(CalculateNextValue(i), chainLengths);
		int result = chainLengths[(int)i];
		//
		if (result != 0) return result;
		// Else, calculate the chain length using recursion and save the result for future use
		result = 1 + GetChainLength(CalculateNextValue(i), chainLengths);
		chainLengths[(int)i] = result;
		return result;
	}

	/*
	public static int GetChainLengthIteration(int i, Map<Long,Integer> chainLengths) {
		long j = i;
		int count = 0;
		int result;
		Queue<Long> chain = new LinkedList<>();

		while (!chainLengths.containsKey(j)) {
			chain.add(j);
			count++;
			j = CalculateNextValue(j);
		}
		count += chainLengths.get(j);
		result = count;

		while (chain.size() > 0) {
			j = chain.poll();
			chainLengths.put(j,count);
			count--;
		}
		return result;
	}*/

	public static long CalculateNextValue(long i) {
		if (i % 2 == 0) {
			return i / 2;
		} else {
			return 3 * i + 1;
		}
	}
}