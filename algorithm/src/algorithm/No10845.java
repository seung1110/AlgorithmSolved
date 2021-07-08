package algorithm;

import java.io.*;
import java.util.*;

public class No10845 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			switch (str.split(" ")[0]) {
			case "push":
				q.add(Integer.parseInt(str.split(" ")[1]));
				break;
			case "pop":
				if (!q.isEmpty()) {
					bw.write(q.poll() + "");
					bw.write("\n");
				} else {
					bw.write("-1");
					bw.write("\n");
				}
				break;
			case "size":
				bw.write(q.size() + "");
				bw.write("\n");
				break;
			case "empty":
				if (q.isEmpty()) {
					bw.write("1");
					bw.write("\n");
				} else {
					bw.write("0");
					bw.write("\n");
				}
				break;
			case "front":
				if (q.isEmpty()) {
					bw.write("-1");
					bw.write("\n");
				} else {
					bw.write(q.peek()+"");
					bw.write("\n");
				}
				break;
			case "back":
				if (q.isEmpty()) {
					bw.write("-1");
					bw.write("\n");
				} else {
					bw.write(q.getLast()+"");
					bw.write("\n");
				}
				break;
			default:
				break;
			}

		}
		bw.flush();
		bw.close();

	}

}
