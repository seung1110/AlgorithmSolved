package SWEA;

import java.util.*;
import java.io.*;

public class No2383 {
	static int T, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			ArrayList<Pair> stair = new ArrayList<>();
			ArrayList<Pair> person = new ArrayList<>();

			for (int j = 0; j < N; j++) { // 초기값 설정
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
					if (map[j][k] > 1) {
						stair.add(new Pair(j, k, map[j][k]));
					}
					if (map[j][k] == 1) {
						person.add(new Pair(j, k));
					}
				}
			}
			

			bw.write("#" + (T + 1) + " " + "\n");
		}

		bw.flush();
		bw.close();
	}

	static class Pair {
		int x, y;
		int cost;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Pair(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
}
