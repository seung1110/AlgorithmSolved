package algorithm;

import java.util.*;
import java.io.*;

public class No11404 {

	static int N, M;
	static int[][] city;
	static final int INF = 1000000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		city = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i!=j) {
					city[i][j] = INF;
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(city[a][b] == INF) {
				city[a][b] = cost;
			}else {
				if(city[a][b] > cost) {
					city[a][b] = cost;
				}
			}
		}
		
		for(int k = 1; k <= N; k++) {	// ��� k�� ���İ� ���
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					city[i][j] = min(city[i][j],city[i][k]+city[k][j]);
					// city[i][k]  i���� k�� �湮 �� k ���� j�� �湮
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {	// �̵� ����� ���� ��� �������� INF => 0���� ����
			for(int j = 1; j <= N; j++) {
				if(city[i][j] == INF) {
					city[i][j] = 0;
				}
			}
		}
		
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				bw.write(city[i][j]+" ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		
	}
	
	static public int min(int x, int y) {
		int temp = x < y ? x : y;
		return temp;
	}

}
