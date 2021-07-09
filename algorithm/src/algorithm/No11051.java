package algorithm;

import java.util.Scanner;

public class No11051 {
	/*
	 * 경우의 조합 1000 C 300
	 * 1000개의 원소를 가진 arr 
	 * 0번 원소 고른다 고르지 않는다 (2개의 경우)
	 * 0번 선택 -> 999개 중 299개 고르면 됨	999 C 299
	 * 0번 미선택 -> 999개 중 300개 고르면 됨 999 C 300
	*/
	
	static int[][] cache = new int[1001][1001];
	
	static int rec(int n, int r) {
		if(r == 0) {
			return 1;
		}
			
		if (n < r) {
			return 0;
		}
		
		if(n < 0 || n > 1000 || r < 0 || r > 1000) {
			return 0;
		}
		
		if(cache[n][r] != -1) {
			return cache[n][r];
		}
		
		int temp = (rec(n-1,r-1)+ rec(n-1,r))%10007;
		cache[n][r] = temp;
		return cache[n][r];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for(int i = 0; i < cache.length; i++) {
			for(int j =0; j <cache[0].length; j++) {
				cache[i][j] = -1;
			}
		}
		System.out.println(rec(N,K));
	}

}
