package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class No1759 {

	static int L;
	static int C;
	static char[] answer;
	static char[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		
		sc.nextLine(); // enter 제거
		
		arr = (sc.nextLine().replaceAll(" ", "")).toCharArray();  // 입력 값 공백 제거 후 배열로 변환
		Arrays.sort(arr); // 순서대로 하기 위해 먼저 정렬
		answer = new char[L];
		rec(0,0);
		
	}

	static void rec(int where, int start) { // 재귀 활용
		if(where == L) { //  원하는 글자 개수만큼 진행했을 경우 종료
			if(check(answer)) {
				System.out.println(String.valueOf(answer));
			}
			return ;
		}
		
		for(int i = start; i < C; i++) {
			answer[where] = arr[i];
			rec(where+1, i+1);
		}
		
	}
	
	static boolean check(char[] answer) {	// 자음, 모음 조건에 알맞은 단어인지 확인
		int count_a = 0;
		boolean[] is_a = new boolean[128];
		is_a['a'] = true;
		is_a['e'] = true;
		is_a['i'] = true;
		is_a['o'] = true;
		is_a['u'] = true;
		
		for(int i = 0 ; i < answer.length; i++) {
			if(is_a[answer[i]]) {
				count_a++;
			}
		}
		return count_a >=1 && (answer.length-count_a)>=2;
	}
}
