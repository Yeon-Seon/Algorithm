package Task1_BinaryTree;

class BinaryTree {
	BinaryTree ltree;
	// BinaryTree btree;
	Object data;
	BinaryTree rtree;

	public BinaryTree() {
		ltree = null;
		data = null;
		rtree = null;
		// 생성자
	}

	public BinaryTree(BinaryTree ltree, Object data, BinaryTree rtree) {
		this.ltree = ltree;
		this.data = data;
		this.rtree = rtree;
		// 생성자
	}

	public boolean isEmpty(BinaryTree btree) {
		if (btree == null)
			return true;
		else
			return false;
		// 비었는지검사
	} // End of isEmpty

	public BinaryTree leftSubTree(BinaryTree btree) {
		if (isEmpty(btree) == true)
			return null;
		else
			return btree.ltree;
		// 왼쪽 서브 반환
	} // End of leftSubTree

	public BinaryTree rightSubTree(BinaryTree btree) {
		if (isEmpty(btree) == true)
			return null;
		else
			return btree.rtree;
		// 오른쪽 서브 반환
	} // End of rightSubTree

	public Object rootData(BinaryTree btree) {
		if (isEmpty(btree) == true)
			return null;
		else
			return btree.data;
		// 루트 데이타 반환
	} // End of rootData

	public void inorder(BinaryTree btree) {
		if (btree.data == null)
			return;

		inorder(btree.ltree);
		System.out.print(btree.data + " ");
		inorder(btree.rtree);
	} // End of inorder

	public void preorder(BinaryTree btree) {
		if (btree.data == null)
			return;

		System.out.print(btree.data + " ");
		preorder(btree.ltree);
		preorder(btree.rtree);
	} // End of Preorder

	public void postorder(BinaryTree btree) {
		if (btree.data == null)
			return;

		postorder(btree.ltree);
		postorder(btree.rtree);
		System.out.print(btree.data + " ");
	} // End of PostOrder
} // End of Class BinaryTree
