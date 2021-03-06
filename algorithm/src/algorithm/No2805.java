package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2805 {

	static int N, M;
	static long[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);

		long max = 2000000000;
		long min = 0;
		long mid;

		long answer = 0;
		while (min <= max) {
			mid = (max + min) / 2;
			if (cut_ok(mid)) {
				if(mid > answer) {
					answer = mid;
				}
				min = mid+1;
			} else {
				max = mid-1;
			}
		}
		System.out.println(answer);
	}

	static boolean cut_ok(long height) {
		int sum = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (arr[i] - height > 0) {
				sum += arr[i] - height;
				if(sum >= M) {
					break;
				}
			} else {
				break;
			}
		}
		return sum >= M;
	}

}
