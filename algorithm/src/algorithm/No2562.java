package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2562 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0, check = 0;
		for(int i = 0; i < 9; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp > max) {
				max = temp;
				check = i;
			}
		}

		System.out.println(max);
		System.out.println(check+1);
	}

}
