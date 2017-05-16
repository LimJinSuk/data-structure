package stack;

public class StackTest {

	public static void main(String[] args) {
		try {
			Stack<String> stack = new Stack<String>();
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			stack.push("java");
			stack.push(".");

			while (stack.empty() == false) {// 빈스택 아닐경우 다 빼냄
				String s = stack.pop();
				System.out.println(s);
			}

			System.out.println("======================================");

			stack = new Stack<String>();// 스택 하나 더만듦
			stack.push("Hello");

			System.out.println(stack.pop());
			System.out.println(stack.pop());
		}
		catch(StackException e){
			System.out.println(e);
		}

	}

}
