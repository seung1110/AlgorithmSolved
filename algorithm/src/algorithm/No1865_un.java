package algorithm;

import java.io.*;
import java.util.*;

public class No1865_un {
    static int INT_MAX = Integer.MAX_VALUE-1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());   // 지점 수
            int m = Integer.parseInt(st.nextToken());   // 도로 수
            int w = Integer.parseInt(st.nextToken());   // 웜홀 수

            int[][] map = new int[n+1][n+1];
            for(int k = 1; k <= n; k++) {
                Arrays.fill(map[k], INT_MAX);
            }
            int[][] hole = new int[w][3];

            for(int k = 0; k < m; k++){ // 도로 추가
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if(map[a][b] == INT_MAX) {
                    map[a][b] = c;
                    map[b][a] = c;
                }else{
                    map[a][b] = Math.min(map[a][b],c);
                    map[b][a] = Math.min(map[b][a],c);
                }
            }

            for(int k = 0; k < w; k++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                hole[k][0] = a;
                hole[k][1] = b;
                hole[k][2] = c;
            }

            for(int a = 1; a <= n; a++){
                for(int b = 1; b <= n; b++){
                    for(int c = 1; c <= n; c++){
                        if(a==b||a==c||b==c){
                            continue;
                        }
                        if(map[a][c] + map[c][b] > 0){
                            map[a][b] = Math.min(map[a][c]+map[c][b],map[a][b]);
                        }
                    }
                }
            }

            boolean check = true;
            for(int k = 0; k < w; k++){
                if(map[hole[k][1]][hole[k][0]] < hole[k][2]){
                    System.out.println("YES");
                    check = false;
                    break;
                }
            }
            if(check){
                System.out.println("NO");
            }
        }
    }
}
