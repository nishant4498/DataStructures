
public class FibonacciIteration {	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n1 = 0, n2 =1;
		int count = 10; 
		
		System.out.print(n1 + " " + n2);
		
		for(int i=2;i < count;i++){
			int fib = n1+ n2;
			System.out.print(" " + fib);
			n1 = n2;
			n2= fib;
		}

	}

}
