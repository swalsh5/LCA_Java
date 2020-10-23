import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LCATests {

	@Test
	void testLCA() {
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(6); 
		tree.root.right.right = new Node(7); 
		
		assertEquals(2, tree.findLCA(4, 5).data);
		assertEquals(1, tree.findLCA(4, 6).data);
		assertEquals(1, tree.findLCA(3, 4).data);
		assertEquals(2, tree.findLCA(2, 4).data);
		assertEquals(1, tree.findLCA(6, 1).data);
	}

}
