
public class LongestCommonSubsequence {

	public static void findLCS(String str1 , String str2){
		int m = str1.length();
		int n = str2.length();
		int[][] LCS = new int[m+1][n+1];
		
		for(int i =0; i<= m; i++){			
			for(int j =0;j<= n; j++){
				if(i == 0 || j == 0){
					LCS[i][j] = 0; //Initialize the first row and column to zero.
				}				
				else if(str1.charAt(i-1) == str2.charAt(j-1)){ // We should be careful with str1.charAt(i-1) as our loop is running one forward for the 
					LCS[i][j] = 1 + LCS[i-1][j-1];	 // initial extra zeroes that we have added.        
				}else{
					LCS[i][j] = Math.max(LCS[i-1][j],LCS[i][j-1]);
				}
			}
		}
		
		System.out.println(LCS[m][n]);
	}
	
	public static void main(String[] args) {
		findLCS("ABCDGH", "AEDFHR"); // 3 ADH
		findLCS("AGGTAB","GXTXAYB"); // GTAB 4

	}

}
