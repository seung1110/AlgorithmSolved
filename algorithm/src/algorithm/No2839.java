package algorithm;

import java.util.Scanner;

public class No2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 10000;
		for (int i = 0; n - 5 * i >= 0; i++) {
			for (int j = 0; n - 5 * i - 3 * j >= 0; j++) {
				if (5 * i + j * 3 == n) {
					max = max > i + j ? i + j : max;
				}
			}
		}
		if (max == 10000) {
			System.out.println("-1");
		} else {
			System.out.println(max);
		}
	}

}
