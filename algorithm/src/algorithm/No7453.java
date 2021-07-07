package algorithm;

import java.io.*;
import java.util.*;

public class No7453 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][4];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// a와b, c와 d의 조합을 따로!
		// map 사용시 시간 초과 나옴..
//		HashMap<Integer, Integer> map_ab = new HashMap<>();
//		HashMap<Integer, Integer> map_cd = new HashMap<>();
//		
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				int temp1 = arr[i][0] + arr[j][1];
//				map_ab.put(temp1, map_ab.getOrDefault(temp1, 0)+1);
//				int temp2 = arr[i][2] + arr[j][3];
//				map_cd.put(temp2, map_cd.getOrDefault(temp2, 0)+1);
//			}
//		}
//		
//
//		int answer = 0;
//		for(int val : map_ab.keySet()) {
//			if(map_cd.containsKey(-val)) {
//				answer += map_ab.get(val)*map_cd.get(-val);
//			}
//		}
		int[] arr_ab = new int[n * n];
		int[] arr_cd = new int[n * n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr_ab[count] = arr[i][0] + arr[j][1];
				arr_cd[count] = arr[i][2] + arr[j][3];
				count++;
			}
		}
		
		Arrays.sort(arr_ab);
		Arrays.sort(arr_cd);

		System.out.println(fun1(arr_ab, arr_cd));

	}

	static long fun1(int[] ab, int[] cd) {
		long answer = 0;
		int cnt = 0;
		int p_cd = cd.length - 1;
		
		for (int p_ab = 0; p_ab < ab.length; p_ab++) {
			int target = -ab[p_ab];

			if (p_ab > 0 && ab[p_ab] == ab[p_ab - 1]) { // ab의 중복값 처리
				answer += cnt;  
			} else { 

				while (0 <= p_cd && target < cd[p_cd]) {
					p_cd--;
				}
				cnt = 0;
				if (target == cd[p_cd]) {
					while (0 <= p_cd && target == cd[p_cd]) { // cd의 중복값 처리
						cnt++;
						p_cd--;
					}
				}
				answer += cnt; // cnt만큼 같은 수가 등장
			}
		}
		return answer;
	}

}
