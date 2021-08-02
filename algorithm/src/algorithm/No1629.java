package algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No1629 {
    static int a;
    static int[] cache;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int cnt = 1;
        int cnt_b = b;
        while(cnt_b > 1){
            cnt_b /= 2;
            cnt++;
        }


        cache = new int[cnt+1];
        Arrays.fill(cache,-1);
        //a^b  = a^b/2 * a^b/2
        System.out.println(rec(b,c, cnt));

    }

    public static int rec(int n, int c, int cnt){
        int sum;
        if(n == 1){
            return a%c;
        }
        if(cache[cnt] != -1){
            return cache[cnt];
        }
        if(n%2 == 0){
            sum = (rec(n/2,c,cnt-1)%c * rec(n/2,c,cnt-1)%c)%c;
        }else{
            sum = ((rec(n/2,c,cnt-1)%c * rec(n/2,c,cnt-1)%c)%c * a%c)%c;
        }
        cache[cnt] = sum;
        return sum;
    }
}
