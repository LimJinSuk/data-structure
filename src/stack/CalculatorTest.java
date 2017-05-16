package stack;

public class CalculatorTest {

	public static void main(String[] args) {
		String exp = "( 1 + 2 ) * ( 3 / 4 ) + ( 5 + ( 6 - 7 ) )";
		
		Calculator clac = new Calculator();
		char temp='5';
		double d = temp-'0';
		System.out.println(d);
		System.out.println((double)temp);
		String y = Character.toString(temp);
		System.out.println(y);
		double post = Double.valueOf(y);
		System.out.println(post);
		
		double x=8.0;
		double z=0.5;
		double sum=x+z;
		String a=Double.toString(sum);
		System.out.println(a);
		//Double.parseDouble(s);
		
		
	}

}
