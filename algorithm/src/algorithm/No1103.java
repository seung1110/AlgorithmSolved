package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1103 {
	
	static int N;
	static int M;
	static int answer;
	static int[][] board;
	static int[][] max_visited;
	static int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		board = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for(int j = 0; j < c.length; j++) {
				if(c[j] == 'H') {
					board[i][j] = 0;
				}else {
					board[i][j] = c[j] - '0';
				}
			}
		}
		
		max_visited = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				max_visited[i][j] = -1;
			}
		}
		
		dfs(0,0,0);
		if(answer > N*M) {
			answer = -1;
		}
		System.out.println(answer);
	}
	
	static void dfs(int x, int y, int cnt) {
		if(answer < cnt) { // 일단 answer 크면 저장
			answer = cnt;
		}
		
		if(cnt > N*M) {  // 가능한 가장 큰 횟수보다 클 경우 종료, 무한 루프 방지
			return;
		}
		if(!(x >= 0 && x < N && y >=0 && y < M)) {  // x,y값의 범위 체크
			return;
		}
			
		int num = board[x][y];
		if(num == 0) {  // 해당 위치가 구멍일 경우 종료
			return ;
		}
		
		if(max_visited[x][y] >= cnt) {  // 해당 위치에 방문한 cnt가 기존의 cnt보다 작으면 종료
			return;						// 현재 위치에서 다른 곳으로 갈 수 있는 경우의 수는 똑같으므로!
		}
		max_visited[x][y] = cnt;
		
		for(int i = 0; i < 4; i++) {
			int newX = x + num*move[i][0];
			int newY = y + num*move[i][1];
			dfs(newX,newY,cnt+1);
		}
	}


}
