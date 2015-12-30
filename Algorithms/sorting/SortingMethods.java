import java.util.Arrays;

public class SortingMethods {

	/*
	 * 1. One loop runs from the end to the beginning
	 * 2. 2nd loop runs from beginning to the pass swapping values on the way.
	 * After one iteration of Bubble sort the largest element is at the end of the array and this follows on.
	 */
	
	public void BubbleSort(int[] A){
		int pass, i, swapped = 1;
		for (pass = A.length-1; pass >= 0 && swapped == 1 ; pass-- ){
			swapped = 0;
			for(i=0; i<= pass-1 ; i++){
				if(A[i] > A[i+1]){
					swap(A,i,i+1);
					swapped = 1;
				}
			}
		}
	}
	
	public void swap(int[] A, int i , int j){
		int temp;
		temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	/*
	 * 1. Find the minimum value in the list.
	 * 2. Swap with the value at the current position(starting from index 0)
	 * 3. Repeat this for all the elements.
	 * 
	 * After one iteration of selection sort the smallest element is at the front of the array.
	 */
	
	public void SelectionSort(int[] A){
		int i, j, min;
		for(i=0;i < A.length-1 ; i++){
			min = i;
			for(j =i+1; j < A.length; j++){
				if(A[j] < A[min]){
					min = j;
				}
			}
			swap(A, i, min);		
			
		}
		
	}
	
	/*
	 * Demo at https://www.youtube.com/watch?v=DFG-XuyPYUQ
	 */
	
	public void InsertionSort(int[] A){
		int curr, i , j;
		for(i=2;i<=A.length-1;i++){
			curr = A[i];
			j = i;
			while(A[j-1] > curr && j >= 1){
				A[j] = A[j-1];
				j--;
			}
			A[j] = curr;
		}
		
	}

	public static void main(String[] args) {
		
		int[] sampleArray = {25,2,5,1500,2,90,1,16,76};
		SortingMethods sm = new SortingMethods();
		System.out.println(Arrays.toString(sampleArray));
		//sm.BubbleSort(sampleArray);
		sm.SelectionSort(sampleArray);
		//sm.InsertionSort(sampleArray);
		System.out.println(Arrays.toString(sampleArray));	

	}

}
