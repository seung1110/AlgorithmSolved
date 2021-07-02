package algorithm;

import java.util.*;

public class No1260 {

	static int n;
	static int m;
	static int v;
	static int[][] graph = new int[1001][1001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		boolean[] visited1 = new boolean[n + 1];
		dfs(v, visited1);
		System.out.println();
		boolean[] visited2 = new boolean[n + 1];
		bfs(v, visited2);

	}

	static void dfs(int x, boolean[] v) {
		if (x < 1 || x > n) {
			return;
		}

		if (!v[x]) {
			v[x] = true;
			System.out.print(x + " ");

			for (int i = 1; i <= n; i++) {
				if (graph[x][i] == 1) {
					dfs(i, v);
				}
			}
		}

	}

	static void bfs(int x, boolean[] v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			if(v[now]) {
				continue;
			}
			v[now] = true;
			System.out.print(now + " ");
			
			for(int i = 1 ; i <= n ; i ++) {
				if(graph[now][i] == 1 && !v[i]) {
					q.add(i);
				}
			}
			
		}
		
	}

}
