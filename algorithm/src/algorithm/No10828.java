package algorithm;

import java.io.*;
import java.util.*;

public class No10828 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			switch (str.split(" ")[0]) {
			case "push":
				list.add(Integer.parseInt(str.split(" ")[1]));
				break;
			case "pop":
				if (list.size() == 0) {
					bw.write("-1");
					bw.write("\n");	
				}
				else {
					bw.write(list.get(list.size() - 1)+"");
					bw.write("\n");
					list.remove(list.size() - 1);
				}break;
			case "size":
				bw.write(list.size()+"");
				bw.write("\n");
				break;
			case "empty":
				if (list.isEmpty()) {
					bw.write("1");
					bw.write("\n");
				}
				else {
					bw.write("0");
					bw.write("\n");	
				}
				break;
			case "top":
				if(list.size() == 0) {
					bw.write("-1");
					bw.write("\n");
				}
				else {
					bw.write(list.get(list.size()-1)+"");
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
