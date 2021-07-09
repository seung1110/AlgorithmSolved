package algorithm;

import java.io.*;
import java.util.*;

/*
 * 곰곰히 생각해보기
*/
public class No15663 {

	static int N,M;
	static int[] answer = new int[8],num;
	static boolean[] used = new boolean[8];
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);	
		
		rec(0);
		bw.flush();
		bw.close();

	}

	static void rec(int k) throws IOException {
		if(k == M) {
			for(int i = 0; i < M; i++) {
				bw.write(answer[i]+" ");
			}
			bw.write("\n");
			return;
		}
		
		int prev = 0;	// 정렬되어 있으므로 이전 값과 같을 경우 넘어가지 않음
		for(int i = 0; i < N; i++) {
			if(used[i]) {
				continue;
			}

			if(prev != num[i]) {	// 이전 k번째에 넣은 값이 같으면 실행 X
				used[i] = true;
				answer[k] = num[i]; // k번째 위치에 넣는다.
				prev = num[i];
				rec(k+1);
				used[i] = false;
			}
		}
		
	}
}
