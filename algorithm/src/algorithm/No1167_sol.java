package algorithm;

import java.util.*;
import java.io.*;

public class No1167_sol {

	static final int INF = Integer.MAX_VALUE;
	static int V;
	static ArrayList<Pair> tree[];
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		V = Integer.parseInt(br.readLine());
		tree = new ArrayList[V + 1];
		visited = new boolean[V+1];

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
		System.out.println(bfs(1));
	}

	static int bfs(int start) {
		int[] max = new int[V + 1];

		Queue<Pair> q = new LinkedList<>();
		tree[start].stream().forEach(p -> {
			q.add(p);
		});
		int degree = 0;
		
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair now = q.poll();
				if(visited[now.x]) {
					continue;
				}
				if (degree == 0) {
					max[degree] = Math.max(max[degree], now.cost);
					System.out.println(max[degree]);
				} else {
					max[degree] = Math.max(max[degree-1]+now.cost, max[degree]);
				}
				visited[now.x] = true;
				tree[now.y].stream().forEach(p -> {
					q.add(p);
				});
			}
			degree++;
		}
		
		int answer = 0;
		for(int i = 0; i <= V; i++) {
			answer = Math.max(answer,max[i]);
		}
		
		

		return answer;
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
