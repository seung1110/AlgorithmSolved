package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class No1062 {

	static int answer;
	static int max_count;
	static HashMap<Character,Integer> map;
	static char[] c_set;
	static int count;
	static String[] list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		list = new String[n];
		sc.nextLine();
		

		for (int i = 0; i < n; i++) {
			list[i] = sc.nextLine();
			list[i] = list[i].replaceAll("(a|n|t|c|i)", "");
			if(list[i].equals("")) {
				answer++;
			}
		}
		
		if (k < 5) {
			System.out.println(0);
			return ;
		}
		count = k - 5;
		if(count == 0) {
			System.out.println(answer);
			return;
		}
		
		System.out.println(Arrays.toString(list));

	}
	
	

}
