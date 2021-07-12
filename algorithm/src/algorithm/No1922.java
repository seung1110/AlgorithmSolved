package algorithm;

import java.util.*;
import java.io.*;
public class No1922 {
	// 시간 초과

	static int N,M, min = 10000000;
	static int[][] cost;
	static boolean[] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine())+1;
		M = Integer.parseInt(br.readLine());
		
		cost = new int[N][N];
		v = new boolean[N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a, b, cost_num;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			cost_num = Integer.parseInt(st.nextToken());
			cost[a][b] = cost_num;
		}
		
//		for(int i = 1; i < N; i++) {
//			for(int j = 1; j < N; j++) {
//				System.out.print(cost[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		
		

			rec(1,0);

		
		System.out.println(min);
	}

	static void rec(int len, int c) {		
		if(len == N - 1) {
			if(min > c) {
				min = c;
			}
			return ;
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 1; j < N; j++) {
				if(i == j || cost[i][j] == 0) {
					continue;
				}
				if(!v[i]) {
					v[i] = true;
					rec(len+1,c+cost[i][j]);
					v[i] = false;
				}
			}
		}
		
	}
}
