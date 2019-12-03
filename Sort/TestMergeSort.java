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
	//합병 정렬 -> 리스트를 L,R 이등분하여 각자 정렬한 뒤 배열 S에 작은 원소를 첨가하여 정렬
	void Mergesort(int[] a, int p, int q){
		if(p < q){
			int middle = (p+q)/2;	//가운대 값으로 나눠줌
			Mergesort(a, p, middle); //왼쪽 정렬(L)
			Mergesort(a, middle+1, q);	//오른쪽 정렬(R)
			merge(a, p, middle, middle+1, q);	//(S)
		}
	}
	
	void merge(int[] a, int p, int m, int n, int q){
		int t = p;
//		int n = m+1;
		int temp[] = new int[a.length];	//임시 배열 S
		int numElements = q-p+1;	//배열 크기 저장 변수
		
		while(p <= m && n <= q){	
			if(a[p] < a[n])
				temp[t++] = a[p++];	
			else 
				temp[t++] = a[n++];
		}
		
		while(p <= m)	//L배열에 원소가 남아있는 경우
			temp[t++] = a[p++];
		while(n <= q)	//R배열에 원소가 남아있는 경우
			temp[t++] = a[n++];
		
		for(int i = 0; i < numElements; i++, q--)	
			a[q] = temp[q];
	}
	
}
