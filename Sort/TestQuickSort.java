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
		//피봇을 기준으로 왼쪽은 작은값, 오른쪽은 큰값으로 정렬 --> 사이드는 정렬되지 않았기 때문에 다시 각각 정렬해줘야됨 
		
		if (p < q) {
			int r;
			r = partition(a, p, q);	//r은 피봇
			Quicksort(a, p, r-1);
			Quicksort(a, r, q);
		}
	}

	int partition(int[] a, int p, int q) {
		int t = a[q]; // 피봇 -> ppt의 15
		int i = p - 1; //p의 전에 i위치
		for (int j = p; j < q; j++) {	//p부터 j가 하나씩 넘어가면서 비교
			if (a[j] <= t)
				IntArrays.swap(a, ++i, j);	//t보다 값이 작으면 i를 하나 늘려서 그자리랑 값교환
		}
		IntArrays.swap(a, i + 1, q);	//피봇을 i(피봇보다 작은 값들을 모아놓은 위치)다음 위치로 옮겨줌
		//여기까지하면 피봇 t를 기준으로 왼쪽에는 작은값, 오른쪽에는 큰값들이 들어가 있게 됨 
		return i + 1;	//피봇의 위치를 반환해줌
	}

}
