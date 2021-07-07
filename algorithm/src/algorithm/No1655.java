package algorithm;

import java.util.*;

// �켱���� queue(heap) ����
public class No1655 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
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
			int temp = sc.nextInt();

			if (min_q.size() == max_q.size()) {
				max_q.add(temp);
			} else {
				min_q.add(temp);
			}

			if(!min_q.isEmpty() && !max_q.isEmpty() && (min_q.peek() < max_q.peek()) ) { // 50 40 1 �� ���� ���̽� ó��
				int min_top = min_q.poll();
				int max_top = max_q.poll();
				min_q.add(max_top);
				max_q.add(min_top);
			}
			
			// �׻� max_q�� ���� �߰����̵��� ���� �� ���
			System.out.println(max_q.peek());

		}
	}

}
