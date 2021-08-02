package algorithm;

import java.util.*;
import java.io.*;

public class No1167_sol {

	static int V,MAX_LEN,MAX_P;
	static ArrayList<Pair> tree[];
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		V = Integer.parseInt(br.readLine());
		tree = new ArrayList[V + 1];
		visited = new boolean[V+1];
		MAX_LEN = MAX_P = 0;

		for (int i = 1; i <= V; i++) {
			tree[i] = new ArrayList<Pair>();
		}

		for (int i = 0; i < V; i++) {
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
		fun(1,0); // ??? ??? ?? ? ??? ??? ?? ?? ??? ?? ??? ????.
		visited[1] = false;
		fun(MAX_P,0);
		System.out.println(MAX_LEN);


	}

	static void fun(int start, int len) {
		visited[start] = true;
		if(len > MAX_LEN){
			MAX_LEN = len;
			MAX_P = start;
		}

		for(Pair p : tree[start]){
			if(!visited[p.y]){
				fun(p.y,len+p.cost);
				visited[p.y] = false;
			}
		}
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
