import java.util.Arrays;

public class SortingMethods {

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
		
		int[] sampleArray = {1,2,5,1500,2,90,16,76};
		SortingMethods sm = new SortingMethods();
		System.out.println(Arrays.toString(sampleArray));
		//sm.BubbleSort(sampleArray);
		//sm.SelectionSort(sampleArray);
		sm.InsertionSort(sampleArray);
		System.out.println(Arrays.toString(sampleArray));	

	}

}
