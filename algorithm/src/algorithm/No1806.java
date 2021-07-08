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

		while (start < N && end <= N && start <= end) {	// ������ ���� ���� �� sum >= M�ε� ����Ǵ� ��� ���� ���� end <= N �߰�
			while (sum < M && end < N) { // �κ����� M���� ���� ��� ��� �߰�
				sum += arr[end++];
			}

			if (sum >= M && min_len > end - start) { // sum >= m�̰� �ּ� �Ÿ����� ���� ���
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
