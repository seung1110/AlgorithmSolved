package algorithm;

import java.util.*;
import java.io.*;

public class No1010 {

	static int T;
	static int answer, X, Y;
	static BufferedWriter bw;
	static int[][] cache = new int[30][30];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			fun(X,Y);
			bw.write(answer + "");
			bw.write("\n");

		}

		bw.flush();
		bw.close();
	}

	// xCy 값 구하는 함수

	static int fun(int x, int y) { 
		if(x == y) {
			return 1;
		}
		if(x < 0 || x >= X || y < 0 || y >= Y )
			return 0;

		if(cache[x][y] != 0)	// 이미 값이 있는 경우
			return cache[x][y];
		
		
		
		
		
		return cache[x][y];
	}

}
