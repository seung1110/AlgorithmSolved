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
		if(r-l < 0) // ī�� ���� 0���� ���� ��
			return 0;
		
		if(dp[l][r] != 0) {	
			return dp[l][r];
		}
		
		if(r-l <= 1) {	// ī�尡 ������ �� �ִ밪 ������ �ּ��� ��
			dp[l][r] = Math.max(card[l],card[r]);
			return dp[l][r];
		}
		
		// ���� ī�带 �̾��� ��, �ٸ�ģ���� ���� �Ǵ� ������ �̴´�!
		dp[l][r] = card[l] + Math.min(rec(l+2,r),rec(l+1,r-1));  // �ٸ� ģ���� ������ �ݿ� �� �ٸ�ģ���� ������ ���� ���Ƿ� ���� �� ����
		
		//������ ī�带 �̾��� ��, �ٸ� ģ���� ������ �Ǵ� ������ �̴´�. // ������ �̾��� ���� ���� �̾��� �� �� ū ���� ����
		dp[l][r] = Math.max((card[r] + Math.min(rec(l,r-2), rec(l+1,r-1))), dp[l][r]);	
												
		return dp[l][r];
	}
	
	
}
