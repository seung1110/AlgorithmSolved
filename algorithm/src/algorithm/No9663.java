package algorithm;

import java.util.Scanner;

public class No9663 {
	
	static int N;
	static int[][] chess = new int[14][14];
	static int answer = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i = 0; i < 14; i++) {   // ü���� -1�� �ʱ�ȭ
			for(int j = 0; j < 14; j++) {
				chess[i][j] = -1;
			}
		}
		
		rec(0);
		System.out.println(answer);
		
	}
	
	static void rec(int line) {
		if(line == N) { // N���� �������� �� 
			answer++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(chess[line][i] != -1) { // �ش� ��ġ�� ���� ���� ���
				continue;
			}
			chess[line][i] = line; 
			// �Ʒ� ������ ó��
			for(int j = line+1; j < N; j++) {
				if(chess[j][i] == -1) {
					chess[j][i] = line;
				}
			}
			// ���� �Ʒ��� �밢��
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
			
			// ������ ó���� �� �ʱ�ȭ
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
