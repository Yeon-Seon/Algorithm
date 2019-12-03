package Sort_1123;

public class TestSelectSort {
	
	public TestSelectSort(){
		int[] a = IntArrays.randomInts(20, 100);
		IntArrays.print(a);
		System.out.println("\n sorted : " +IntArrays.isSorted(a));
		Selectionsort(a);
		IntArrays.print(a);
		System.out.println("\n sorted : " +IntArrays.isSorted(a));
	}
	
	void Selectionsort(int[] a ){
		int i, j, min;
		for(i = 0; i < a.length - 1; i++){
			for(j = i+1, min = i; j < a.length; j++){
				if(a[j] < a[min]){
					min = j;
				}
			}
			IntArrays.swap(a, i, min);
		}
	}
}
