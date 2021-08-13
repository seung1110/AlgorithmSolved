package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class No1181 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() < o2.length()){
                    return -1;
                }else if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                 else{
                    return 1;
                }
            }
        });
        for(int i = 0; i < n; i++){
            set.add(br.readLine());
        }
        for(String s : set){
            System.out.println(s);
        }
    }
}
