package algorithm;

import java.io.*;
import java.util.*;

/*
 * ������ �����غ���
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
		
		int prev = 0;	// ���ĵǾ� �����Ƿ� ���� ���� ���� ��� �Ѿ�� ����
		for(int i = 0; i < N; i++) {
			if(used[i]) {
				continue;
			}

			if(prev != num[i]) {	// ���� k��°�� ���� ���� ������ ���� X
				used[i] = true;
				answer[k] = num[i]; // k��° ��ġ�� �ִ´�.
				prev = num[i];
				rec(k+1);
				used[i] = false;
			}
		}
		
	}
}
