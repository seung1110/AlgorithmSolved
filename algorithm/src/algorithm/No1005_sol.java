package algorithm;

import java.util.*;
import java.io.*;
// BFS + DP
public class No1005_sol {

	static int T;
	static Connect[] con;
	static int[] time;
	static int[] cache;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			time = new int[N + 1];

			boolean[] v = new boolean[N+1];
			cache = new int[N+1];
			Arrays.fill(cache, -1);
			
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				time[j] = Integer.parseInt(st.nextToken());
			}
			con = new Connect[N+1];
			for(int k = 1; k <= N; k++) {
				con[k] = new Connect(k);
			}
			
			for (int j = 1; j <= K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				con[y].list.add(x);
			}

			int victory = Integer.parseInt(br.readLine());
			
			bw.write(rec(con[victory], v)+"\n");
		}
		bw.flush();
		bw.close();
	}
	static class Connect{
		int num;
		ArrayList<Integer> list;
		public Connect(int num) {
			this.num = num;
			list = new ArrayList<>();
		}
	}
	
	static int rec(Connect key, boolean[] v) {
		v[key.num] = true;	// 방문 체크
		int max = 0;
		
		if(cache[key.num] != -1) {
			return cache[key.num];
		}
		
		
		if(key.list.size() == 0) {
			return time[key.num];
		}
		
		for(int i : key.list) {
			v[i] = true;
			int temp = rec(con[i],v);
			if(cache[i] == -1) {
				cache[i] = temp;
			}
			max = max > temp ? max : temp;
			v[i] = false;
		}
		
		max += time[key.num];
		
		return max;
	}

}
