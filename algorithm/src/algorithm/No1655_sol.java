package algorithm;

import java.io.*;
import java.util.*;


// �켱���� queue(heap) ���� 
public class No1655_sol {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[100000];

		PriorityQueue<Integer> min_q = new PriorityQueue<>(); // ���� ���� ���� �� ��
		PriorityQueue<Integer> max_q = new PriorityQueue(new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				if (arg0 > arg1) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		for (int i = 0; i < n; i++) {
			int temp =	Integer.parseInt(br.readLine());

			if (min_q.size() == max_q.size()) {
				max_q.add(temp);
			} else {
				min_q.add(temp);
			}
			
			if(min_q.size() > 0 && max_q.size() > 0 && min_q.peek() < max_q.peek()) {
				int now_min = min_q.poll();
				int now_max = max_q.poll();
				max_q.add(now_min);
				min_q.add(now_max);
			}
			
			// �׻� max_q�� ���� �߰����̵��� ���� �� ���
			bw.write(max_q.peek()+"");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
