package algorithm;

import java.util.*;
import java.io.*;

public class No1005 {

	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] time = new int[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				time[j] = Integer.parseInt(st.nextToken());
			}

			int[] sum_time = new int[N + 1];

			for (int j = 1; j < N + 1; j++) {
				sum_time[j] = time[j];
			}

//			PriorityQueue<Pair> q = new PriorityQueue<>(new Comparator<Pair>() {
//				@Override
//				public int compare(Pair p1, Pair p2) {
//					if (p1.x == p2.x) {
//						return p1.y - p2.y;
//					}
//					return p1.x - p2.x;
//				}
//			});
			List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			for(int k = 0; k < N+1; k++) {
				list.add(new ArrayList<Integer>());
			}
			for (int j = 1; j <= K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.get(y).add(x);
			}

//			while (!q.isEmpty()) {
//				Pair now = q.poll();
//				sum_time[now.y] = sum_time[now.y] > sum_time[now.x] + time[now.y] ? sum_time[now.y] : sum_time[now.x] + time[now.y];
//			}
			int victory = Integer.parseInt(br.readLine());
			
			ArrayList<Integer> temp = list.get(victory);
			System.out.println(temp);
			while(temp.size() != 0) {	
				int max = -1;
				int idx = 0;
				int cnt = 0;
				for(int k = 0; k < temp.size(); k++) {
					if(max < list.get(temp.get(k)).size()) {
						max = list.get(temp.get(k)).size();
						idx = i;
					}
				}
				for(int k = 0; k < temp.size(); k++) {
					if(max == list.get(temp.get(k)).size()) {
						cnt++;
					}
				}
				
				if(cnt > 1) {
					
				}
				
				sum_time[victory] += time[idx];
				temp = list.get(idx);
	
			}
			
			
			bw.write(sum_time[victory] + "\n");
		}
		bw.flush();
		bw.close();
	}

//	static class Pair {
//		int x, y;
//
//		public Pair(int x, int y) {
//			this.x = x;
//			this.y = y;
//		}
//	}
}
