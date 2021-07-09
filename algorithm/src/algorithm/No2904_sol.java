package algorithm;

import java.util.*;
import java.io.*;

/*
 * 전부 소수로 소인수 분해하고 N만큼의 배수를 가진 소수
 * 
 */

public class No2904_sol {
	static ArrayList<Integer> prime_list;
	static int[] get_index;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if (N == 1) {
			System.out.println(arr[0] + " 0");
			return;
		}
		// 소수 목록 구하기
		prime_list = new ArrayList<>();
		boolean[] check = new boolean[1000000];
		for (int i = 2; i < 1000000; i++) {
			if (check[i])
				continue;
			else {
				prime_list.add(i);
				for (int j = i + i; j < 1000000; j += i) {
					check[j] = true;
				}
			}
		}
		
		// 입력받은 값들 소인수 분해
		int[][] num  = new int[N][prime_list.size()];
		int[]sum = new int[prime_list.size()];
		for(int i = 0; i < N; i++) {
			int temp = arr[i];
			for(int j = 0; j < prime_list.size(); j++) {
				if(temp == 1) {
					break;
				}
				int prime = prime_list.get(j);
				while(temp % prime == 0 && temp > 1) {
					temp /= prime;
					num[i][j]++;
					sum[j]++;
				}
			}
		}
		
		int max = 1;
		for(int i = 0; i < sum.length; i++) {
			if(sum[i] > 0) {
				sum[i] /= N;
				if(sum[i] > 0) {
					max *= Math.pow(prime_list.get(i), sum[i]);
				}
			}
		}
		
		int change = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < sum.length; j++) {
				if(num[i][j] < sum[j]) {
					change += (sum[j] - num[i][j]);
				}
			}
		}
		
		System.out.println(max + " " + change);

	}

}
