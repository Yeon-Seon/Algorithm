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
		// ���� �Ϸ�

		ltree = new BinaryTree(new BinaryTree(), "E", new BinaryTree());
		rtree = new BinaryTree(new BinaryTree(), "F", new BinaryTree());
		btree = new BinaryTree(ltree, "D", rtree);
		// ������ �Ϸ�

		ltree = current;
		rtree = btree;
		btree = new BinaryTree(ltree, "A", rtree);
		// ���� ������ ������!

		// inorder traversing
		System.out.println("\n���� ����Ʈ�� ��ȸ :");
		btree.inorder(btree);

		// preorder traversing
		System.out.println("\n���� ����Ʈ�� ��ȸ :");
		btree.preorder(btree);

		// postorder traversing
		System.out.println("\n���� ����Ʈ�� ��ȸ :");
		btree.postorder(btree);

		// Test of ArrayQueue
		BinaryTree pointer;
		System.out.println("\n���� ����Ʈ�� ��ȸ :");

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
