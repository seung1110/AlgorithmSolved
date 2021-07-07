package algorithm;

import java.util.Scanner;

public class No2748 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		if(N < 2) {
			System.out.println(N);
			return;
		}
		long[] arr = new long[N+1];
		arr[0] = 0;
		arr[1] = 1;
		for(int i = 2; i <= N; i++ ) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		System.out.println(arr[N]);
	}


}
