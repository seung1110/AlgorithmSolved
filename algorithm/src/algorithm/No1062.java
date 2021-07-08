package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class No1062 {

	static int answer;
	static int max_count;
	static char[] c_set;
	static int count;
	static ArrayList<char[]> list;
	static int N,K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		list = new ArrayList<>();
		sc.nextLine();
		

		for (int i = 0; i < N; i++) {
			String temp = sc.nextLine();
			temp = temp.replaceAll("(a|n|t|c|i)", "");
			if(temp.equals("")) {
				answer++;
			}else {
				list.add(temp.toCharArray());
			}
		}
		
		char[] c_set = new char['z'-5];
		int count = 0;
		for(int i = 'a'; i <= 'z'; i++) {
			if(i != 'a'&& i != 'n'&& i != 't' && i != 'c' && i !='i') {
				c_set[count++] = (char)i;
			}
		}
		

		
		if (K < 5) {
			System.out.println(0);
			return ;
		}
		count = K - 5;
		if(count == 0) {
			System.out.println(answer);
			return;
		}

		


	}
	
	static boolean check(String str, char[] c) {
		for(int i = 0; i < c.length; i++) {
			str = str.replaceAll(c[i]+"","");
		}
		
		if(str == ""){
			return true;
		}
		
		return false;
	}


}
