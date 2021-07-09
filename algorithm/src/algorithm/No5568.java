package algorithm;

import java.io.*;
import java.util.*;

/*
 *  No15663과 유사
*/
public class No5568 {

	static int N,K,cnt;		// N은 최대 10 K는 최대 4    10개 중 4개 뽑는 경우의 수(10C4)
	static int[] nums;
	static boolean[] used;
	static HashSet<Integer> set;
	static int[] answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(nums);
		set = new HashSet<Integer>();	
		answer = new int[K];
		used = new boolean[N];
		rec(0);
		
		System.out.println(cnt);
	}
	
	static void rec(int k) {
		if(k == K) {
			String str = "";
			for(int i = 0; i < k; i++) {
				str += answer[i];
			}
			int temp = Integer.parseInt(str);
			if(!set.contains(temp)) {
				set.add(temp);
				cnt++;
			}
			return;
		}
		
		int prev = 0;
		
		for(int i = 0; i < N; i++) {
			if(used[i])
				continue;
			
			if(prev != nums[i]) {
				answer[k] = nums[i];
				used[i] = true;
				rec(k+1);
				used[i] = false;
			}
		}

	}

}
