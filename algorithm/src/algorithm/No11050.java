package algorithm;

import java.util.Scanner;

public class No11050 {

    static int[][] cache;
    static int N,K;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        
        cache = new int[N+1][K+1];
        
        for(int i = 0; i < N+1; i++){
            for(int j = 0; j < K+1; j++){
                cache[i][j] = -1;
            }
        }

        System.out.println(rec(N,K));
    }
    static int rec(int n, int k){
    	if(k == 0)
    		return 1;
    	
        if(n < k)
            return 0;
        
        if(0 > n || n > N || 0 > k || k > K)
            return 0;
 
        if(cache[n][k] != -1)
            return cache[n][k];
        
        int temp = rec(n-1,k-1) + rec(n-1,k);
        cache[n][k] = temp;

        return cache[n][k];
    }

}
