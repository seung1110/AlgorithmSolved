package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No1991 {
    public static Node[] nodes = new Node[26];
    public static BufferedWriter bw;
    public static char CH = '-';
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            char m = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);
            nodes[m-'A'] = new Node(m,l,r);
        }

        preorderT('A');
        bw.write("\n");
        inorderT('A');
        bw.write("\n");
        postorderT('A');
        bw.flush();
        bw.close();
    }
    public static void preorderT(char root) throws Exception{
        int num = root - 'A';
        if(nodes[num] != null) {
            bw.write(root + "");
            if(nodes[num].l != CH)
                preorderT(nodes[num].l);
        }
        if(nodes[num].r != CH)
            preorderT(nodes[num].r);

    }
    public static void inorderT(char root) throws Exception{
        int num = root - 'A';
        if(nodes[num] == null){
            return;
        }
        if(nodes[num].l != CH){
            inorderT(nodes[num].l);
        }
        bw.write(nodes[num].m+"");

        if(nodes[num].r != CH){
            inorderT(nodes[num].r);
        }
    }

    public static void postorderT(char root)throws Exception{
        int num = root - 'A';
        if(nodes[num] == null){
            return;
        }
        if(nodes[num].l != CH){
            postorderT(nodes[num].l);
        }
        if(nodes[num].r != CH){
            postorderT(nodes[num].r);
        }
        bw.write(nodes[num].m+"");

    }

    static class Node{
        char l,r,m;

        public Node(char m, char l, char r){
            this.m = m;
            this.l = CH;
            this.r = CH;
            if(l != '.'){
                this.l = l;
            }
            if(r != '.'){
                this.r = r;
            }
        }
    }
}
