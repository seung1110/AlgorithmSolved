package algorithm;

import java.util.*;
import java.io.*;

// 못품
public class No1167 {

	static final int INF = Integer.MAX_VALUE;
	static int V;
	static ArrayList<Pair> tree[];
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		V = Integer.parseInt(br.readLine());
		tree = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++) {
			tree[i] = new ArrayList<Pair>();
		}

		for (int i = 0; i < V; i++) { // 입력 반영
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			while (true) {
				int node = Integer.parseInt(st.nextToken());
				if (node == -1) {
					break;
				}
				int cost = Integer.parseInt(st.nextToken());
				tree[n].add(new Pair(n, node, cost));
			}
		}

		int max = 0;

		for (int i = 1; i <= V; i++) {
			visited = new boolean[V + 1];
			max = Math.max(max, bfs(i));
			System.out.println(bfs(i));
		}
		System.out.println(max);

//		입력 확인
//		for(int i = 1; i <= V; i++) {
//			for(int j = 1;  j <=V; j++) {
//				System.out.print(tree[i][j] + " ");
//			}
//			System.out.println();
//		}

	}

	static int bfs(int start) {
		visited[start] = true;
		int max = 0;

		for (Pair p : tree[start]) {
			if (!visited[p.y]) {

				int temp = bfs(p.y) + p.cost;
				max = Math.max(temp, max);
			}
		}

		visited[start] = false;

		return max;
	}

	static class Pair {
		int x, y, cost;

		public Pair(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

	}
}
