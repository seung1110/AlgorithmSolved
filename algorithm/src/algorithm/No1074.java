package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1074 {
	static int n_2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		n_2 = (int)Math.pow(2, n);
		
	}
	static void rec(int x, int y) {
		int cnt = 0;
		if(n_2 < x) {
			if(y < n_2);
		}else {
			cnt += n_2/2 * n_2/2;
			
		}
		
		
	}
}
