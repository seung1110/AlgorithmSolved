package algorithm;

import java.util.Scanner;
import java.util.StringTokenizer;

public class No1072 {

	static long X;
	static long Y;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());

		X = (long) Integer.parseInt(st.nextToken());
		Y = (long) Integer.parseInt(st.nextToken());

		long z = (Y * 100 / X);
		
		if(z == 100 ||z == 99) {  // 승률 99퍼에서 100이되는건 불가능! 100퍼에서 101퍼도 불가능
			System.out.println(-1);
			return;
		}
		// 시간 초과
//		for (int i = 1;; i++) {
//			long nextZ = ((Y + i) * 100) / (X + i);
//			if (z != nextZ) {
//				System.out.println(i);
//				break;
//			}
//		}
//		

		

		//이분탐색 활용   98퍼에서 99퍼로 올라가는게 제일 많은 횟수를 필요
		long upper = X;
		long lower = 0L;
		long mid;
		long answer = 1000000001L;
		
		while(lower <= upper) {
			mid = (upper+lower)/2;
			long nextZ = (Y+mid)*100/(X+mid);
			if(z < nextZ) {
				if(answer > mid) {
					answer = mid;
				}
				upper = mid -1;
				
			}else {
				lower = mid + 1;
			}
		}
		System.out.println(answer);

	}

}
