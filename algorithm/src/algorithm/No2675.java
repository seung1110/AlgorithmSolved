package algorithm;

import java.io.*;
import java.util.*;
public class No2675 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			for(int j = 0; j < str.length(); j++) {
				for(int k = 0; k < len; k++) {
					bw.write(str.charAt(j));
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
