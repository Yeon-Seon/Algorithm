package Sort_1123;

public class TestInsertionSort {

	public TestInsertionSort() {
		int[] a = IntArrays.randomInts(20, 100);
		IntArrays.print(a);
		System.out.println("sorted : " + IntArrays.isSorted(a));
		Insertionsort(a);
		IntArrays.print(a);
		System.out.println("sorted : " + IntArrays.isSorted(a));
	}

	void Insertionsort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j = i; 
			while (j > 0 && temp < a[j - 1]) {
				IntArrays.swap(a, j, j - 1);
				j--;
			}
		}
	}

}
