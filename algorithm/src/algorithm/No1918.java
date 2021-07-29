package algorithm;

import java.io.*;
import java.util.*;

public class No1918 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        int size = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                size++;
                continue;
            }else if(str.charAt(i)==')'){
                size--;
                while(!stack.isEmpty()){
                    bw.write(stack.pop());
                }
                continue;
            }

            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                bw.write(str.charAt(i));
            }else{
                if(stack.isEmpty()){
                    stack.push(str.charAt(i));
                }else{
                    char c = stack.peek();
                    if((c =='+'||c=='-') && (str.charAt(i) == '*' || str.charAt(i)=='/')){
                        stack.push(str.charAt(i));
                    }else{
                        if(size == 0) {
                            bw.write(stack.pop());
                            stack.push(str.charAt(i));
                        }else{
                            stack.push(str.charAt(i));
                        }
                    }

                }
            }
        }

        while(!stack.isEmpty()){
            bw.write(stack.pop());
        }

        bw.flush();
        bw.close();

    }


}
