package algorithm;

import java.util.*;
import java.io.*;

public class No1922_sol_1 {
	// 크루스칼 활용
	static int N, M, min = 10000000;
	static int cost;
	static int[] root;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()) + 1;
		M = Integer.parseInt(br.readLine());

		root = new int[N];
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return p1.cost - p2.cost;
			}
		});
		
		for (int i = 1; i < N; i++) {
			root[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a, b, cost_num;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			cost_num = Integer.parseInt(st.nextToken());
			pq.add(new Pair(a, b, cost_num));
		}

		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			int root_x = find(p.x);
			int root_y = find(p.y);
			
			if(root_x == root_y) {
				continue;
			}
			
			if(root_x < root_y) {
				root[root_y] = root_x;
			}else {
				root[root_x] = root_y;
			}
			
			cost += p.cost;
		}
		System.out.println(cost);
	}
	static int find(int x) {
		if(root[x] == x)
			return x;
		return find(root[x]);
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
