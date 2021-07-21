package algorithm;

import java.util.*;

public class No2749 {
	// 피사노 주기 활용
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		long n = sc.nextLong();
		long[] f = new long[1000001];
		// f(n)%1000000 = (f(n-1)%1000000 + f(n-2)%1000000)%1000000

		f[0] = 0;
		f[1] = 1;
//		if (n > 1000001) {
		int i = 2;
		while (i < 1000) {
			f[i] = (f[i - 1] % 1000000 + f[i - 2] % 1000000) % 1000000;
			i++;
		}

//		} else {
//			for (int i = 2; i < n; i++) {
//				f[i] = (f[i-1]%1000000 + f[i-2]%1000000)%1000000;
//			}
//			System.out.println(f[(int)n]);
//			return;
//		}

		for (int j = 0; j < 1000; j++) {
			System.out.print(f[j] + " ");
			if (j % 10 == 0) {
				System.out.println();
			}
		}

	}
}
