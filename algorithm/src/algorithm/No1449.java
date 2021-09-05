package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1449 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); 
		int l = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int cnt = 1;
		int before = -1;
		for(int i = 1; i < n; i++) {
			if(before == -1) {
				if(arr[i]-arr[i-1]+1 <= l) {
					before = arr[i-1];
				}else {
					cnt++;
				}
			}else {
				if(arr[i]-before+1 > l) {
					before = -1;
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}

}
