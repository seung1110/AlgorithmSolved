package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//ÀÌÁøÅ½»ö
public class No1920_2 {
	
	static int[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		list = new int[n];

		for(int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			binary_search(Integer.parseInt(st.nextToken()));
		}

	}
	
	static void binary_search(int key) {
		int start = 0;
		int end = list.length-1;
		int mid;
	
		while(start <= end) {
			mid = (end+start)/2;

			if(list[mid] == key) {
				System.out.println(1);
				return;
			}else if(list[mid] < key) {
				start = mid + 1;
			}else {
				end = mid -1;
			}
		}
		System.out.println(0);
		
	}

}
