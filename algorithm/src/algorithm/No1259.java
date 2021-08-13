package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1259 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while(!(str=br.readLine()).equals("0")){
            boolean check = true;
            for(int i = 0; i < str.length()/2;i++){
                if(str.charAt(i) != str.charAt(str.length()-1-i)){
                    check = false;
                    break;
                }
            }
            if(check){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}
