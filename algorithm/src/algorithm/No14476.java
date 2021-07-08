package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * array에서 하나의 값을 제거했을 때 최대공약수는 해당 값 기준으로 좌 우 값들의 최대공약수의 최대공약수
 * 
 *     8  12  24  36  48  
 *           [24]를 제거했을 때의 최대공약수
 *     8과 12의 최대공약수(4)      36과 48의 최대공약수(12)
 *     4와 12의 최대공약수인 4가 24를 제거했을 때의 최대공약수
 *     
 *     8  12  24  36  48
 *               [36] 제거시
 *     8과 12의 최대공약수 4 , 12와 24의 최대공약수 12   4와 12의 최대공약수 4  (== 8,12,24의 최대 공약수)
 *     48의 최대공약수 48
 *     4와 48의 최대공약수 4가 36제거했을 때의 최대공약수
 */
public class No14476 {

	static int N;
	static int[] arr;
	static int[] left_gcd, right_gcd;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N + 2];
		left_gcd = new int[N + 2];
		right_gcd = new int[N + 2];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			left_gcd[i] = gcd(left_gcd[i - 1], arr[i]);
		}
		

		
		for (int i = N; i >= 1; i--) {
			right_gcd[i] = gcd(right_gcd[i + 1], arr[i]);
		}

		int answer = -1, where = 0;

		for (int i = 1; i <= N; i++) {
			int curGcd = gcd(left_gcd[i - 1], right_gcd[i + 1]);
			System.out.println(curGcd);
			if (arr[i] % curGcd == 0) // 약수인 경우
				continue;

			if (answer < curGcd) {
				answer = curGcd;
				where = arr[i];
			}
		}

		if (answer == -1) {
			System.out.println(answer);
		}else {
			System.out.println(answer + " " + where);
		}

	}

	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

}
