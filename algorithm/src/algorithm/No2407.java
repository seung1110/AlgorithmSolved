package algorithm;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No2407 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BigInteger answer = BigInteger.ONE;
        int k = m - n < 0 ? n - m : m - n;

        if(n == m){
            System.out.println(1);
        }else{
            // 100 C 6  == 100 C 94
            m = m > k ? k : m;
            for(int i = 1; i <= m ;i++){
                answer = answer.multiply(BigInteger.valueOf(n-i+1));
                answer = answer.divide(BigInteger.valueOf(i));
            }
            System.out.println(answer);
        }
    }
}
