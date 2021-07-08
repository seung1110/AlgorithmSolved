package algorithm;

import java.util.Scanner;

public class No1735 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a_c = sc.nextInt();
		int a_m = sc.nextInt();
		int	b_c = sc.nextInt();
		int b_m = sc.nextInt();
		int answer_c = a_m*b_c + b_m * a_c;
		int answer_m = a_m * b_m;
		int gcd = gcd(answer_c,answer_m);
		System.out.println((answer_c/gcd) +" " + (answer_m/gcd));
		
	}
	
	static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}else {
			return gcd(b, a%b);
		}
	}

}
