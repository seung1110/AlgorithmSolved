package algorithm;

import java.util.*;

public class No1012 {

	static int t;
	static int m;
	static int n;
	static int k;
	static int[][] graph = new int[50][50];
	
	static boolean dfs(int x , int y) {
		if(x < 0|| x >= m || y < 0 || y >= n) {
			return false;
		}
		
		if(graph[x][y] == 1) {
			graph[x][y] = 0;
			dfs(x-1,y);
			dfs(x+1,y);
			dfs(x,y-1);
			dfs(x,y+1);
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			m = sc.nextInt();
			n = sc.nextInt();
			k = sc.nextInt();
			
			for(int j = 0; j < k; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				graph[x][y] = 1;
			}
			
			int result = 0;
			
			for(int a = 0; a < m; a++) {
				for(int b = 0; b < n ; b++) {
					if(dfs(a,b)) {
						result += 1;
					}
				}
			}
			System.out.println(result);
		}

	}

}
