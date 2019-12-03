package BinaryTreeLinked_0921;
//9�� 21�� �ǽ��� 28�� ��Ÿ���� �ǽ� �߰��ڵ�

public class BinaryTree {

	BinaryTree ltree;
	Object data;
	BinaryTree rtree;

	public BinaryTree() {
		ltree = null;
		data = null;
		rtree = null;
	}

	public BinaryTree(BinaryTree ltree, Object data, BinaryTree rtree) {
		this.ltree = ltree;
		this.data = data;
		this.rtree = rtree;
	}

	public boolean isEmpty(BinaryTree btree) {
		if (btree == null)
			return true;
		else
			return false;
	}

	public BinaryTree leftSubTree(BinaryTree btree) {
		if (isEmpty(btree) == true)
			return null;
		else
			return btree.ltree;
	}

	public BinaryTree rightSubtree(BinaryTree btree) {
		if (isEmpty(btree) == true)
			return null;
		else
			return btree.rtree;
	}

	public Object rootData(BinaryTree btree) {
		if (isEmpty(btree) == true)
			return null;
		else
			return btree.data;
	}

	public void inorder(BinaryTree btree) { // ������ȸ
		if (btree.data == null)
			return;
		inorder(btree.ltree); // ����Լ�
		System.out.print(btree.data + " ");
		inorder(btree.rtree);
	}

	public void preorder(BinaryTree btree) { // ������ȸ
		if (btree.data == null)
			return;
		System.out.print(btree.data + " ");
		preorder(btree.ltree);
		preorder(btree.rtree);
	}

	public void postorder(BinaryTree btree) {
		if (btree.data == null)
			return;
		postorder(btree.ltree);
		postorder(btree.rtree);
		System.out.print(btree.data + " ");
	}

	public BinaryTree copy(BinaryTree btree) { // Ʈ�� ����
		BinaryTree Stree; // ���������ϴ� Ʈ��
		BinaryTree ltree;
		BinaryTree rTree;

		Stree = new BinaryTree();
		if (btree.data != null) {
			ltree = copy(btree.ltree);
			rtree = copy(btree.rtree);
			Stree = new BinaryTree(ltree, btree.data, rtree);
		}

		return Stree;
	}

	public boolean equal(BinaryTree btree, BinaryTree ctree) { // ��� �� �޼ҵ�
		boolean ans;
		ans = false;

		if ((btree.data == null) && (ctree.data == null)) // �Ѵ� ������� true
			ans = true;

		else if ((btree.data != null) && (ctree.data != null)) {
			if (btree.data == ctree.data)
				ans = equal(btree.ltree, ctree.ltree);
			if (ans)
				ans = equal(btree.rtree, ctree.rtree);
		}
		return ans;
	}

	public boolean isLeaf() { // �ܸ�������� �˻�
		return ltree == null && rtree == null;
	}

	public boolean contains(Object object) {

		if (this.data == object)
			return true;
		// if(this.ltree != null && ltree.contains(object)){
		// return true;
		// }
		if (this.ltree != null && this.rtree != null) {
			if (ltree.contains(object))
				return true;
			if (rtree.contains(object))
				return true;
		}

		return false;
	}

}
