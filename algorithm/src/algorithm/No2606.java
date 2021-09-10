package algorithm;

import java.io.*;
import java.util.*;
public class No2606 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr[] = new ArrayList[n+1];
		
		for(int i = 1; i < arr.length;i++) {
			arr[i] = new ArrayList<>();
		}
		
		boolean[] visited = new boolean[n+1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		System.out.println(bfs(arr,visited));
		
		
	}
	static int bfs(ArrayList<Integer>[] arr, boolean[] visited) {
		int cnt = 0;
		Deque<Integer> q = new ArrayDeque<>();
		
		for(int i : arr[1]) {
			q.add(i);
		}
		
		visited[1] = true;
		while(!q.isEmpty()) {
			int temp = q.pollFirst();
			if(!visited[temp]) {
				for(int i : arr[temp]) {
					q.add(i);
				}
				visited[temp] = true;
				cnt++;
			}
		}
		return cnt;
	}


}
