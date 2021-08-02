package programmers;

import java.util.HashMap;

public class No42576 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        String answer = "";

        HashMap<String,Integer> map = new HashMap<>();

        for(String str : participant){
            if(map.putIfAbsent(str,1) != null){
                map.replace(str,map.get(str)+1);
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
