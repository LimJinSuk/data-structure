package recursion;

public class FibonacciTest {
	public static int countofCall=0;

	public static void main(String[] args) {
		for(int i=0; i<=12; i++){
			System.out.print(fibonacci(i)+" : "+countofCall);
		}
	}
	public static int fibonacciLoop(int n){
		return 0;
	}
	
	public static int fibonacci(int n){
		countofCall++;
		
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		return fibonacci(n-1)+fibonacci(n-2);
	}
}
