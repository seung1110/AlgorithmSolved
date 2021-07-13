package algorithm;

import java.util.*;
import java.io.*;

public class No8958 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String str = br.readLine();
			int cnt = 1;
			int sum = 0;
			for(int j = 0; j < str.length(); j++) {
				if(j == 0) {
					if(str.charAt(j) == 'O') {
						sum += cnt++;
					}
					continue;
				}
				
				if(str.charAt(j) == 'O') {
					if(str.charAt(j-1) == 'O') {
						sum += cnt++;
					}else {
						cnt = 1;
						sum += cnt++;
					}
				}
			}
			bw.write(sum+"\n");
		}
		bw.flush();
		bw.close();
	}

}
