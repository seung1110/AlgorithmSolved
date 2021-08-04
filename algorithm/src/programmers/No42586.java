package programmers;

import java.util.*;

public class No42586 {
    public static void main(String[] args) {
        int[]progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] answer;

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> check = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++){
            queue.offer(progresses[i]);
            queue.offer(speeds[i]);
        }

        int day = 0;

        while(!queue.isEmpty()){
            int nowP = queue.poll();
            int nowS = queue.poll();

            if(nowP + nowS*day >= 100) { // 이미 완료된 경우
                list.add(nowP); // list 추가
                continue;
            }else{
                if(list.size()!=0){ // list에 값이 있을 경우
                    check.add(list.size());
                    list.clear();
                }
            }
            while(nowP + nowS*day < 100){
                day++;
            }
            list.add(nowP);
        }

        if(list.size() != 0){ // 마지막 값이 100보다 클 경우 처리
            check.add(list.size());
        }

        answer = new int[check.size()];
        for(int i = 0; i < check.size();i++){
            answer[i] = check.get(i);
        }

    }
}
