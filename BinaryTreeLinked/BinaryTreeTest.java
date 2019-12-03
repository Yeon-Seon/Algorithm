package BinaryTreeLinked_0921;
//9�� 21�� �ǽ��� 28�� ��Ÿ���� �ǽ� �߰��ڵ�

public class BinaryTreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree btree;
		BinaryTree ltree;
		BinaryTree rtree;
		BinaryTree current;
		BinaryTree ntree;

		// ltree = new BinaryTree(new BinaryTree(), "B", new BinaryTree());
		// rtree = new BinaryTree(new BinaryTree(), "C", new BinaryTree());
		// btree = new BinaryTree(ltree, "A", rtree);

		rtree = new BinaryTree(new BinaryTree(), "H", new BinaryTree());
		btree = new BinaryTree(new BinaryTree(), "G", rtree);

		ltree = btree;
		btree = new BinaryTree(ltree, "E", new BinaryTree());

		ltree = new BinaryTree(new BinaryTree(), "D", new BinaryTree());
		rtree = btree;
		btree = new BinaryTree(ltree, "B", rtree);

		ltree = new BinaryTree(new BinaryTree(), "F", new BinaryTree());
		current = new BinaryTree(ltree, "C", new BinaryTree());

		ltree = btree;
		rtree = current;
		btree = new BinaryTree(ltree, "A", rtree);

		// inorder
		System.out.println("The order of inorder traversing");
		btree.inorder(btree);
		System.out.println();

		BinaryTree ctree = new BinaryTree();
		System.out.println("Ʈ�� ����");
		ctree = ctree.copy(btree);
		ctree.inorder(ctree);

		System.out.println();
		//
		// // preorder
		// System.out.println("The order of preorder traversing");
		// btree.preorder(btree);
		// System.out.println();
		//
		// // postorder
		// System.out.println("The order of postorder traversing");
		// btree.postorder(btree);

		ltree = new BinaryTree(new BinaryTree(), "E", new BinaryTree());
		rtree = new BinaryTree(new BinaryTree(), "F", new BinaryTree());
		ntree = new BinaryTree(ltree, "C", rtree);

		ltree = new BinaryTree(new BinaryTree(), "D", new BinaryTree());
		current = new BinaryTree(ltree, "B", new BinaryTree());

		ltree = current;
		rtree = ntree;
		ntree = new BinaryTree(ltree, "A", rtree);

		System.out.println("���ο� Ʈ�� : ntree ��ȸ��ȸ");
		ntree.inorder(ntree);
		System.out.println("\n��� �� btree & ctree");
		System.out.println(btree.equal(btree, ctree));
		System.out.println("��� �� btree & ntree");
		System.out.println(btree.equal(btree, ntree));

		System.out.println("isLeaf() : " + btree.isLeaf());

		System.out.println("btree contains()");
		System.out.println("A����?" + btree.contains("A"));
		System.out.println("K����?" + btree.contains("H"));

	}

}
