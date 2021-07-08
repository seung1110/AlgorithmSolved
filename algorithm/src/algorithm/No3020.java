package algorithm;

import java.util.Scanner;
// 시간초과 풀이
public class No3020 {

	static int[] seok, jong;
	static int N,H;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		H = sc.nextInt();
		
		seok = new int[N/2];
		jong = new int[N/2];
		
		for(int i = 0; i < N/2; i++) {
			seok[i] = sc.nextInt();
			jong[i] = sc.nextInt();
		}
		
		int cnt = N*2;
		
		for(int i = 0; i < H; i++) {
			if(cnt > fly(i))
				cnt = fly(i);
		}
		
		int min_i = 0;
		
		for(int i = 0; i < H; i++) {
			if(cnt == fly(i)) {
				min_i++;
			}
		}
		
		System.out.println(cnt + " " + min_i);
		
	}
	
	static boolean seok_check(int k, int x) { // x구간으로 날아갈때 k번째 석순을 만나는지
		return seok[k] >= x;
	}
	
	static boolean jong_check(int k, int x) {
		return jong[k] >= H - x + 1;
	}
	
	static int fly(int x) {
		int res = 0;
		for(int i = 0; i < seok.length;i++) {
			if(seok_check(i, x)) {  // 구간 x로 지날 때 부숴지는 석순의 수
				res++;
			}
			if(jong_check(i, x)) { // 구간 x로 지날 때 부숴지는 종유석의 수
				res++;
			}
		}
		
		
		
		return res;
	}

}
