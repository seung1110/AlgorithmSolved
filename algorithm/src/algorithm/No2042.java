package algorithm;

import java.util.*;
import java.io.*;

public class No2042 {

	static int N, M, K;
	static long[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int n = N;
		int leaf = 1;
		
		while(n >= 1) {
			leaf *= 2;
			n /= 2;
		}
		
		tree = new long[leaf*2]; // �� �տ� �����ϰ� ����
		for (int i = 0; i < N; i++) {
			int temp = tree.length / 2 + i;
			tree[temp] = Long.parseLong(br.readLine());	// long ������ ���ڰ� ���´�.
		}
		
		init(tree.length / 2, tree.length - 1);
		
		for (int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int com = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());	// �����ϴ� ���� ������ long

			if (com == 1) {
				change(a, b);
			} else {	
				bw.write(query(a, (int)b) + "\n");
			}
		}
		bw.flush();
		bw.close();
	}

	static void init(int start, int end) {
		if (start == end)
			return;

		int s = start;
		while (s < end) {
			tree[s / 2] = tree[s] + tree[s + 1];
			s += 2;
		}
		init(start / 2, end / 2);
	}

	static void change(int a, long b) {
		int idx_a = tree.length / 2 + a - 1;

		long ch_a = b - tree[idx_a];
		tree[idx_a] = b;	// a ��ġ�� ���� b�� ����

		if (ch_a != 0) {
			// a ��ġ�� �θ� ����
			while (idx_a >= 2) {
				idx_a = idx_a / 2;
				tree[idx_a] += ch_a;
			}
		}
	}

	static long query(int l, int r) { // l���� r������ ������
		l +=  tree.length / 2 - 1;
		r +=  tree.length / 2 - 1;
		long res = 0;
		while(l <= r && r > 0) {
			if(l%2 == 1) {			// ������ ����� ��� �� ���ϰ� ������ ���� �̵�
				res += tree[l++];
			}
			if(r%2 == 0) {			// ���� ����� ��� �� ���ϰ� ���� ���� �̵�
				res += tree[r--];
			}
			
			l /= 2; 
			r /= 2; 
		}


		return res;
	}

}
