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
		
		if(z == 100 ||z == 99) {  // �·� 99�ۿ��� 100�̵Ǵ°� �Ұ���! 100�ۿ��� 101�۵� �Ұ���
			System.out.println(-1);
			return;
		}
		// �ð� �ʰ�
//		for (int i = 1;; i++) {
//			long nextZ = ((Y + i) * 100) / (X + i);
//			if (z != nextZ) {
//				System.out.println(i);
//				break;
//			}
//		}
//		

		

		//�̺�Ž�� Ȱ��   98�ۿ��� 99�۷� �ö󰡴°� ���� ���� Ƚ���� �ʿ�
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
