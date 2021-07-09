package algorithm;

import java.util.*;
import java.io.*;

/*
 * ���� �Ҽ��� ���μ� �����ϰ� N��ŭ�� ����� ���� �Ҽ�?
 * �� �ȵǳ�.. ����!! �ٸ� ������� Ǯ�� ����
 */

public class No2904 {
	static ArrayList<Integer> prime_list;
	static int[] get_index;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if(N == 1) {
			System.out.println(arr[0]+" 0");
			return;
		}
		// �Ҽ� ��� ���ϱ�
		prime_list = new ArrayList<>();
		boolean[] check = new boolean[1000000];
		for(int i = 2; i < 1000000; i++) {
			if(check[i])
				continue;
			else {
				prime_list.add(i);
				for(int j = i+i; j < 1000000; j+=i) {
					check[j] = true;
				}
			}
		}

		// ���μ������� �Ҽ����� ����
		int[] sum = new int[prime_list.size()];
		int cnt = 0;
		for(int i = 0; i < arr.length; i++) {
			int[] temp = sol(arr[i]);

			if(temp != null) {
				for(int j = 0; j < temp.length; j++) {
					sum[j] += temp[j];
					if(temp[j] != 0) {	// ���� ū �Ҽ��� �����ϴ� prime_list�� �ε���
						cnt = j;
					}
				}
			}
		}


		// ���� �� �ִ� �ִ�����
		int max = 1;
		for(int i = 0; i <= cnt; i++) {
			if(sum[i] > 0) {
				sum[i] = sum[i] / N;
				if(sum[i] != 0)
					max = (int) (max * Math.pow(prime_list.get(i),sum[i]));
			}
		}
		

		

	
		System.out.print(max+ " ");
		
		//�ּ� �̵�Ƚ�� ���ϱ�
		int c_cnt = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j <= cnt; j++) {
				if(sum[j] > 0) {
					while(arr[i] % Math.pow(prime_list.get(j), sum[j]) != 0) {
						arr[i]*=prime_list.get(j);
						c_cnt++;
					}
				}
			}
		}
		
		System.out.println(c_cnt);
	}
	
	
	static int[] sol(int k) {
		if(k == 1) {
			return null;
		}
		int[] sol = new int[prime_list.size()];

		for(int i = 0; i < prime_list.size(); i++) {
			while(k % prime_list.get(i) == 0 && k > 1) {
				k /= prime_list.get(i);
				sol[prime_list.indexOf(prime_list.get(i))] += 1;
			}
			if(k == 1) {
				break;
			}
		}
		return sol;
	}
	
}
