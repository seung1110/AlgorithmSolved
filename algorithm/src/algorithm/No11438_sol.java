package algorithm;

import java.util.*;
import java.io.*;

// 거듭제곱을 빠르게 연산하는 방법을 활용
public class No11438_sol {

	static int N, M;
	static Node[] node;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		node = new Node[N + 1];
		for (int i = 1; i < N + 1; i++) {
			node[i] = new Node(i);
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (x < y) {
				node[x].connect.add(y);
			} else {
				node[y].connect.add(x);
			}

		}

		int[][] root = new int[N+1][N+1];
		int[] depth = new int[N+1];
		int cnt = 1;
		Queue<Node> q = new LinkedList<>();
		q.add(node[1]);
		root[1][0] = 0;
		depth[1] = 0;
	
		while (!q.isEmpty()) {
			Node now = q.poll();
			if (now.connect != null) {
				for (int i : now.connect) {
					root[i][0] = now.num;
					depth[i] = cnt;
					q.add(node[i]);
				}
			}
			cnt++;
		}
		
		//root[1][0] = 0
		//root[2][0] 는 2의 2^0번째 부모 root[2][1]은 2^1번째 부모 => rootroot[2][0]
		
		for(int i = 2; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				root[i][j] = root[root[i][j-1]][j-1]; // i=2 j = 1     root[2][1] = root[2의 부모노드][0]
			}
		}


		M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

		}

		bw.flush();
		bw.close();
	}

	static class Node {
		int num;
		ArrayList<Integer> connect;

		public Node(int num) {
			this.num = num;
			connect = new ArrayList<>();
		}

	}

}
