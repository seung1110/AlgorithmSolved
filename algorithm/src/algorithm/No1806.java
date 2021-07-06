package algorithm;

import java.util.*;
import java.io.*;

public class No1806 {

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int sum = arr[0];
		int min_len = 1000000;
		int start = 0, end = 0;
		
		while (true) {
			if(sum < M && end+1 < N) {
				sum += arr[++end];
			}else if (sum >= M) {
				
			}
		}
		
		
		
		
//		if (min_len > M) {
//			System.out.println(0);
//		} else {
//			System.out.println(min_len);
//		}

	}

}
