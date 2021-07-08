package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class No10610 {

	// 특정 숫자를 섞었을 때 30의 배수일 경우는 3과 10의 배수
	// 3의 배수는 자리수의 합이 3의 배수
	// 10의 배수는 숫자 안에 0이 존재해야함
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int sum = 0;
		int zero_cnt = 0;
		char[] arr = new char[str.length()];
		for(int i = 0; i <str.length(); i++) {
			arr[i] = str.charAt(i);
			sum +=(str.charAt(i) - '0');
			if(str.charAt(i) == '0') {
				zero_cnt++;
			}
		}
		
		if(zero_cnt < 1 || sum % 3 != 0) {
			System.out.println(-1);
			return;
		}
		
		Arrays.sort(arr);
		
		for(int i = arr.length-1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
		
		

	}

}
