package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1039 {

	public static void main(String[] args) {
		// ���ܰ� �Ǵ°� ���� ó��;
		// 1000000 => �״�� ��
		// 1~9 ���� -1
		// 10,20,30... -1
		// 1000000 ������ �� => 6�ڸ���   6C2=15 => �ִ� 15^10��?
		// �ᱹ �ִ� 6���� �ڸ������� �������� ���ϴ� ��� 6! => 720
		
		// ���� ��ȯ ����, ��ȯ�ؼ� �ܰ躰�� Ž���ϴ� ����

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
		// l,r üũ
		char[] c = String.valueOf(num).toCharArray();
		char tmp = c[l];
		c[l] = c[r];
		c[r] = tmp;
		// ���ڸ� 0���� üũ
		if(c[0] == '0') {
			return 0;
		}

		return Integer.parseInt(String.valueOf(c));
	}

}
