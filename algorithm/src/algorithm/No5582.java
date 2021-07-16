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
				if(i > 0 & j > 0) {	// 예외 처리
					if(s1.charAt(i) == s2.charAt(j)) {	// 값이 같을 경우 
						dp[i][j] = dp[i-1][j-1] +1;	// 이전의 값이 같을 수 있으므로 이전 단어의 일치 여부인 i-1 j-1의 값을 가져온다.
						max = Math.max(dp[i][j], max);	// 최대 길이 찾기 
					}
				}else {	// 이전 값과 비교할 필요가 없으므로 같을 경우 1로 변경
					dp[i][j] = s1.charAt(i) == s2.charAt(j) ? 1 : 0;
				}
			}
		}
		System.out.println(max);

	}

}
