package algorithm;

import java.util.*;
import java.io.*;

public class No1753_sol {

	static int V, E, start;
	static int[] cost;
	static ArrayList<Node>[] list;
	static final int INF = 1000000000;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());

		cost = new int[V + 1];
		visited = new boolean[V + 1];
		list = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		Arrays.fill(cost, INF);
		cost[start] = 0;

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[v1].add(new Node(v2, c));
		}

		sol();

		for (int i = 1; i <= V; i++) {
			if (cost[i] != INF) {
				bw.write(cost[i] + "\n");
			} else {
				bw.write("INF\n");
			}
		}
		bw.flush();
		bw.close();

	}

	static void sol() {
		PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				return n1.cost - n2.cost;
			}
		});
		q.add(new Node(start,0));

		while (!q.isEmpty()) {
			int idx = q.poll().v;
			
			if(visited[idx])
				continue;
			visited[idx] = true;
			
			ArrayList<Node> now = list[idx];
			for (Node n : now) {
				if (cost[n.v] > cost[idx] + n.cost) {
					cost[n.v] = cost[idx] + n.cost;
					q.add(new Node(n.v,cost[n.v]));
				}
			}

		}
	}

	static class Node {
		int v;
		int cost;

		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
	}
}
