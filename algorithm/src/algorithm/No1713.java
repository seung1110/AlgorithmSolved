package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1713 {

	static int[] frame = new int[101];  // ����Ʋ ����
	static int[] frame_good = new int[101];  // ���ƿ� ����
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
			if(frame[now] > 0) { // ����Ʋ�� ��ϵǾ� ���� ��
				frame_good[now]++;
			}else {  // ����Ʋ�� ��ϵǾ� ���� ���� ��
				if(frame_count < n) {  // ����Ʋ�� ������ ���� ��
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
					
					frame_good[min_num] = 0; // ���ƿ� �ʱ�ȭ
					frame[min_num] = 0;  // ���� ������
					
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
