package Tree;
import java.util.*;
public class BinaryTree {
	class Node {
		int val;
		Node left;
		Node right;
	}
	private Node root;
	Scanner sc = new Scanner(System.in);
	public BinaryTree() {
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
	public void Display() {
		Display(root);
	}
	void Display(Node nn) {
		if (nn == null) {
			return;
		}
		String str = "<--" + nn.val + "-->";
		if (nn.left != null) {
			str = nn.left.val + str;
		}
		else {
			str = "." + str;
		}
		if (nn.right != null) {
			str = nn.right.val + str;
		}
	}
}
