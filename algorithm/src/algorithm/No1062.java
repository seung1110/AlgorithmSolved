package algorithm;

import java.util.Scanner;

public class No1062 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		String[] list = new String[n];
		sc.nextLine();
		

		for (int i = 0; i < n; i++) {
			list[i] = sc.nextLine();
			list[i] = list[i].replaceAll("(a|n|t|c|i)", "");
		}
		
		
		if (k < 5) {
			System.out.println(0);
		}else {
			
		}

	}

}
