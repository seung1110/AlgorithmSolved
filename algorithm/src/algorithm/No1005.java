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
		
		if(cache[key][degree] != -1) {	// �ִ밪�� 0�� ��찡 �����Ƿ� cache�� -1�� �ʱ�ȭ�ؾ� �Ѵ�.
			return cache[key][degree];
		}
		
		if(con[key].list.size() == 0) {	// list�� size�� 0�� ��� ���� ��ȯ
			return time[key];
		}
		int max = 0;
		
		for(int i : con[key].list) {
			if(max < rec(i,degree+1)) {
				max = rec(i,degree+1);
			}
		}
		
		max += time[key];	// ���� max ���� �ڽ��� ���� ���ؼ� ��ȯ
		cache[key][degree] = max;	// cache ����
		return max;
	}
	

}
