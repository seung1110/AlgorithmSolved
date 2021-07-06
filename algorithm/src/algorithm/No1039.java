package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1039 {

	public static void main(String[] args) {
		// 예외가 되는것 먼저 처리;
		// 1000000 => 그대로 답
		// 1~9 까지 -1
		// 10,20,30... -1
		// 1000000 이하의 수 => 6자리수   6C2=15 => 최대 15^10개?
		// 결국 최대 6개의 자리수에서 순서쌍을 구하는 경우 6! => 720
		
		// 숫자 교환 로직, 교환해서 단계별로 탐색하는 로직

		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		Queue<Integer> q = new LinkedList<>();
		if (n >= 100 && n % Math.pow(10, str[0].length()-1) == 0) { // 100,200,300~1000
			System.out.println(n);
		} else if (n < 100 && n % 10 == 0) {// 10,20,30,40
			System.out.println(-1);
		} else if (n < 10) {
			System.out.println(-1);
		} else {
			q.add(n);
			// 123456
			for (int i = 0; i < k; i++) {
				int size = q.size();
				for (int j = 0; j < size; j++) {
					int num = q.poll();
					for (int a = 0; a < str[0].length() - 1; a++) {
						for (int b = a+1; b < str[0].length(); b++) {
							int swap_num = conv(num, a, b);
							if (!q.contains(swap_num) && swap_num != 0) {
								q.add(swap_num);
							}
						}
					}
				}
			}
			int max = 0;
			while(!q.isEmpty()) {
				int temp = q.poll();
				if(max < temp) {
					max = temp;
				}
			}
			System.out.println(max);
		}
	}

	public static int conv(int num, int l, int r) {
		// l,r 체크
		char[] c = String.valueOf(num).toCharArray();
		char tmp = c[l];
		c[l] = c[r];
		c[r] = tmp;
		// 앞자리 0인지 체크
		if(c[0] == '0') {
			return 0;
		}

		return Integer.parseInt(String.valueOf(c));
	}

}
