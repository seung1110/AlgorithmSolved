package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class No7562 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		// 나이트가 이동할 수 있는 경로 8개
		int[][] move = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			boolean[][] visited = new boolean[n][n];
			
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			visited[startX][startY] = true;
			
			st = new StringTokenizer(br.readLine());
			int desX = Integer.parseInt(st.nextToken());
			int desY = Integer.parseInt(st.nextToken());
			
			
			if(startX == desX && startY == desY) {
				bw.write("0\n");
				continue;
			}
			
			Deque<Pair> q = new ArrayDeque<>();
			q.add(new Pair(startX, startY,0));
			boolean check = false;
			while(!q.isEmpty()) {
				Pair now = q.poll();
				for(int k = 0; k < 8; k++) {
					int nextX = now.x + move[k][0];
					int nextY = now.y + move[k][1];
					if(nextX == desX && nextY == desY) {
						bw.write((now.depth+1)+"\n");
						check = true;
						break;
					}
					if(nextX < n && 0 <= nextX && nextY < n && 0 <= nextY&& !visited[nextX][nextY]) {
						q.add(new Pair(nextX,nextY,now.depth+1));
						visited[nextX][nextY] = true;
					}
				}
				
				if(check) {
					break;
				}
			}
		}
		
		bw.flush();
		bw.close();
	}

	static class Pair {
		int x, y, depth;

		public Pair(int x, int y,int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
}
