
public class MergeSortDemo {

	private int[] myArray;
	private int[] tempArray;
	int length;	
	
	public static void main(String[] args) {
		int[] inputArray = {45,23,11,89,77,98,4,28,65,43};
		MergeSortDemo msd = new MergeSortDemo();
		msd.sort(inputArray);
	}
	
	public void sort(int[] inputArray){
		this.myArray = inputArray;
		this.length = inputArray.length;
		this.tempArray = new int[length];
		for(int i: myArray){
			System.out.print(i + " ");
		}
		System.out.println();
		MergeSort(0,length-1);
		for(int i: myArray){
			System.out.print(i + " ");
		}
		
	}
	
	public void MergeSort(int left , int right){
		if(left < right){
			//int mid = ( left + right )/2;
			int mid = left + (right - left) / 2;// To avoid overflow
			MergeSort(left, mid);
			MergeSort(mid+1, right);
			MergeParts(left,mid,right);			
		}		
	}
	
	public void MergeParts(int left , int mid , int right){
		/*
		 * This copies only the section being merged into the temporary array.
		 */		
		for(int i= left;i<=right;i++){
			tempArray[i] = myArray[i];
		}
		
		int i = left , j = mid+1;
		int k = left;
		
		
		while(i <= mid && j<= right){
			if(tempArray[i] < tempArray[j]){
				myArray[k] = tempArray[i];
				i++;
				k++;
			}else{
				myArray[k] = tempArray[j];
				j++;
				k++;
			}
		}
		
		while(i<= mid){
			myArray[k] = tempArray[i];
			i++;
			k++;
		}
		
		while(j<= right){
			myArray[k] = tempArray[j];
			j++;
			k++;
		}		
	}

}
