package algorithm;

import java.io.*;


public class No10809 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] alpha = new char[26];
		alpha[0] = 'a';
		for(int i = 1; i < 26; i++) {
			alpha[i] = (char)(alpha[0]+i);
		}
		
		try {
			String s = br.readLine();
			for(int i = 0; i < 26; i++) {
				System.out.print(s.indexOf(alpha[i])+" ");
			}

			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
