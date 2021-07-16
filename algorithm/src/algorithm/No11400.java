package algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class No11400 {

	static int V,E;
	static int[][] tree;
	static int[] discover,low; 
	static int dis;
	static boolean[] answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		tree = new int[V+1][V+1];
		discover = new int[V+1];
		low = new int[V+1];
		answer = new boolean[V+1];
		
		for(int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			tree[x][y] = 1;
			tree[y][x] = 1;
		}
		
		dfs(1,1);
		
		for(int i = 1; i <= V; i++) {
			if(discover[i] <= low[i])
				answer[i] = true;
		}
		
		
		System.out.println();
		for(int i = 1; i <= V; i++) {
			System.out.print(i + " : " +answer[i] + " / ");
		}
		
		System.out.println();
		
		for(int i = 1; i <= V; i++) {
			System.out.print(i + " : " +discover[i] + " / ");
		}
		System.out.println();
		for(int i = 1; i <= V; i++) {
			System.out.print(i + " : " +low[i] + " / ");
		}
		
		
	}
	
	static void dfs(int parent, int start) {
		if(discover[start] != 0) {	// 이미 방문한 곳일 경우
			return;
		}
		
		discover[start] = low[start] = ++dis;	// 아닐 경우 dis 추가
		if(start == 6) {
			System.out.println("discover 6 is "  + discover[start]);
		}
	
		for(int i = 1; i <= V; i++) {
			if(i == parent) {
				continue;
			}
			if(tree[start][i] == 1) {	// 자식들 탐색
				dfs(start,i);
				low[start] = Math.min(low[start], low[i]);
			}
		}
		
	}

}
