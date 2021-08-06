package algorithm;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class No11444_un {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int m = 1000000007;
        // 1000000007
        int[] cache = new int[10000000];
        cache[0] = 0;
        cache[1] = 1;
//        for(int i= 2; i < 1001; i++){
//            cache[i] = (cache[i-1]%m + cache[i-2]%m)%m;
//        }
        Set<Integer> set = new HashSet<>();
        for(int i= 2; i < cache.length; i++){
            cache[i] = (cache[i-1]%m + cache[i-2]%m)%m;
            set.add(cache[i]);
        }
        //
        // n = ((n-1)%m + (n-2)%m));

        System.out.println(set.size());

    }


}
