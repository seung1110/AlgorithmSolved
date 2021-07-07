package algorithm;

import java.util.*;

// 우선순위 queue(heap) 문제
public class No1655 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[100000];

		PriorityQueue<Integer> min_q = new PriorityQueue<>(); // 가장 작은 값이 맨 앞
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

			if(!min_q.isEmpty() && !max_q.isEmpty() && (min_q.peek() < max_q.peek()) ) { // 50 40 1 과 같은 케이스 처리
				int min_top = min_q.poll();
				int max_top = max_q.poll();
				min_q.add(max_top);
				max_q.add(min_top);
			}
			
			// 항상 max_q의 값이 중간값이도록 설정 후 출력
			System.out.println(max_q.peek());

		}
	}

}
