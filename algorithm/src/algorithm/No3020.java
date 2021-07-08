package algorithm;

import java.util.Scanner;
// �ð��ʰ� Ǯ��
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
	
	static boolean seok_check(int k, int x) { // x�������� ���ư��� k��° ������ ��������
		return seok[k] >= x;
	}
	
	static boolean jong_check(int k, int x) {
		return jong[k] >= H - x + 1;
	}
	
	static int fly(int x) {
		int res = 0;
		for(int i = 0; i < seok.length;i++) {
			if(seok_check(i, x)) {  // ���� x�� ���� �� �ν����� ������ ��
				res++;
			}
			if(jong_check(i, x)) { // ���� x�� ���� �� �ν����� �������� ��
				res++;
			}
		}
		
		
		
		return res;
	}

}
