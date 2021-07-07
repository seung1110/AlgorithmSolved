package algorithm;

import java.util.Scanner;

public class No5639 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		Node root = new Node(num);
		
		while(sc.hasNext()) {
			root.addNode(new Node(sc.nextInt()));
		}
		
		rec(root);

	}
	
	static void rec(Node node) {
		if(node.left != null) {
			rec(node.left);
		}
		if(node.right != null) {
			rec(node.right);
		}
		System.out.println(node.node);
	}
	
	static class Node{
		int node;
		Node left,right;
		
		public Node(int node){
			this.node = node;
		}
		
		void addNode(Node n) {
			if(n.node > this.node) {
				if(right != null)
					this.right.addNode(n);
				else
					this.right = n;
			}else {
				if(left != null){
					this.left.addNode(n);
				}else
					this.left = n;
			}
		}
	}

}
