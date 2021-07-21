package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1149 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] house = new int[N][3];
		for(int i = 0; i < N; i++ ) {
			st = new StringTokenizer(br.readLine());
			house[i][0] = Integer.parseInt(st.nextToken());
			house[i][1] = Integer.parseInt(st.nextToken());
			house[i][2] = Integer.parseInt(st.nextToken());
		}
		
		
		int[][] dp = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			if(i == 0) {
				dp[i][0] = house[i][0];
				dp[i][1] = house[i][1];
				dp[i][2] = house[i][2];
				continue;
			}
			
			dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + house[i][0];
			dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + house[i][1];
			dp[i][2] = Math.min(dp[i-1][1],dp[i-1][0]) + house[i][2];

		}
		
		
		
		if(dp[N-1][0] < dp[N-1][1]) {
			System.out.println(Math.min(dp[N-1][0], dp[N-1][2]));
		}else {
			System.out.println(Math.min(dp[N-1][1], dp[N-1][2]));			
		}
		
	}

}
