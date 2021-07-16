package algorithm;

import java.util.*;
import java.io.*;
// DFS + DP
public class No1005 {

	static int T, N;
	static Connect[] con;
	static int[] time;
	static int[][] cache;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			time = new int[N + 1];

			cache = new int[N + 1][N+1];
			for(int a = 0; a < N+1; a++) {
				for(int b =0; b < N+1; b++) {
					cache[a][b] = -1;
				}
			}

			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				time[j] = Integer.parseInt(st.nextToken());
			}
			con = new Connect[N + 1];
			for (int k = 1; k <= N; k++) {
				con[k] = new Connect(k);
			}

			for (int j = 1; j <= K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				con[y].list.add(x);
			}

			int victory = Integer.parseInt(br.readLine());

			System.out.println(rec(victory,0));
		}
		bw.flush();
		bw.close();
	}

	static class Connect {
		int num;
		ArrayList<Integer> list;

		public Connect(int num) {
			this.num = num;
			list = new ArrayList<>();
		}
	}

	static int rec(int key, int degree) {
		
		if(cache[key][degree] != -1) {	// 최대값이 0인 경우가 있으므로 cache를 -1로 초기화해야 한다.
			return cache[key][degree];
		}
		
		if(con[key].list.size() == 0) {	// list의 size가 0인 경우 값을 반환
			return time[key];
		}
		int max = 0;
		
		for(int i : con[key].list) {
			if(max < rec(i,degree+1)) {
				max = rec(i,degree+1);
			}
		}
		
		max += time[key];	// 구한 max 값에 자신의 값을 더해서 반환
		cache[key][degree] = max;	// cache 저장
		return max;
	}
	

}
