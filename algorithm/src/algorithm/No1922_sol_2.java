package algorithm;

import java.util.*;
import java.io.*;

public class No1922_sol_2 {
	// 크루스칼 활용
	static int N, M, min = 10000000;
	static int cost;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()) + 1;
		M = Integer.parseInt(br.readLine());
		Node[] node = new Node[N];


		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a, b, cost_num;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			cost_num = Integer.parseInt(st.nextToken());
			
			if(node[a] == null) {
				node[a] = new Node(a);
			}
			if(node[b] == null) {
				node[b] = new Node(b);
			}
			node[a].connect.add(node[b]);
			node[a].cost[b] = cost_num;
			node[b].connect.add(node[a]);
			node[b].cost[a] = cost_num;
		}
		
		
		
		for(int i = 0; i < N; i++) {
		
		}
		


	
		System.out.println(cost);
	}

	static class Node {
		int x;
		ArrayList<Node> connect;
		int[] cost;

		public Node(int x) {
			this.x = x;
			this.connect = new ArrayList<>();
			this.cost = new int[N];
		}
	}
}
