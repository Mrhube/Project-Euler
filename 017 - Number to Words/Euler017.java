import java.util.Scanner;

/*

Number to Words

====================================================================================================================

Approach: This can be solved using switch statements and some simple recursion. The biggest concern is managing the
spaces between words.

Time complexity: The depth of recusion is a logarithmic function of N, so the time complexity is O(log N)

Space complexity: The space complexity is O(1)

 */

public class Euler017 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			long n = in.nextLong();
			if (n == 0) {
				System.out.println("Zero");
			} else {
				System.out.println(NumberToText(n).trim());
			}
		}
	}

	public static String NumberToText(long i) {

		if (i < Math.pow(10,3)) {
			return NumberBelow1000ToText((int)i).trim();
		} else if (i < Math.pow(10,6)) {
			return NumberBelow1000ToText((int)(i / 1000)).trim() + " Thousand " + NumberBelow1000ToText((int)(i % 1000)).trim();
		} else if (i < Math.pow(10,9)) {
			return NumberBelow1000ToText((int)(i / Math.pow(10,6))).trim() + " Million " + NumberToText((int)(i % Math.pow(10,6))).trim();
		} else if (i < Math.pow(10,12)) {
			return NumberBelow1000ToText((int)(i / Math.pow(10,9))).trim() + " Billion " + NumberToText((int)(i % Math.pow(10,9))).trim();
		} else if (i < Math.pow(10,15)) {
			return NumberBelow1000ToText((int)(i / Math.pow(10,12))).trim() + " Trillion " + NumberToText((long)(i % Math.pow(10,12))).trim();
		} else {
			return "Number out of range";
		}
	}

	public static String NumberBelow1000ToText(int i) {

		if (i < 20) {
			switch (i) {
				case 0:
					return "";
				case 1:
					return "One";
				case 2:
					return "Two";
				case 3:
					return "Three";
				case 4:
					return "Four";
				case 5:
					return "Five";
				case 6:
					return "Six";
				case 7:
					return "Seven";
				case 8:
					return "Eight";
				case 9:
					return "Nine";
				case 10:
					return "Ten";
				case 11:
					return "Eleven";
				case 12:
					return "Twelve";
				case 13:
					return "Thirteen";
				case 14:
					return "Fourteen";
				case 15:
					return "Fifteen";
				case 16:
					return "Sixteen";
				case 17:
					return "Seventeen";
				case 18:
					return "Eighteen";
				default:
					return "Nineteen";
			}
		} else if (i < 30) {
			return "Twenty " + NumberBelow1000ToText(i - 20);
		} else if (i < 40) {
			return "Thirty " + NumberBelow1000ToText(i - 30);
		} else if (i < 50) {
			return "Forty " + NumberBelow1000ToText(i - 40);
		} else if (i < 60) {
			return "Fifty " + NumberBelow1000ToText(i - 50);
		} else if (i < 70) {
			return "Sixty " + NumberBelow1000ToText(i - 60);
		} else if (i < 80) {
			return "Seventy " + NumberBelow1000ToText(i - 70);
		} else if (i < 90) {
			return "Eighty " + NumberBelow1000ToText(i - 80);
		} else if (i < 100) {
			return "Ninety " + NumberBelow1000ToText(i - 90);
		} else {
			return NumberBelow1000ToText(i / 100) + " Hundred " + NumberBelow1000ToText(i % 100);
		}
	}
}
