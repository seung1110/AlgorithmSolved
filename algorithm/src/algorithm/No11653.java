package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class No11653 {

	public static void main(String[] args) throws Exception{
		boolean[] prime = new boolean[10000000];	
		//�ִ� �Է°� 10000000 �̹Ƿ� �Ҽ� �ִ밪�� ��Ʈ 10000000�̹Ƿ� 4000���� ���� but 9999991 �� �Ҽ��ΰ�ó�� ���� �߻� ����!
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 2; i < 10000000; i++) {
			if(!prime[i]) {
				list.add(i);
				for(int j = i+i; j < 10000000; j += i) {
					prime[j] = true;
				}
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < list.size() && n > 1; i++) {
			int temp = list.get(i);
			while(n % temp  == 0) {
				n = n / temp;
				bw.write(temp+"");
				bw.write("\n");
			}
		}
		
		bw.flush();
		bw.close();
	}

}
