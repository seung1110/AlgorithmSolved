package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1202 {

	static int N,M;
	static Info[] jam;
	static int[] pack;
	public static void main(String[] args) throws Exception {
		// 가방 크기순 정렬, 보석 크기순 정렬
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		jam = new Info[N];
		pack = new int[M];
		
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			jam[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < M; i++) {
			pack[i] = Integer.parseInt(br.readLine());
		}
		
		// 크기, 무게 순으로 정렬
		Arrays.sort(pack);
		Arrays.sort(jam,new Comparator<Info>() {
			@Override
			public int compare(Info a, Info b) {
				return a.x - b.x;
			}
		});
		
		// 가방 크기 순으로 보면서 가방에 넣을 수 있는 가장 적합한 보석을 넣는다 (가방 하나에 하나의 보석만 가능)
		int p_jam = 0;
//		List<Integer> cand_jam = new ArrayList<>(); // list 사용시 매번 정렬 복잡, 후보가 되는 목록 priority queue 활용
		PriorityQueue<Integer> cand_jam = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer arg1, Integer arg2) {
				return arg2 - arg1;
			}
		});	
		
		long answer = 0;
		
		for(int i = 0; i < M ; i++) {
			int now_pack = pack[i];
			
			while(p_jam < N && jam[p_jam].x <= now_pack) {
				cand_jam.add(jam[p_jam].y);
				p_jam++;
			}
			

			// 가능한 후보 중 가장 가치가 큰 경우
			if(!cand_jam.isEmpty()) {
				answer += cand_jam.poll();
			}
		}
		
		System.out.println(answer);

		
	}
	static class Info{
		int x,y;
		Info(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
