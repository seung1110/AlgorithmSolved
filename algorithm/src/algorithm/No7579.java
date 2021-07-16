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

		// �ʱ� ����
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
			for (int j = 0; j < 10001; j++) { // dp[0][0] �� 0��° �� ���ؼ� 0�ڽ�Ʈ Ȱ���ؼ� ���� �� �ִ� �ִ� �޸�
				if (i == 0) { // i�� 0�� ���
					if (j >= c)
						dp[i][j] = m;

				} else {
					if (j >= c) {
						// dp[i-1][j-c]�� ������ �ڽ�Ʈ�� �����ϰ� ���� �۵��� ���� ���� �޸��� �� + ������ �޸�
						// dp[i-1][j]�� ���� �۵��� ���� ���� �޸�
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
