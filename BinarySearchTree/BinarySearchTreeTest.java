package BinarySearchTree_1019;

public class BinarySearchTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree T = new BinaryTree();
		
		T.insert("S");
		T.insert("J");
		T.insert("D");
		T.insert("G");
		T.insert("U");
		T.insert("M");
		T.insert("R");
		T.insert("Q");
		T.insert("A");
		T.insert("I");
		T.insert("H");
		T.insert("F");
		T.insert("E");
		/*
		T.insert("A");
		T.insert("K");
		T.insert("Y");
		
		*/
		// 구축된 BST를 프린트
		System.out.println(" The Tree is:");
		T.printBST();
		System.out.println();
		
		T.deleteKey("D");
		T.printBST();
	}
}
