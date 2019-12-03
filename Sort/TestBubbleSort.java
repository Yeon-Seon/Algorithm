package Sort_1123;

public class TestBubbleSort {
	
	public TestBubbleSort(){
		int[] a = IntArrays.randomInts(20, 100);
		IntArrays.print(a);
		System.out.println("sorted : " +IntArrays.isSorted(a));
		Bubblesort(a);
		IntArrays.print(a);
		System.out.println("sorted : " +IntArrays.isSorted(a));
	}
	
	void Bubblesort(int[] a){
		for(int i = a.length-1; i> 0; i--){
			for(int j = 0 ; j < i; j++){
				if(a[j] > a[j+1]){
					IntArrays.swap(a, j, j+1);
				}
			}
		}

	}
}
