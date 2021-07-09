package algorithm;

import java.util.Scanner;

public class No1256 {

	static int N, M, K, len;
	static int cache[][];
	static final int INF = 1000000000;	// K�� �ִ밪�� 10��

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		len = N + M;
		cache = new int[N + 1][M + 1];
		
		if(get_az(N, M) < K) {
			System.out.println(-1);
			return ;
		}
		

		// a = N��, z = M��
		// ���ڿ��� ���̴� N + M
		char[] answer = new char[N + M];
		int cnt_a = N, cnt_z = M;
		
		for (int i = 0; i < N + M; i++) {
			if (cnt_a > 0) {
				// i��° ���ڿ��� a���
				int temp = get_az(cnt_a - 1, cnt_z);
				if (temp < K) { // i��° ���ڿ��� i�� �ƴ�
					answer[i] = 'z';
					K -= temp;
					cnt_z--;
				} else {
					answer[i] = 'a';
					cnt_a--;
				}
			}else {
				answer[i]='z';
				cnt_z--;
			}
		}
		
		System.out.println(String.valueOf(answer));
		
	}

	static int get_az(int a_c, int z_c) { // ����� �� ���ϱ�, ���� �� �Ѿ�� overflow

		if (a_c == 0 || z_c == 0) { // a_c * z_c == 0���� ���� ����
			return 1;
		}

		if (cache[a_c][z_c] != 0) {
			return cache[a_c][z_c];
		}
		cache[a_c][z_c] = get_az(a_c - 1, z_c) + get_az(a_c, z_c - 1);
		
		if(cache[a_c][z_c] >= INF) {
			cache[a_c][z_c] = INF;
		}
		return cache[a_c][z_c];
	}

}
