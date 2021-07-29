package algorithm;

import java.io.*;

public class No1003 {
    static Val[] val = new Val[41];
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        val[0] = new Val(1,0);
        val[1] = new Val(0,1);
        for(int i = 2; i <= 40; i++){
            val[i] = new Val(val[i-1].zero + val[i-2].zero,val[i-1].one+val[i-2].one);
        }
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int k = Integer.parseInt(br.readLine());
            bw.write(val[k].zero + " " + val[k].one + "\n");
        }
        bw.flush();
        bw.close();
    }
    static class Val{
        int zero,one;
        public Val(int zero, int one){
            this.zero = zero;
            this.one = one;
        }
    }

}
