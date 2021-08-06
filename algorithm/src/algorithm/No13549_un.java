package algorithm;

import java.util.Scanner;

public class No13549_un {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        // 순간이동시 n*2 위치로 이동 0초
        // 도보 이동 n+1 or n-1 이동 1초
        if(n - k > 0){ // n이 k보다 크다
            System.out.println(n-k);
        }else if(n - k == 0){
            System.out.println(0);
        }else{

        }

    }
}
