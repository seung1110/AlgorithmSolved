package programmers;

import java.util.Deque;
import java.util.LinkedList;

public class No42583 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        int answer = 0;

        LinkedList<Integer> q = new LinkedList<>();

        int now = 0;
        int now_weight = 0;
        while(now < truck_weights.length){
            while(q.size() <= bridge_length && now < truck_weights.length){
                if(now_weight + truck_weights[now] <= weight){
                    q.add(now);
                    now_weight += truck_weights[now++];
                    answer++;
                }else{
                    break;
                }
            }
            System.out.println(now);
            if(q.size() == bridge_length){ // 길이가 먼저 가득
                answer++;
                int num = q.poll();
                if(num != -1) {
                    now_weight -= truck_weights[num];
                }
            }else { // 무게가 먼저 가득
                while(q.size() < bridge_length){
                    q.add(-1);
                    answer++;
                }
                int num = -1;
                while(num == -1) {
                    answer++;
                    num = q.poll();
                    if(num != -1) {
                        now_weight -= truck_weights[num];
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
