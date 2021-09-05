package algorithm;

import java.io.*;
import java.util.*;

public class No17413 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		Deque<Character> stack = new ArrayDeque();

		boolean check = false;
		int i = 0;
		while (i < str.length()) {
			char temp = str.charAt(i);
	
			if(temp == '<') {
				while(i < str.length() && str.charAt(i) != '>') {
					bw.write(str.charAt(i));
					i++;
				}
				bw.write('>');
				i++;
			}else if(temp == ' '){
				bw.write(' ');
				i++;
			}else {
				while(i < str.length() && str.charAt(i) != '<' && str.charAt(i) != ' ') {
					stack.addLast(str.charAt(i));
					i++;
				}
				while(!stack.isEmpty()) {
					bw.write(stack.pollLast());
				}
			}
		}

		bw.flush();
		bw.close();

	}
}
