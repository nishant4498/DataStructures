import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void findLISLength(int[] input){
		int length = input.length;
		int maxLength = 0;
		
		int[] LIS = new int[length];
		
		for(int i=0; i< length; i++){
			LIS[i] = 1; // Initialize the length of LIS at each position to one
		}
		
		/*
		 * LIS(i) = { 1 + Max ( LIS(j) ) } where j < i and input[j] < input[i] and if there is no such j then LIS(i) = 1
		 */
		
		for(int i=1; i< length;i++){
			for(int j=0; j<i; j++){				
				if(input[i] > input[j] && LIS[i] < 1 + LIS[j]){
					LIS[i] = 1 + LIS[j];
				}				
			}
			System.out.println(Arrays.toString(LIS));
		}		
		
		for(int i=0; i< length; i++){
			if(maxLength < LIS[i]){
				maxLength = LIS[i];
			}
		}
		System.out.println("Longest Increasing Subsequence Length: "+ maxLength);
	}
	
	
	public static void main(String[] args) {
		int[] input = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		findLISLength(input);
	}

}
