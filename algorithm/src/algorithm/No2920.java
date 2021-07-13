package algorithm;

import java.util.*;
import java.io.*;

public class No2920 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input = new int[8];
		boolean check_a = true;
		for (int i = 0; i < 8; i++) {
			input[i] = Integer.parseInt(st.nextToken());

			if (i > 0 && input[i] - input[i - 1] != 1 && input[i] - input[i - 1] != -1) {
				check_a = false;
			}
		}
		if (check_a) {
			if (input[0] == 1) {
				System.out.println("ascending");
			} else {
				System.out.println("descending");
			}
		} else {
			System.out.println("mixed");
		}

	}

}
