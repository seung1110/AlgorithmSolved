package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1713 {

	static int[] frame = new int[101];  // 사진틀 여부
	static int[] frame_good = new int[101];  // 좋아요 숫자
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0 ; i < count; i++) {
			q.add(sc.nextInt());
		}

		int frame_count = 0;
		int reg_count = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			if(frame[now] > 0) { // 사진틀에 등록되어 있을 때
				frame_good[now]++;
			}else {  // 사진틀에 등록되어 있지 않을 때
				if(frame_count < n) {  // 사진틀의 공간이 있을 때
					frame[now] = ++reg_count;
					frame_count++;
					frame_good[now] = 1;
				}else if (frame_count == n) {
					
					int min = 1000;
					for(int i = 1; i < frame_good.length; i++) {
						if(frame_good[i] > 0 && frame_good[i] < min) {
							min = frame_good[i];
						}
					}
					int min_num = 0;
					int first_reg = 1000;
					for(int i = 1; i < frame_good.length; i++) {
						if(frame_good[i] == min && first_reg > frame[i]) {
							first_reg = frame[i];
							min_num = i;
						}
					}
					
					frame_good[min_num] = 0; // 좋아요 초기화
					frame[min_num] = 0;  // 사진 내리기
					
					frame[now] = ++reg_count;
					frame_good[now] = 1;
				}
				
			}

		}

		
		for(int i = 1; i < frame.length; i++) {
			if(frame[i] > 0) {
				System.out.print(i+" ");
			}
		}


	}

}
