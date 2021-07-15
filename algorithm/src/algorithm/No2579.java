package algorithm;

import java.io.*;

public class No2579 {
	static int N;
	static int[][] score;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 이전 계단을 밟고 왔을 때, 이전전 계단을 밟고 왔을 때
		score = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			score[i][0] = Integer.parseInt(br.readLine());
		}

		if(N == 1) { // N이 1일 경우 바로 종료
			System.out.println(score[0][0]);
			return;
		}
		
		score[0][1] = score[0][0];	// 1번에 왔을 때, 0번째는 2번에 오는 경우가 없음
		score[1][1] = score[0][1] +score[1][0];	// 1번째 계단에 0번 계단을 거치고 올 경우
		score[1][2] = score[1][0];  // 아닐 경우
		int check = 2;
		while(check < N) { // n번째 계단은 n-2번에서 오거나 n-1번에서 오거나 둘 중하나
			
			// n-1에서 올 경우 n-1이 이전에 한번 넘어온 경우를 더하면 3번 연속이므로 fail
			// n-1에서 올 경우는 2 계단을 넘어올 때만 가능
			score[check][1] = score[check-1][2] + score[check][0];
			
			// 두 계단을 넘어서 온 경우 - 이전이 한 번 넘어서 온 경우 두 번 넘어서 온 경우 상관없이 큰 값을 더한다
			int temp = score[check-2][1] > score[check-2][2] ? score[check-2][1] : score[check-2][2];
			score[check][2] = temp + score[check][0];
			check++;
		}
		System.out.println(score[N-1][1] > score[N-1][2]? score[N-1][1] : score[N-1][2]);

	}

}
