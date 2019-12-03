package Sort_1123;

public class TestQuickSort {
	public TestQuickSort() {
		int[] a = IntArrays.randomInts(20, 100);
		IntArrays.print(a);
		System.out.println("sorted : " + IntArrays.isSorted(a));
		Quicksort(a, 0, a.length - 1);
		IntArrays.print(a);
		System.out.println("sorted : " + IntArrays.isSorted(a));
	}

	void Quicksort(int[] a, int p, int q) {
		//�Ǻ��� �������� ������ ������, �������� ū������ ���� --> ���̵�� ���ĵ��� �ʾұ� ������ �ٽ� ���� ��������ߵ� 
		
		if (p < q) {
			int r;
			r = partition(a, p, q);	//r�� �Ǻ�
			Quicksort(a, p, r-1);
			Quicksort(a, r, q);
		}
	}

	int partition(int[] a, int p, int q) {
		int t = a[q]; // �Ǻ� -> ppt�� 15
		int i = p - 1; //p�� ���� i��ġ
		for (int j = p; j < q; j++) {	//p���� j�� �ϳ��� �Ѿ�鼭 ��
			if (a[j] <= t)
				IntArrays.swap(a, ++i, j);	//t���� ���� ������ i�� �ϳ� �÷��� ���ڸ��� ����ȯ
		}
		IntArrays.swap(a, i + 1, q);	//�Ǻ��� i(�Ǻ����� ���� ������ ��Ƴ��� ��ġ)���� ��ġ�� �Ű���
		//��������ϸ� �Ǻ� t�� �������� ���ʿ��� ������, �����ʿ��� ū������ �� �ְ� �� 
		return i + 1;	//�Ǻ��� ��ġ�� ��ȯ����
	}

}
