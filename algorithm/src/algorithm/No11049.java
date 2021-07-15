package algorithm;

import java.util.*;
import java.io.*;

public class No11049 {

	static int N;
	static Pair[] p;
	static int[] val;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		p = new Pair[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			p[i] = new Pair(x,y);
		}
		
		if(N == 1) {
			System.out.println(p[0].x * p[0].y);
			return;
		}
		if(N == 2) {
			System.out.println(cal(p[0],p[1]));
			return;
		}
		
		System.out.println(rec(0,N));
		
		
	}
	
	static int rec(int l, int r) {
		int sum = 0;
		
		return sum;
	}
	
	static int min(int a, int b) {
		return a > b ? b : a;
	}
	


	static int cal(Pair p1, Pair p2) {
		return p1.x*p1.y*p2.y;
	}


	static class Pair{
		int x,y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public boolean check(Pair p) {
			return this.y == p.x;
		}
	}
}
