package algorithm;

import java.util.Scanner;
// 부분합 활용!
public class No3020_sol {

	static int[] seok, jong;
	static int N,H;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		H = sc.nextInt();
		
		//구간 별 누적합 구하기 위한 배열
		seok = new int[H]; 
		jong = new int[H];
		
		for(int i = 0; i < N/2; i++) {
			int n_seok = sc.nextInt();
			seok[n_seok]--;
			seok[0]++;

			int n_jong = sc.nextInt();
			jong[n_jong]--;
			jong[0]++;
		}
		
		for(int i = 1; i < seok.length; i++) {	// 누적합 구하기
			seok[i] += seok[i-1];
			jong[i] += jong[i-1];
		}
		
		
		//seok와 jong 배열에 구간별 장애물 개수가 생성
		
		int min_cnt = N*2;
		
		for(int i = 0; i < H; i++) {	// 최소로 장애물을 부수는 경우 확인
			int sum = seok[i] + jong[H - i - 1];
			if(min_cnt > sum) {
				min_cnt = sum;
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < H; i++) {	// 최소로 장애물을 부수는 구간 수 확인
			int sum = seok[i] + jong[H - i - 1];
			if(min_cnt == sum) {
				cnt++;
			}
		}
		
		System.out.println(min_cnt + " " + cnt);
		
		
	}

}
