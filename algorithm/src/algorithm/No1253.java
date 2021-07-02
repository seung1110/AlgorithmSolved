package algorithm;

import java.util.*;
public class No1253 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<Integer> list = new LinkedList();
		for(int i = 0; i < n ; i++) {
			list.offer(sc.nextInt());
		}
		list.sort(null);
		
		int result = 0;
		for(int i = 2; i < n; i++) {
			int sum = list.get(0) + list.get(1);
			int now = list.get(i);
			if(now == sum) {
				result++;
			}
			for(int j = 2; j < i; j++) {
				sum += list.get(j);
				if(now == sum) {
					result++;
					break;
				}else if (now < sum) {
					break;
				}
			}
		}
		System.out.println(result);
	}

}
