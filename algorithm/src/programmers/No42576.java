package programmers;

import java.util.HashMap;

public class No42576 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        String answer = "";

        HashMap<String,Integer> map = new HashMap<>();

        for(String str : participant){
            if(map.putIfAbsent(str,1) != null){ // 해당 key 값이 없으면 null return, 아니면 value 값 return
                map.replace(str,map.get(str)+1); // 값 수정
            }
        }

        for(String str : completion) {
            if (map.get(str) > 1) {
                map.replace(str, map.get(str) - 1);
            } else{
                map.remove(str);
            }
        }

        for(String str : map.keySet()){
            answer += (str +"");
        }

        System.out.println(answer);
    }
}
