package algorithm;

import java.io.*;

public class No2579 {
	static int N;
	static int[][] score;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// ���� ����� ��� ���� ��, ������ ����� ��� ���� ��
		score = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			score[i][0] = Integer.parseInt(br.readLine());
		}

		if(N == 1) { // N�� 1�� ��� �ٷ� ����
			System.out.println(score[0][0]);
			return;
		}
		
		score[0][1] = score[0][0];	// 1���� ���� ��, 0��°�� 2���� ���� ��찡 ����
		score[1][1] = score[0][1] +score[1][0];	// 1��° ��ܿ� 0�� ����� ��ġ�� �� ���
		score[1][2] = score[1][0];  // �ƴ� ���
		int check = 2;
		while(check < N) { // n��° ����� n-2������ ���ų� n-1������ ���ų� �� ���ϳ�
			
			// n-1���� �� ��� n-1�� ������ �ѹ� �Ѿ�� ��츦 ���ϸ� 3�� �����̹Ƿ� fail
			// n-1���� �� ���� 2 ����� �Ѿ�� ���� ����
			score[check][1] = score[check-1][2] + score[check][0];
			
			// �� ����� �Ѿ �� ��� - ������ �� �� �Ѿ �� ��� �� �� �Ѿ �� ��� ������� ū ���� ���Ѵ�
			int temp = score[check-2][1] > score[check-2][2] ? score[check-2][1] : score[check-2][2];
			score[check][2] = temp + score[check][0];
			check++;
		}
		System.out.println(score[N-1][1] > score[N-1][2]? score[N-1][1] : score[N-1][2]);

	}

}
