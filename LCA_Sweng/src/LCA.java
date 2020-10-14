//Java implementation to find lowest common ancestor of 
// n1 and n2 using one traversal of binary tree 

public class LCA 
{ 
	public static void main(String args[]) 
	{ 
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(6); 
		tree.root.right.right = new Node(7); 
		System.out.println("LCA(4, 5) = " + 
							tree.findLCA(4, 5).data); 
		System.out.println("LCA(4, 6) = " + 
							tree.findLCA(4, 6).data); 
		System.out.println("LCA(3, 4) = " + 
							tree.findLCA(3, 4).data); 
		System.out.println("LCA(2, 4) = " + 
							tree.findLCA(2, 4).data); 
	} 
} 


