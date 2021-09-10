package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class No18405 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] move = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		int[][] arr = new int[n][n];
		ArrayList<Pair> li[] = new ArrayList[k + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (li[arr[i][j]] == null) {
					li[arr[i][j]] = new ArrayList<>();
				}

				li[arr[i][j]].add(new Pair(i, j, arr[i][j]));
			}
		}

		Deque<Pair> q = new ArrayDeque();

		for (int i = 1; i <= k; i++) {
			ArrayList<Pair> temp = li[i];
			if (temp != null) {
				for (int j = 0; j < temp.size(); j++) {
					q.add(temp.get(j));
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int time = 0;
		while (time < s) {
			int tempSize = q.size();
			while (tempSize > 0) {
				Pair temp = q.pollFirst();
				for (int i = 0; i < 4; i++) {
					int nextX = temp.x + move[i][0];
					int nextY = temp.y + move[i][1];

					if (0 <= nextX && nextX < n && 0 <= nextY && nextY < n && arr[nextX][nextY] == 0) {
						arr[nextX][nextY] = temp.val;
						q.add(new Pair(nextX, nextY, temp.val));
					}

				}
				tempSize--;
			}

			time++;
		}

		System.out.println(arr[x - 1][y - 1]);

	}

	static class Pair {
		int x, y, val;

		public Pair(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}

}
