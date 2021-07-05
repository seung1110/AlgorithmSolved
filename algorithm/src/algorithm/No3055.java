package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No3055 {
	static int r, c;
	static char[][] map = new char[50][50];
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Pair start;
	static Pair dest;
	static List<Pair> water = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < r; i++) {
			String str = sc.nextLine();
			map[i] = str.toCharArray();
		}

		// 두더지 위치 확인
		// 물 위치 확인
		// 비버집 위치 확인

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'S') {
					start = new Pair(i, j);
				} else if (map[i][j] == 'D') {
					dest = new Pair(i, j);
				} else if (map[i][j] == '*') {
					water.add(new Pair(i, j));
				}
			}
		}

		int[][] water_vt = new int[50][50];
		int[][] ddg_vt = new int[50][50];

		Queue<Pair> water_q = new LinkedList<>();
		Queue<Pair> ddg_q = new LinkedList<>();

		for (int i = 0; i < water.size(); i++) {
			Pair now = water.get(i);
			water_vt[now.x][now.y] = 1;
			water_q.add(now);
		}

		ddg_vt[start.x][start.y] = 1;
		ddg_q.add(start);
		while (!ddg_q.isEmpty()) {
			// 물 이동
			// queue에서 하나 꺼내고 상/하/좌/우로 이동
			// D, X 제외
			int water_q_size = water_q.size();
			for (int i = 0; i < water_q_size; i++) {
				Pair now = water_q.poll();
				int x = now.x;
				int y = now.y;
				for (int m = 0; m < 4; m++) {
					int nextX = x + move[m][0];
					int nextY = y + move[m][1];
					if (check(nextX, nextY)) {
						if (map[nextX][nextY] != 'D' && map[nextX][nextY] != 'X') {
							if (water_vt[nextX][nextY] == 0) {
								water_q.add(new Pair(nextX, nextY));
								water_vt[nextX][nextY] = water_vt[x][y] + 1;
							}
						}
					}
				}

			}

			// 두더지 이동
			// 물 이동과 마찬가지
			// *, X 제외
			int ddg_q_size = ddg_q.size();
			for (int i = 0; i < ddg_q_size; i++) {
				Pair now = ddg_q.poll();
				int x = now.x;
				int y = now.y;
				for (int m = 0; m < 4; m++) {
					int nextX = x + move[m][0];
					int nextY = y + move[m][1];
					if (check(nextX, nextY)) {
						if (map[nextX][nextY] != 'X' && water_vt[nextX][nextY] == 0 && ddg_vt[nextX][nextY] == 0) {
							if(map[nextX][nextY] == 'D') {
								ddg_vt[nextX][nextY] = ddg_vt[x][y] + 1;
								break;
							}
							ddg_q.add(new Pair(nextX, nextY));
							ddg_vt[nextX][nextY] = ddg_vt[x][y] + 1;
						}
					}
				}

			}

		}

		if (ddg_vt[dest.x][dest.y] > 0) {
			System.out.println(ddg_vt[dest.x][dest.y]-1);
		} else {
			System.out.println("KAKTUS");
		}

		// 답 출력

//		for(int i = 0; i < r; i++) {
//			for(int j = 0; j < c; j++) {
//				System.out.print(ddg_vt[i][j]);
//			}
//			System.out.println();
//		}

	}
	
	static public boolean check(int p1,int p2) {
		if(p1 >= 0 && p1 < r && p2 >= 0 && p2 < c) {
			return true;
		}
		return false;
	}

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int first() {
			return x;
		}

		public int second() {
			return y;
		}
	}

}
