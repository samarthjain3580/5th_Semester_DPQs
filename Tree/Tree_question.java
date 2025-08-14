package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Tree.BinaryTree.Node;

public class Tree_question {
	class Node {
		int val;
		Node left;
		Node right;
	}
	private Node root;
	Scanner sc = new Scanner(System.in);
	public void BinaryTree() {
		root = CreateTree();
	}
	private Node CreateTree() {
		int item = sc.nextInt();
		Node nn = new Node();
		nn.val = item;
		boolean lhs = sc.nextBoolean(); 	//lhs: left hand side
		if (lhs) {
			nn.left = CreateTree();
		}
		boolean rhs = sc.nextBoolean(); 	//rhs: right hand side
		if (rhs) {
			nn.right = CreateTree();
		}
		return nn;
	}
	
	public boolean find(int item) {
		return find(root, item);
	}
	
	private boolean find(Node nn, int item) {
		if (nn == null) {
			return false;
		}
		if (nn.val == item) {
			return true;
		}
		boolean left = find(nn.left, item);
		boolean right = find(nn.right, item);
		return left||right;
	}
	
	public int max() {
		return max(root);
	}
	
	private int max(Node nn) {
		if (nn == null) {
			return Integer.MIN_VALUE;
		}
		int lmax = max(nn.left);
		int rmax = max(nn.right);
		return Math.max(nn.val, Math.max(lmax, rmax));
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(Node nn) {
		if (nn == null)
			return 0;
		int lh = height(nn.left);
		int rh = height(nn.right);
		return Math.max(lh,rh)+1;
	}
	
	public void PreOrder() {
		PreOrder(root);
		System.out.println();
	}
	
	private void PreOrder(Node nn) {
		if (nn == null) {
			return;
		}
		System.out.println(nn.val+" ");
		PreOrder(nn.left);
		PreOrder(nn.right);
	}
	
	public void InOrder() {
		InOrder(root);
		System.out.println();
	}
	
	private void InOrder(Node nn) {
		if (nn == null) {
			return;
		}
		InOrder(nn.left);
		System.out.println(nn.val+" ");
		InOrder(nn.right);
	}

	public void PostOrder() {
		PostOrder(root);
		System.out.println();
	}
	
	private void PostOrder(Node nn) {
		if (nn == null) {
			return;
		}
		PostOrder(nn.left);
		PostOrder(nn.right);
		System.out.println(nn.val+" ");
	}
	
	public void LevelOrder() {
		Queue<Node> q = new LinkedList<>();
		q.add(root);	//add-last
		while(!q.isEmpty()) {
			Node n = q.poll(); 		//q.remove() --> remove first
			System.out.println(n.val+" ");
			if (n.left != null) {
				q.add(n.left);
			}
			if (n.right != null) {
				q.add(n.right);
			}
		}
		System.out.println();
	}

}