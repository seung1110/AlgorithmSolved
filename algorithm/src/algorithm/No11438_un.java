package algorithm;

import java.util.*;
import java.io.*;
// �ð��ʰ�
public class No11438_un {

	static int N, M;
	static Node[] node;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		node = new Node[N+1];
		for(int i = 1; i < N+1;i++) {
			node[i] = new Node(i);
		}
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(x < y) {
				node[x].connect.add(y);				
			}else {
				node[y].connect.add(x);
			}
		
		}
		
		int[] root = new int[N+1];
		
		Queue<Node> q = new LinkedList<>();
		q.add(node[1]);
		root[1] = 1;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			if(now.connect != null) {
				for(int i : now.connect) {
					root[i] = now.num;
					q.add(node[i]);
				}
			}
		}
		
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(root[y] == x) {
				bw.write(x+"");
				bw.write("\n");
				continue;
			}
			
			if(root[x] == y) {
				bw.write(y+"");
				bw.write("\n");
				continue;
			}
			
			while(root[x] != root[y]) {
				if(root[x] < root[y]) {
					y = root[y];
				}else {
					x = root[x];
				}
			}
			
			bw.write(root[x]+"");
			bw.write("\n");
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
