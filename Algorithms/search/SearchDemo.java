
public class SearchDemo {

	public static void main(String[] args) {
		//int[] A = {2,5, 5, 5, 3, 2};
		//System.out.println(maxRepetitions(A));
		
		int[] A = {1, 2, 4, 5, 6, 3, 7};
		int n =8;
		System.out.println(findMissingNumber(A,n));
	}
	
	public static int maxRepetitions(int[] A){
		int i =0,max = 0, maxIndex=0 , n = A.length;
		
		for(i =0; i< n ; i++){
			A[A[i] % n] += n;
		}
		
		for (i = 0; i < n; i++) {
			if (A[i] / n > max) {
				max = A[i] / n;
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}
	
	/*
	 * Find missing number in an array of length n-1 where the elements are in the range 1-n.
	 * 
	 * Here the best approach is to use XOR as it will prevent overflow. We use the property of XOR that if we XOR the same
	 * number twice we will get 0. Thus the only number remaining here will be number which is missing.
	 * 
	 * e.g 10 XOR 5 = 15 ; 15 XOR 5 = 10 Thus we get 10 back.
	 * 
	 * XOR is basically an addition with carry.
	 */
	public static int findMissingNumber(int[] A , int n){
		int i, X=0 , Y=0;
		
		for(i =0;i< A.length ; i++){
			System.out.println("X= " + X + " A[i]= " + A[i]);
			X ^= A[i];
		}
		
		for (i = 1;i<= n; i++){
			Y ^= i; 
		}
		int missingNum = X ^ Y;
		return missingNum;
	}

}
