package programmers;

import java.util.HashMap;

public class No42578 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int answer = 1, cnt = 0;
        HashMap<String,Integer> map = new HashMap<>();

        for(int i = 0; i < clothes.length;i++){
            String cate = clothes[i][1];
            if(map.putIfAbsent(cate,1) != null){ // 같은 종류는 묶어서 생각
                map.replace(cate,map.get(cate)+1);
            }else{
                cnt++;
            }
        }

        if(cnt == 1){
            System.out.println(map.get(clothes[0][1]));
        }else{ // 종류 2개 이상
            for(String str : map.keySet()){
                answer *= (map.get(str)+1);
            }
            System.out.println(answer-1);
        }

    }
}
