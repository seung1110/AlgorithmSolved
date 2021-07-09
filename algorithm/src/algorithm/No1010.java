package algorithm;

import java.util.*;
import java.io.*;

public class No1010 {

	static int T;
	static boolean[] check = new boolean[31];
	static int answer, X, Y;
	static BufferedWriter bw;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			if (X == Y) {
				bw.write("1");
				bw.write("\n");
				continue;
			}
			fun(0,0);
			bw.write(answer + "");
			bw.write("\n");

		}

		bw.flush();
		bw.close();
	}

	// xCy 값 구하는 함수

	static void fun(int k, int start) { // k는 선택한 개수

		if (k == X) {
			answer++;
			return;
		}

		for (int i = start; i <= Y - X + k; i++) {
			if (check[i])
				continue;
			
			check[i] = true;
			fun(k + 1, i+1);
			check[i] = false;
		}

	}

}
