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

		int sum = 0;
		int min_len = 100001;
		int start = 0, end = 0;

		while (start < N && end <= N && start <= end) {	// 마지막 값을 더한 후 sum >= M인데 종료되는 경우 막기 위해 end <= N 추가
			while (sum < M && end < N) { // 부분합이 M보다 작을 경우 계속 추가
				sum += arr[end++];
			}

			if (sum >= M && min_len > end - start) { // sum >= m이고 최소 거리보다 작을 경우
				min_len = end - start;
			}
			
			sum -= arr[start++];
	
		}

		if (min_len == 100001) {
			System.out.println(0);
		} else {
			System.out.println(min_len);
		}

	}

}
