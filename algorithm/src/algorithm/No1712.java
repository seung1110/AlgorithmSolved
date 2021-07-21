package algorithm;

import java.util.*;
import java.io.*;

public class No1712 {

	static long a,b,c;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());
		if(b > c || c == b) {
			System.out.println(-1);
			return ;
		}
		
		int i = (int)(a/(c-b)) + 1;


		System.out.println(i);
	}

}
