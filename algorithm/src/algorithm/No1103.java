package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//¹ÌÇØ°á
public class No1103 {
	
	static int N;
	static int M;
	static int[][] board; 
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
		ArrayList<Pair2> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j] != 0) {
					
				}
			}
		}
		
		

	}

	static class Pair2{
		int x,y;
		Pair2[] able;
		public Pair2(int x,int y, Pair2[] able) {
			this.x = x;
			this.y = y;
			this.able = able;
		}
	}
}
