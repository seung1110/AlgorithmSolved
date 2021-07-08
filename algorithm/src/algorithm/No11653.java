package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class No11653 {

	public static void main(String[] args) throws Exception{
		boolean[] prime = new boolean[10000000];	
		//최대 입력값 10000000 이므로 소수 최대값은 루트 10000000이므로 4000보다 작음 but 9999991 이 소수인것처럼 예외 발생 가능!
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
