package algorithm;

import java.util.*;
import java.io.*;
// dp 방식으로 처리
public class No12865 {

	static int N, K;
	static int[][] dp;
	static int[] weight, value;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		weight = new int[N];
		value = new int[N];

		dp = new int[N][K + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) { // 물건 번호
			for (int j = 0; j <= K; j++) { // 무게
				if (j >= weight[i]) {	// 가방에 들어갈 무게일 경우
					if (i > 0) {	
						// 이전 줄에서 현재의 무게를 뺀 value + 현재 물건의 가치와 이전 줄의 현재 무게의 가치를 비교해 더 큰 값을 넣어준다.
						dp[i][j] = Math.max(dp[i - 1][j - weight[i]] + value[i], dp[i - 1][j]);
					}else {
						dp[i][j] = value[i];
					}
				} else {
					if (i > 0)
						dp[i][j] = dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[N - 1][K]);

	}

}
