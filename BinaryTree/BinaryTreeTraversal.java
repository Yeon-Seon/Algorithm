package Task1_BinaryTree;

class BinaryTreeTraversal {
	public static void main(String args[]) {
		BinaryTree btree;
		BinaryTree ltree;
		BinaryTree rtree;
		BinaryTree current;

		ltree = new BinaryTree(new BinaryTree(), "B", new BinaryTree());
		rtree = new BinaryTree(new BinaryTree(), "D", new BinaryTree());
		btree = new BinaryTree(ltree, "A", rtree);

		ltree = new BinaryTree(new BinaryTree(), "C", new BinaryTree());
		current = new BinaryTree(ltree, "B", new BinaryTree());
		// 왼쪽 완료

		ltree = new BinaryTree(new BinaryTree(), "E", new BinaryTree());
		rtree = new BinaryTree(new BinaryTree(), "F", new BinaryTree());
		btree = new BinaryTree(ltree, "D", rtree);
		// 오른쪽 완료

		ltree = current;
		rtree = btree;
		btree = new BinaryTree(ltree, "A", rtree);
		// 왼쪽 오른쪽 이으기!

		// inorder traversing
		System.out.println("\n중위 이진트리 순회 :");
		btree.inorder(btree);

		// preorder traversing
		System.out.println("\n전위 이진트리 순회 :");
		btree.preorder(btree);

		// postorder traversing
		System.out.println("\n후위 이진트리 순회 :");
		btree.postorder(btree);

		// Test of ArrayQueue
		BinaryTree pointer;
		System.out.println("\n레벨 이진트리 순회 :");

		ArrayQueue Q = new ArrayQueue();
		// BinaryTree current;
		Q.enqueue(btree);
		//
		
		
		while (!Q.isEmpty()) {
			current = (BinaryTree) Q.dequeue();
			if(current.data != null)
			System.out.print(current.data + " ");
			
			if (current.ltree != null ){
				Q.enqueue(current.ltree);
		
			}
			if (current.rtree != null ){
				Q.enqueue(current.rtree);
		
			}

		}
		Q = (ArrayQueue) Q.dequeue();
	}

}
