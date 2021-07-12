package algorithm;

import java.util.*;
import java.io.*;
// 다시 풀기
public class No1717 {

	static int N,M;
	static int[] mySet;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken())+1;
		M = Integer.parseInt(st.nextToken());

		mySet = new int[N];
		for(int i = 1; i < N; i++) {
			mySet[i] = i;
		}

		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int com = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(com == 0) {
				if(a == b)
					continue;
				int x = find(a);
				int y = find(b);

				if(x != y) {
					if(x > y)
						mySet[y] = x;
					else
						mySet[x] = y;
				}
			}else {
				if(a == b) {
					bw.write("YES");
				}else {
					if(find(a) == find(b))
						bw.write("YES");
					else
						bw.write("NO");
				}
				bw.write("\n");
			}
				
		}
		
		bw.flush();
		bw.close();
	}

	static int find(int x) {
		if(mySet[x] == x)
			return x;			
		return find(mySet[x]);
	}

}
