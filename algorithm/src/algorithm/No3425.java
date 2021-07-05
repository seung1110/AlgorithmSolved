package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


// 입력 해결하기!
public class No3425 {

	public static void main(String[] args) throws Exception {
		// 예외처리, 초기화 안되는 것 주의
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		String now;
		while (true) {
			now = br.readLine();
			if(now.equals("QUIT")) {
				break;
			}
			List<String> cmd = new ArrayList<>();
			
			while (!now.equals("END")) {
				cmd.add(now);
				now = br.readLine();
			}
			
			int n = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < n; i++) {
				now = br.readLine();
				list.add(Integer.parseInt(now));
				fun(list,cmd);
				list.clear();
				System.out.println();
			}
			System.out.println();
			br.readLine();
		}

	}
	
	public static void fun(List<Integer>li, List<String> cmd) {

		for(int i = 0; i < cmd.size(); i++) {
			String str = cmd.get(i);
			if(str.contains("NUM")) {
				li.add(Integer.parseInt(str.split(" ")[1]));
			}else if(str.contains("POP") || str.contains("INV")|| str.contains("DUP")) {
				if(li.size() == 0) {
					System.out.print("ERROR");
					break;
				}else {
					if(str.contains("POP")) {
						li.remove(li.size()-1);	
					}else if(str.contains("INV")) {
						int temp = li.get(li.size()-1);
						li.remove(li.size()-1);
						li.add(temp*(-1));
					}else if(str.contains("DUP")) {
						li.add(li.get(li.size()-1));
					}
				}
			}else if(str.contains("SWP") || str.contains("ADD") || str.contains("SUB")|| str.contains("MUL")||str.contains("DIV")||str.contains("MOD")) {
				if(li.size() < 2) {
					System.out.print("ERROR");
					break;
				}else {
					int first = li.get(li.size()-1);
					int second = li.get(li.size()-2);
					li.remove(li.size()-1);
					li.remove(li.size()-1);
					if(str.contains("SWP")) {						
						li.add(first);
						li.add(second);
					}else if(str.contains("ADD")) {
						long temp = (long)(first+second);
						if(temp > Math.pow(10, 9) || temp < -Math.pow(10, 9)) {
							System.out.print("ERROR");
							break;
						}else {
							li.add((int)temp);
						}
					}else if(str.contains("SUB")) {
						long temp = (long)(second-first);
						if(temp > Math.pow(10, 9) || temp < -Math.pow(10, 9)) {
							System.out.print("ERROR");
							break;
						}else {
							li.add((int)temp);
						}
					}else if(str.contains("MUL")) {
						long temp = (long)(second*first);
						if(temp > Math.pow(10, 9) || temp < -Math.pow(10, 9)) {
							System.out.print("ERROR");
							break;
						}else {
							li.add((int)temp);
						}
					}else if(str.contains("DIV") || str.contains("MOD")) {
						if(first == 0 || second == 0) {
							System.out.print("ERROR");
							break;
						}
						
						if(str.contains("DIV")) {					
							if((first< 0 && second > 0)||(first> 0 && second < 0)) {
								first = first > 0 ? first : -first;
								second = second > 0 ? second : -second;
								li.add(-(int)(second/first));
							}else {
								first = first > 0 ? first : -first;
								second = second > 0 ? second : -second;
								li.add((int)(second/first));
							}
						}else {
							if(second < 0) {
								first = first > 0 ? first : -first;
								second = second > 0 ? second : -second;
								li.add(-(second%first));
							}else {
								li.add(second/first);
							}
						}
					}
				}
			}
		}
		
		if(li.size() == 1) {
			System.out.print(li.get(0));
		}else if(li.size()>1) {
			System.out.print("ERROR");
		}
	}

}
