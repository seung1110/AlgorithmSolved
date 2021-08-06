package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class No1339_un {
	static int max_length;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int answer = 0;
		sc.nextLine();
		
		String[] str = new String[N];
		for(int i = 0; i < N; i++) {
			str[i] = sc.nextLine();
		}
	
		
		
		Map<Integer, String> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			char[] temp = str[i].toCharArray();
			int len = temp.length-1;
			if(max_length < len) {
				max_length = len;
			}
			
			for(int j = len; j >= 0; j--) {
				int n = len - j;
				if(map.containsKey((int) Math.pow(10, n))) {
					map.put((int) Math.pow(10, n), map.get((int) Math.pow(10, n)) + temp[j]);
				}else {
					map.put((int) Math.pow(10, n) , temp[j]+"");
				}
			}
		}

		int[] num = new int[128];
		int count = 9;
		for(int i = max_length -1 ; i >= -1;i--) {
			String s = map.get((int)Math.pow(10, i+1));
			if(s == null || s.equals("")) {
				continue;
			}
			
			if(i == max_length-1) {
				char[] check = new char[128];
				for(int k = 0; k < s.length(); k++) {
					check[s.charAt(k)]++;
				}
				int max = 0;
				int idx = 0;
				for(int k = 0; k < s.length(); k++) {
					if(check[s.charAt(i)] > max) {
						max = check[s.charAt(i)];
						idx = k;
					}
				}
				
				
			}
			
			
			for(int j = 0; j < s.length(); j++) {
				if(num[s.charAt(j)] == 0) {
					num[s.charAt(j)] = count--;
					answer += num[s.charAt(j)] * Math.pow(10, i+1);
				}else {
					answer += num[s.charAt(j)] *(int) Math.pow(10, i+1);

				}
			}
		}
		
		
		System.out.println(answer);
		
	}

}
