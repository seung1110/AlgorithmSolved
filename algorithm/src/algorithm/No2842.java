package algorithm;

import java.io.*;
import java.util.*;

/*
 문제 해결 전략
 집을 전부 방문하는 경우의 수를 전부 구해 비교?
 가장 낮은 곳과 높은 곳 임의로 설정 후 이분탐색?
 
*/

public class No2842 {
	static int N;
	static int K;
	static int post_x, post_y;
	static char[][] map;
	static int[][] map_h;
	static int[][] move = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}}; // 시계방향 진행
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		map_h = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());;
			String str = st.nextToken();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'K') {
					K++;
				}else if(map[i][j] == 'P') {
					post_x = i;
					post_y = j;
				}
			}
		}
		
		int[] arr_h = new int[N*N];
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map_h[i][j] = Integer.parseInt(st.nextToken());
				arr_h[cnt++] = map_h[i][j];
			}
		}

		Arrays.sort(arr_h);
		
		// min은 현재 위치보다 클 수 없음?
		
		int answer = arr_h[arr_h.length-1] - arr_h[0];
		
		for(int start = 0, end = 0; start < arr_h.length && end < arr_h.length && start <= end;) {
			if(bfs(arr_h[start],arr_h[end]) == K) {
				int temp = arr_h[end] - arr_h[start];
				if(answer > temp) {
					answer = temp;
				}
				start++;
			}else {
				end++;
			}
			
		}
		System.out.println(answer);
		
	}
	
	// 모든 집 배달 가능?
	static int bfs(int min, int max) {
		if(min > map_h[post_x][post_y] || max < map_h[post_x][post_y]) {
			return 0;
		}
		int cnt = 0;
		boolean[][] vt = new boolean[N][N];
		Queue<Pair> q = new LinkedList<>();
		
		q.add(new Pair(post_x, post_y));
		vt[post_x][post_y] = true;
		
		while(!q.isEmpty() && cnt < K) {
			Pair now = q.poll();
			for(int i = 0; i < 8; i++) {
				int nextX = now.x + move[i][0];
				int nextY = now.y + move[i][1];
				
				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) 
					continue;
				
				if(vt[nextX][nextY])
					continue;
				
				if(map_h[nextX][nextY] < min || map_h[nextX][nextY] > max)
					continue;

				if(map[nextX][nextY] == 'K') {
					cnt++;
				}

				vt[nextX][nextY] = true; // 방문처리
				q.add(new Pair(nextX, nextY));
			}
		}
		return cnt;
	}
	
	static class Pair {
		int x,y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
