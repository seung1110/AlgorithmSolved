package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class No9251 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[] cnt1 = new int[1001];
        int[] cnt2 = new int[1001];
        Arrays.fill(cnt1,-1);
        Arrays.fill(cnt2,-1);

        ArrayList<Integer> list[] = new ArrayList[26];

        for(int i = 0; i < list.length; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < str1.length();i++){
            list[str1.charAt(i)-'A'].add(i);
        }

        for(int i = 0; i < str2.length();i++){
            int num = str2.charAt(i) - 'A';
            if(list[num].size() != 0){
                cnt1[i] = list[num].get(0);
                list[num].remove(0);
            }
        }

        for(int i = 0; i < str2.length();i++){
            list[str2.charAt(i)-'A'].add(i);
        }

        for(int i = 0; i < str1.length();i++){
            int num = str1.charAt(i) - 'A';
            if(list[num].size() != 0){
                cnt2[i] = list[num].get(0);
                list[num].remove(0);
            }
        }

        for(int i = 0; i < str2.length();i++){
            System.out.print(cnt1[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < str2.length();i++){
            System.out.print(cnt2[i] + " ");
        }



    }
}
