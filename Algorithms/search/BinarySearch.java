
public class BinarySearch {
	
	public static int binarySearch(int[] A ,int left , int right, int value){		
		/*
		 * Below is the terminating condition for binary search.This is important.
		 */
		if(left > right){
			return -1;
		}
		int mid = (left + right)/2;
		if(A[mid] == value){
			return mid;
		}
		else{
			if(A[mid] > value){
				return binarySearch(A, left, mid-1, value);
			}
			else{
				return binarySearch(A, mid + 1, right, value);
			}				
		}
	}
	
	
	public static int binarySearchIterative(int[] A , int value){
		
		int left =0;
		int right = A.length-1;
		int mid;
		while(left <= right){
			mid = (left + right)/2;
			if(A[mid] == value){
				return mid;
			}
			if (A[mid] > value){
				right = mid -1;
			}
			else{
				left = mid +1;
			}
		}
		return -1;		
	}
	
	public static void main(String[] args){
		int  A[] = {1,3,7,9,11,15,17};
		
		int index  = binarySearch(A, 0, A.length-1 , 9);
		//int index  = binarySearchIterative(A, 1);
		
		if(index == -1) {
			System.out.println("Value not found in the array!");
		}
		else{
			System.out.println("Index : " + index + " Value :" + A[index] );
		}
		
		
		
	}
}
