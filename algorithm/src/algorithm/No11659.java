package algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class No11659 {

	static int N,M;
	static long[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int size = 1;
		int n = N;
		while(n >= 1) {
			n /= 2;
			size *= 2;
		}
		size *= 2;
		arr = new long[size];
		
		st = new StringTokenizer(br.readLine());
		for(int i = arr.length/2; i < arr.length/2 + N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		init(arr.length/2,arr.length-1);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			bw.write(sum(x,y)+"\n");

		}
		bw.flush();
		bw.close();
	}
	
	static void init(int start, int end) {
		if(start == end) {
			return;
		}
		
		int s = start;
		while(s <= end) {
			arr[s/2] = arr[s]+ arr[s+1];
			s+=2;
		}
		init(start/2,end/2);
	}

	static long sum(int l, int r) {
		l += arr.length/2 - 1;
		r += arr.length/2 - 1;
		long sum = 0;
		
		while(l <= r) {
			if(l%2 == 1) {
				sum += arr[l];
				l++;
			}
			if(r%2 == 0) {
				sum += arr[r];
				r--;
			}
			
			l /= 2;
			r /= 2;
		}
		return sum;
	}
}
