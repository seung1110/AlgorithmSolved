package algorithm;

import java.io.*;
import java.util.*;

public class No1932 {
	static int N;
	static int[] tree;
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int size = 0;
		for(int i = 1; i <= N; i++) {
			size += i;
		}
		tree = new int[size];
		
		int idx = 0;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < i; j++ ) {
				tree[idx++] = Integer.parseInt(st.nextToken());
			}
		}
		
		int start = size - N;
		int end = size - 1;
		int depth = N-1;
		rec(start,end,depth);
		
		System.out.println(tree[0]);
	}
	
	static void rec(int start, int end, int depth) {
		if(start == end) {
			return;
		}
		int s = start;
		while(s < end) {
			tree[s-depth] += tree[s] > tree[s+1] ? tree[s] : tree[s+1];
			s++;
		}
		rec(start-depth,start-1,depth-1);
	}

}
