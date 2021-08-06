package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No11053 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] check = new int[n];
        Arrays.fill(check,1);

        int max = 1; // 최소 하나 이상의 입력이 있으므로 max의 최소값은 1

        for(int i = 1; i < n; i++){
            int temp = arr[i];
            for(int j = 0; j < i; j++){
                if(arr[j] < temp){
                    check[i] = Math.max(check[i],check[j]+1);
                }
            }

            max = Math.max(check[i],max);
        }

        System.out.println(max);

    }
}
