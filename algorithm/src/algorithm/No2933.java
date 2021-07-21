package algorithm;

import java.util.*;
import java.io.*;

public class No2933 {
	static char[][] map;
	static int R, C;
	static int[][] move = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };// 상,좌,우,하

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R + 1][C];

		for (int i = R; i > 0; i--) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int height = R + 1 - Integer.parseInt(st.nextToken());
			int change_C = change(i, height); // 삭제된 미네랄 위치

			if(change_C == -1) {
				continue;
			}
			
			ArrayList<Pair> list = new ArrayList<>();

			for (int j = 0; j < 3; j++) {
				int next_x = height + move[j][0];
				int next_y = change_C + move[j][1];

				if (next_x > 0 && next_x < R + 1 && next_y >= 0 && next_y < C) {
					if (map[next_x][next_y] == 'x') {
						if (check(next_x, next_y).size() != 0) {
							list = check(next_x, next_y);
						}
					}
				}

			}

			for(int a = R; a > 0; a-- ) {
				for(int j = 0; j < C; j++) {
					System.out.print((map[a][j]));
				}
				System.out.println();
			}

			if (list.size() != 0) {
				int position_x = 0;	// 가장 먼저 공백이 아닌 곳에서 만나는 위치
				for (Pair p : list) {
					int temp = p.x - 1;
					
					while (temp > 1) {
						if (map[temp][p.y] == 'x') {
							position_x = Math.max(position_x, temp);
							break;
						}
						temp--;
					}
				}
				System.out.println(position_x);
				
				for(Pair p : list) {
					System.out.println("x : " + p.x + " y : " + p.y);

					map[p.x][p.y] = '.';
					map[p.x-position_x+1][p.y] = 'x';
				}
			}
		}
		
		
		for(int i = R; i > 0; i-- ) {
			for(int j = 0; j < C; j++) {
				bw.write(map[i][j]);
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}

	static int change(int i, int height) {
		i = i % 2;

		if (i == 0) { // 왼쪽에서 시작
			for (int k = 0; k < C; k++) {
				if (map[height][k] == 'x') {
					map[height][k] = '.';
					return k;
				}
			}

		} else { // 오른쪽에서 시작
			for (int k = C - 1; k >= 0; k--) {
				if (map[height][k] == 'x') {
					map[height][k] = '.';
					return k;
				}
			}
		}

		return -1;
	}

	static ArrayList<Pair> check(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		boolean check = false;
		boolean[][] visited = new boolean[R + 1][C];

		ArrayList<Pair> list = new ArrayList<>();

		while (!q.isEmpty() && !check) {
			Pair now = q.poll();
			list.add(now);
			visited[now.x][now.y] = true;

			for (int i = 0; i < 4; i++) {
				int next_x = now.x + move[i][0];
				int next_y = now.x + move[i][1];

				if (next_x > 0 && next_x < R + 1 && next_y >= 0 && next_y < C) {
					if (map[next_x][next_y] == 'x') {
						if (next_x == 1) { // 바닥에 도착할 경우 연결되어있으므로 패스!
							check = true;
							
						}
						if (!visited[next_x][next_y]) {
							q.add(new Pair(next_x, next_y));
						}
					}
				}
			}
		}
		return list;
	}

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
