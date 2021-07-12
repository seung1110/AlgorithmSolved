package algorithm;

import java.io.*;
import java.util.*;

public class No2252 {

	static int N, M;
	static int[] check;
	static Node[] node;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()) + 1;
		M = Integer.parseInt(st.nextToken());

		check = new int[N];
		node = new Node[N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(node[a] == null) {
				node[a] = new Node();
			}
			node[a].list.add(b);
			check[b]++;
		}

		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i < N; i++) {
			if(check[i] == 0) {	// 0일 경우 출력, 해당 노드와 연결된 노드들의 차수를 줄이기위해 큐에 추가
				bw.write(i + " ");
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int num = q.poll();
			
			if(node[num] != null && node[num].list.size() > 0) {
				for(int i : node[num].list) {
					check[i]--;
					if(check[i] == 0) {
						bw.write(i + " ");
						q.add(i);
					}
				}
			}
		}
		
		
		bw.flush();
		bw.close();

	}
	static class Node{
		ArrayList<Integer> list;
		
		public Node() {
			list = new ArrayList<>();
		}
	}
}
