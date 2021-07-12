package algorithm;

import java.io.*;
import java.util.*;

public class No10951 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String str;
		while((str = br.readLine()) != null) {
			st = new StringTokenizer(str);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			bw.write((x+y)+"");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
