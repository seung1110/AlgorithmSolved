package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No11062 {

	static int T,N;
	static int[][] dp;
	static int[] card;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			card = new int[N];
			dp = new int[N][N];
			
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				card[j] = Integer.parseInt(st.nextToken());
			}
			int l = 0;
			int r = N-1;
			int res = rec(l,r);
			bw.write(res+"\n");
			
		}
		bw.flush();
		bw.close();
	}
	static int rec(int l, int r) {
		if(r-l < 0) // 카드 수가 0보다 적을 때
			return 0;
		
		if(dp[l][r] != 0) {	
			return dp[l][r];
		}
		
		if(r-l <= 1) {	// 카드가 두장일 때 최대값 선택이 최선의 수
			dp[l][r] = Math.max(card[l],card[r]);
			return dp[l][r];
		}
		
		// 왼쪽 카드를 뽑았을 때, 다른친구는 왼쪽 또는 오른쪽 뽑는다!
		dp[l][r] = card[l] + Math.min(rec(l+2,r),rec(l+1,r-1));  // 다른 친구가 뽑은거 반영 후 다른친구도 최적의 값을 고르므로 작은 값 선택
		
		//오른쪽 카드를 뽑았을 때, 다른 친구는 오른쪽 또는 왼쪽을 뽑는다. // 오른쪽 뽑았을 때와 왼쪽 뽑았을 때 중 큰 값을 선택
		dp[l][r] = Math.max((card[r] + Math.min(rec(l,r-2), rec(l+1,r-1))), dp[l][r]);	
												
		return dp[l][r];
	}
	
	
}
