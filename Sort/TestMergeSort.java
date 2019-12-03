package Sort_1123;

public class TestMergeSort {
	public TestMergeSort(){
		int[] a = IntArrays.randomInts(20, 100);
		IntArrays.print(a);
		System.out.println("sorted : " +IntArrays.isSorted(a));
		Mergesort(a, 0, a.length-1);
		IntArrays.print(a);
		System.out.println("sorted : " +IntArrays.isSorted(a));
	}
	//�պ� ���� -> ����Ʈ�� L,R �̵���Ͽ� ���� ������ �� �迭 S�� ���� ���Ҹ� ÷���Ͽ� ����
	void Mergesort(int[] a, int p, int q){
		if(p < q){
			int middle = (p+q)/2;	//����� ������ ������
			Mergesort(a, p, middle); //���� ����(L)
			Mergesort(a, middle+1, q);	//������ ����(R)
			merge(a, p, middle, middle+1, q);	//(S)
		}
	}
	
	void merge(int[] a, int p, int m, int n, int q){
		int t = p;
//		int n = m+1;
		int temp[] = new int[a.length];	//�ӽ� �迭 S
		int numElements = q-p+1;	//�迭 ũ�� ���� ����
		
		while(p <= m && n <= q){	
			if(a[p] < a[n])
				temp[t++] = a[p++];	
			else 
				temp[t++] = a[n++];
		}
		
		while(p <= m)	//L�迭�� ���Ұ� �����ִ� ���
			temp[t++] = a[p++];
		while(n <= q)	//R�迭�� ���Ұ� �����ִ� ���
			temp[t++] = a[n++];
		
		for(int i = 0; i < numElements; i++, q--)	
			a[q] = temp[q];
	}
	
}
