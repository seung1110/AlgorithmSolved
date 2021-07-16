package algorithm;

import java.util.*;
import java.io.*;

public class No2449 {
	static int N, K;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		dp = new int[N][K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

		}


	}

	static int sol(int l, int r) {
		if(dp[l][r] != 0)
			return dp[l][r];
		
		
		
		return 0;
	}

}
