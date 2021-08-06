package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No1967 {
    static int len, max;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        max = len = 0;
        visited = new boolean[n+1];
        ArrayList<Node> list[] = new ArrayList[n+1];

        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[node].add(new Node(child,cost));
            list[child].add(new Node(node,cost));
        }


        dfs(list,1,0);
        visited[1] = false;

        dfs(list,len,0);
        System.out.println(max);
    }

    static class Node{
        int n,c;
        public Node(int num,int cost){
            n = num;
            c = cost;
        }
    }

    public static void dfs(ArrayList[] list,int num, int cost){
        if(cost > max){
            max = cost;
            len = num;
        }
        visited[num] = true;
        ArrayList<Node> al = list[num];

        if(al == null || al.size() == 0){
            return;
        }
        for(Node n : al){
            if(!visited[n.n]){
                dfs(list,n.n,cost+n.c);
                visited[n.n] = false;
            }
        }
    }
}
