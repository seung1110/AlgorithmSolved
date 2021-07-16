package algorithm;

import java.util.Scanner;

public class No5582 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		
		int[][] dp = new int[s1.length()][s2.length()];
		int max = 0;
		for(int i = 0; i < s1.length(); i++) {
			for(int j = 0; j < s2.length(); j++) {
				if(i > 0 & j > 0) {	// ���� ó��
					if(s1.charAt(i) == s2.charAt(j)) {	// ���� ���� ��� 
						dp[i][j] = dp[i-1][j-1] +1;	// ������ ���� ���� �� �����Ƿ� ���� �ܾ��� ��ġ ������ i-1 j-1�� ���� �����´�.
						max = Math.max(dp[i][j], max);	// �ִ� ���� ã�� 
					}
				}else {	// ���� ���� ���� �ʿ䰡 �����Ƿ� ���� ��� 1�� ����
					dp[i][j] = s1.charAt(i) == s2.charAt(j) ? 1 : 0;
				}
			}
		}
		System.out.println(max);

	}

}
