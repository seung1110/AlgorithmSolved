package programmers;

import java.util.*;

public class No42579 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        // 장르별 순서 구하기
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<String,ArrayList<Pair>> pairMap = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            if (map.putIfAbsent(genres[i], plays[i]) != null) {
                map.replace(genres[i], map.get(genres[i]) + plays[i]);
            }

            if (pairMap.containsKey(genres[i])) {
                pairMap.get(genres[i]).add(new Pair(i, plays[i]));
            } else {
                ArrayList<Pair> temp = new ArrayList<>();
                temp.add(new Pair(i, plays[i]));
                pairMap.put(genres[i], temp);
            }
        }

        ArrayList<Map.Entry> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                return (int)o2.getValue() - (int)o1.getValue();
            }
        });

        ArrayList<Integer> answer = new ArrayList<>();
        // 장르 내에서 높은 순서로 구하기
        for(int i = 0; i < list.size(); i++){
            String str = (String)list.get(i).getKey();
            ArrayList<Pair> temp = pairMap.get(str);
            if(temp.size() == 1){
                answer.add(temp.get(0).num);
            }else {
                temp.sort(new Comparator<Pair>() { // plays 큰 순서로 정렬
                    @Override
                    public int compare(Pair o1, Pair o2) {
                        return o2.plays - o1.plays;
                    }
                });
                answer.add(temp.get(0).num);
                answer.add(temp.get(1).num);
            }

        }
        int[] arr = new int[answer.size()];
        for(int i = 0; i < arr.length;i++){
            arr[i] = answer.get(i);
        }

        System.out.println(answer.toString());

    }

    static class Pair{
        int num, plays;
        public Pair(int x, int y){
            this.num = x;
            this.plays = y;
        }
    }

}
