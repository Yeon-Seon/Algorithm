package BinarySearchTree_1019;

// Start of Binary Tree
class BinaryTree {
	
	BinaryTree llink;
	BinaryTree btree;
	Object data;
	BinaryTree rlink;

	public BinaryTree() {
		llink = null;
		data = null;
		rlink = null;
		// 생성자
	}

	public BinaryTree(Object data) {
		this.llink = null;
		this.data = data;
		this.rlink = null;
		// 생성자
	}

	public BinaryTree(BinaryTree llink, Object data, BinaryTree rlink) {
		this.llink = llink;
		this.data = data;
		this.rlink = rlink;
		// 생성자
	}

	public boolean isEmpty(BinaryTree btree) {
		if (btree == null) {
			return true;
		} else {
			return false;
		}
		// 비었는지검사
	}

	public BinaryTree leftSubTree(BinaryTree btree) {
		if (isEmpty(btree) == true) {
			return null;
		} else {
			return btree.llink;
		}
		// 왼쪽 서브 반환
	}

	public BinaryTree rightSubTree(BinaryTree btree) {
		if (isEmpty(btree) == true) {
			return null;
		} else {
			return btree.rlink;
		}
		// 오른쪽 서브 반환
	}

	public Object rootData(BinaryTree btree) {
		if (isEmpty(btree) == true) {
			return null;
		} else {
			return btree.data;
		}
		// 루트 데이타 반환
	}

	public void inorder(BinaryTree btree) {
		if (btree == null)
			return;

		inorder(btree.llink);
		System.out.print(btree.data + " ");
		inorder(btree.rlink);
	} // End of inorder

	public void preorder(BinaryTree btree) {
		if (btree == null)
			return;

		System.out.print(btree.data + " ");
		preorder(btree.llink);
		preorder(btree.rlink);

	} // End of Preorder

	public void postorder(BinaryTree btree) {
		if (btree == null)
			return;

		postorder(btree.llink);
		postorder(btree.rlink);
		System.out.print(btree.data + " ");
	} // end of inorder

	

	// ////////////////////////////////////////////////////////////////
	// 이진 탐색트리 //
	// ////////////////////////////////////////////////////////////////
	private BinaryTree insertKey(BinaryTree T, String x) {
		// 공백노드일시 최상위 노드에 삽입
		if (isEmpty(T)) {
			BinaryTree newNode = new BinaryTree(null,x,null);
			
			// 빈칸25: 왼쪽, 오른쪽 링크는 null로 데이터는 x인 이진트리 생성
			return newNode;
			// 빈칸26: 이진트리 반환
		}
		// 입력된 문자열이 data보다 작으면 왼쪽 링크에 삽입
		else if (x.compareTo((String) T.data) < 0) {
			T.llink = insertKey(T.llink, x);
			// 빈칸27: 왼쪽 링크에 다시 insertKey를 사용하여 반환값 저장
			return T;
		}
		// 입력된 문자열이 data보다 크면면 오른쪽 링크에 삽입
		else if (x.compareTo((String) T.data) > 0) {
			T.rlink = insertKey(T.rlink, x);
			// 빈칸28: 오른쪽 링크에 다시 insertKey를 사용하여 반환값 저장
			return T;
		} 
		else {
			return T;
		}
	}

	public void insert(String x) {
		btree = insertKey(btree, x);
	}

	public BinaryTree find(String x) {
		BinaryTree T = btree;
		int result;

		while (T != null) {
			// 비교를 해서 data보다 작음으로 왼쪽 링크를 쫒아감.
			if ((result = x.compareTo((String) T.data)) < 0) {
				T = T.llink;
				// 빈칸29: 왼쪽 링크 쫓아감
			}
			// 비교를 해서 data와 같으므로 검색된 data를 반환함.
			else if (result == 0) {
				return T;
			}
			// 비교를 해서 data보다 큼으로 오른쪽 링크를 쫒아감.
			else {
				T = T.rlink;
				// 빈칸30: 오른쪽 링크 쫓아감
			}
		}
		return T;
	}
	
	void printNode(BinaryTree T)
	{
		if(T != null)
		{
			System.out.print("(");
			printNode(T.llink);
			System.out.print(T.data);
			printNode(T.rlink);
			System.out.print(")");
		}
	}
	public void printBST()
	{
		printNode(btree);
		System.out.println();
	}
	
	public void deleteKey(String key)
	{
		BinaryTree current = btree;
		BinaryTree parent = current;
		
		while (current.data != key) {

			parent = current;
			if(key.compareTo((String)current.data)<0)
			{
				current = current.llink;
			}
			else
			{
				current = current.rlink;
			}
		}
		if(current.llink == null && current.rlink == null)
		{
			if(current == btree)
				btree = null;
			else if (current == parent.llink)
				parent.llink = null;
			else
				current = null;
		}
		else if(current.rlink == null)
		{
			if(current == btree)
				btree = current.llink;
			else if(current == parent.llink)
				parent.llink = current.llink;
			else
				parent.rlink = current.llink;
		}
		
		else if(current.llink == null)
		{
			if(current == btree)
				btree = current.rlink;
			else if(current == parent.llink)
				parent.llink = current.rlink;
			else
				parent.rlink = current.rlink;
		}
		else
		{
			BinaryTree Min = MinNode(current);
			if(current == btree)
				btree = Min;
			else if(current == parent.llink)
				parent.llink = Min;
			else
				parent.rlink = Min;
			Min.llink = current.llink;
		}
		
				
	}
	private BinaryTree MinNode(BinaryTree deleteTree)
	{
		BinaryTree MinParent = null;
		BinaryTree Min = null;
		BinaryTree current = deleteTree.rlink;
		
		while(current != null)
		{
				MinParent = Min;
				Min = current;
				current = current.llink;
				
		}
		if(Min != deleteTree.rlink) //오른쪽 자식만 있을때
		{
			MinParent.llink = Min.rlink;
			Min.rlink = deleteTree.rlink;
		}
		return Min;
	}
	
} // end of BinaryTree class
