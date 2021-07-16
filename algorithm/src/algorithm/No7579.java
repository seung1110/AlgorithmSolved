package algorithm;

import java.util.*;
import java.io.*;

public class No7579 {
	static int N, M;
	static int[][] dp;
	static int[] memory, cost;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		memory = new int[N];
		cost = new int[N];
		dp = new int[N][10001];

		// 초기 세팅
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int c = cost[i];
			int m = memory[i];
			for (int j = 0; j < 10001; j++) { // dp[0][0] 은 0번째 앱 통해서 0코스트 활용해서 얻을 수 있는 최대 메모리
				if (i == 0) { // i가 0일 경우
					if (j >= c)
						dp[i][j] = m;

				} else {
					if (j >= c) {
						// dp[i-1][j-c]는 현재의 코스트를 제외하고 이전 앱들을 통해 얻은 메모리의 양 + 현재의 메모리
						// dp[i-1][j]는 이전 앱들을 통해 얻은 메모리
						dp[i][j] = Math.max(dp[i - 1][j - c] + m, dp[i - 1][j]);
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}

				if (dp[i][j] >= M) {
					ans = Math.min(ans, j);
				}
			}
		}

		System.out.println(ans);
	}

}
