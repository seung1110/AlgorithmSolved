package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1039 {

	public static void main(String[] args) {
		// ���ܰ� �Ǵ°� ���� ö;
		// 1000000 => �״�� ��
		// 1~9 ���� -1
		// 10,20,30... -1

		// ���� ��ȯ ����, ��ȯ�ؼ� �ܰ躰�� Ž���ϴ� ����

		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);

		if (n / 100 >= 1 && n % 10 == 0) { // 100,200,300~
			System.out.println(n);
		} else if (n < 100 && n % 10 == 0) {// 10,20,30,40
			System.out.println(-1);
		} else if (n < 10) {
			System.out.println(-1);
		} else {
			Queue<Integer> q = new LinkedList<>();
			q.add(n);

			for (int i = 0; i < k; i++) {
				int size = q.size();
				for (int j = 0; j < size; j++) {
					int num = q.poll();
					for (int a = 0; a < str[0].length() - 2; a++) {
						for (int b = 1; b < str[0].length() - 1; b++) {
							int swap_num = conv(n, a, b);
							if (!q.contains(swap_num)) {
								q.add(swap_num);
							}
						}
					}
				}
			}
		}

	}

	public static int conv(int num, int l, int r) {
		// l,r üũ
		char[] c = String.valueOf(num).toCharArray();
		char tmp = c[l];
		c[l] = c[r];
		c[r] = tmp;
		// ���ڸ� 0���� üũ

		return Integer.parseInt(c.toString());
	}

}
