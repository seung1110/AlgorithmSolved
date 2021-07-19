package algorithm;

import java.util.*;
import java.io.*;
// dp ������� ó��
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

		for (int i = 0; i < N; i++) { // ���� ��ȣ
			for (int j = 0; j <= K; j++) { // ����
				if (j >= weight[i]) {	// ���濡 �� ������ ���
					if (i > 0) {	
						// ���� �ٿ��� ������ ���Ը� �� value + ���� ������ ��ġ�� ���� ���� ���� ������ ��ġ�� ���� �� ū ���� �־��ش�.
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
