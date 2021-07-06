package algorithm;

import java.util.Scanner;

public class No9663 {
	
	static int N;
	static int[][] chess = new int[14][14];
	static int answer = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i = 0; i < 14; i++) {   // 체스판 -1로 초기화
			for(int j = 0; j < 14; j++) {
				chess[i][j] = -1;
			}
		}
		
		rec(0);
		System.out.println(answer);
		
	}
	
	static void rec(int line) {
		if(line == N) { // N까지 도달했을 때 
			answer++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(chess[line][i] != -1) { // 해당 위치에 놓지 못할 경우
				continue;
			}
			chess[line][i] = line; 
			// 아래 못놓게 처리
			for(int j = line+1; j < N; j++) {
				if(chess[j][i] == -1) {
					chess[j][i] = line;
				}
			}
			// 우측 아래쪽 대각선
			int x = line;
			int y = i ;
			while(x < N && y < N) {
				if(chess[x][y] == -1) {
					chess[x][y] = line;
				}
				x++;
				y++;
			}
			x = line;
			y = i;
			
			while(x < N && 0 <= y) {
				if(chess[x][y] == -1) {
					chess[x][y] = line;
				}
				x++;
				y--;
			}
			
			rec(line+1);
			
			// 못놓게 처리한 곳 초기화
			for(int j = line+1; j < N; j++) {
				if(chess[j][i] == line) {
					chess[j][i] = -1;
				}
			}
			
			x = line;
			y = i;
			while(x < N && y < N) {
				if(chess[x][y] == line)
					chess[x][y] = -1;
				x++;
				y++;
			}
			x = line;
			y = i;
			
			while(x < N && 0 <= y) {
				if(chess[x][y] == line)
					chess[x][y] = -1;
				x++;
				y--;
			}
		}
	}

}
