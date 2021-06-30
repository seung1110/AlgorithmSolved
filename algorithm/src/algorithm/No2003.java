package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2003 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(st.nextToken());
			int m = Integer.valueOf(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.valueOf(st.nextToken());
			}
			
			for(int i = 0; i < n; i++) {
				int sum = 0;
				for(int j = i; j < n; j++){
					if(arr[j] > m) {
						break;
					}
					sum += arr[j];
					if(sum > m) {
						break;
					}else if(sum == m) {
						answer++;
						break;
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(answer);

	}

}
