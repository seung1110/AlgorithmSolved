package algorithm;

import java.util.*;
import java.io.*;

public class No1245 {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] move = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } }; //대각선 포함
//	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[100][100];

		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					dfs(i, j);
					answer++;

				}
			}
		}
		System.out.println(answer);

	}

	static void dfs(int start, int end) {
		if (visited[start][end]) {
			return ;
		}
		visited[start][end] = true;


		for (int i = 0; i < 8; i++) {
			int nextX = start + move[i][0];
			int nextY = end + move[i][1];

			if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
				continue;
			}

			if (!visited[nextX][nextY] && map[nextX][nextY] != 0) {
				int n = map[start][end] - map[nextX][nextY];
				n = n > 0 ? n : -n;
				if (n < 2) {
					dfs(nextX, nextY);
				}
			}

		}
	}
}
