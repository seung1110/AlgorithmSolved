package algorithm;

import java.io.*;
import java.util.*;

public class No14888 {
	static int min, max, n;
	static char[] temp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		char[] op = new char[n - 1];
		temp = new char[n - 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int idx = Integer.parseInt(st.nextToken());
			for (int j = 0; j < idx; j++) {
				if (i == 0)
					op[cnt++] = '+';
				else if (i == 1)
					op[cnt++] = '-';
				else if (i == 2)
					op[cnt++] = '*';
				else
					op[cnt++] = '/';
			}
		}

		min = Integer.MAX_VALUE;
		max = -1000000001;
		dfs(arr, op, new boolean[n - 1], 0);
		System.out.println(max);
		System.out.println(min);
	}

	static void dfs(int[] arr, char[] op, boolean[] visited, int depth) {
		if (depth == n - 1) {

			min = Math.min(min, cal(arr, temp));
			max = Math.max(max, cal(arr, temp));
			return;
		}

		for (int i = 0; i < n - 1; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[depth] = op[i];
				dfs(arr, op, visited, depth + 1);
				visited[i] = false;
			}
		}

	}

	static int cal(int[] arr, char[] temp) {
		long answer = 0;
		answer = arr[0];
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == '+') {
				answer += arr[i + 1];
			} else if (temp[i] == '-') {
				answer -= arr[i + 1];
			} else if (temp[i] == '/') {
				answer /= arr[i + 1];
			} else {
				answer *= arr[i + 1];
			}
		}

		return (int)answer;
	}
}
