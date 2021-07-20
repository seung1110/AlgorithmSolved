package algorithm;

import java.io.*;
import java.util.*;

public class No1110 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		String temp = String.valueOf(N);
		int answer = 0;
		do {

			int x, y;
			if (N < 10) {
				x = 0;
				y = N;
			} else {
				String str = String.valueOf(N);
				x = str.charAt(0) - '0';
				y = str.charAt(1) - '0';
			}

			if (x + y >= 10) {
				N = (y * 10) + (x + y) % 10;
			} else {
				N = y * 10 + (x + y);
			}
			answer++;
		} while (!temp.equals(String.valueOf(N)));

		System.out.println(answer);
	}

}
