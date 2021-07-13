package algorithm;

import java.util.*;
import java.io.*;
// 메모리 초과
public class No1753 {

	static int V,E, start;
	static int[] cost;
	static Graph[] g;
	static final int INF = 2000000000;
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		
		cost = new int[V+1];
		
		for(int i = 1; i < cost.length;i++) {
			if(i == start) {
				cost[i] = 0;
			}else {
				cost[i] = INF;
			}
		}
		
		g = new Graph[V+1];
		
		for(int i = 1; i < g.length; i++) {
			g[i] = new Graph(i);
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			g[v1].nodes.add(new Node(v2, c));
		}
		
		Queue<Graph> q = new LinkedList<>();
		q.add(g[start]);
		
		while(!q.isEmpty()) {
			Graph now = q.poll();
			
			for(Node n : now.nodes) {
				q.add(g[n.num]);
				if(cost[n.num] > cost[now.v] + n.val) {
					cost[n.num] = cost[now.v] + n.val;
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			if(cost[i] != INF) {
				bw.write(cost[i]+"\n");
			}else {
				bw.write("INF\n");
			}
		}
		bw.flush();
		bw.close();
		
	}
 	static class Graph{
 		int v;
 		ArrayList<Node> nodes;

 		public Graph(int v) {
 			this.v = v;
 			nodes = new ArrayList<>();
 		}
 	}
 	
 	static class Node{
 		int num,val;
 		public Node(int num, int val) {
 			this.num = num;
 			this.val = val;
 		}
 	}
}
