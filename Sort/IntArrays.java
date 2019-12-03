package Sort_1123;

public class IntArrays {
	private static java.util.Random random = new java.util.Random();
	
	public static boolean isSorted(int[] a){
		
		for(int i =0; i <a.length-1; i++){
			if(a[i] > a[i+1])
				return false;
		}
		return true;
	}
	
	public static void print(int[] a ){
		for(int cnt : a)
			System.out.print(cnt + ", ");
		
	}
	public static int[] randomInts(int n, int range){
		int[] a = new int[n];
		if(n < 2)
			throw new IllegalArgumentException();
		for(int i =0; i < n; i++)
			a[i] = random.nextInt(range);
		return a;
	}
	
	public static void swap(int []a, int i, int j){
		int ai = a[i], aj = a[j];
		if(ai == aj)
			return;
		else{
			a[i] = aj;
			a[j] = ai;
		}
		
	}

}
