
public class FibonacciRecursion {

	public static int fib (int n){
		if(n == 1) return 0;
		if(n == 2) return 1;
		return fib(n-1) + fib(n-2);		
	}	
	
	public static void main(String[] args) {
		int n = 45;
		for(int i =1;i<=n; i++){
			System.out.print(" " + fib(i));
		}
	}
}


