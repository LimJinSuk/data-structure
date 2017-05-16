package stack;

public class Calculator{
	private static Stack<Character> stack=null;
	public static int pos;
	public static String postfix;

	public static void main(String[] args) throws StackException {
		String exp = "( 1 + 2 ) * ( 3 / 4 ) + ( 5 + ( 6 - 7 ) )";
		
		//모든 " "띄어쓰기를 ""으로 대체 : 공백 없애기
		//공백을 없앤 식을 후위표기식으로 바꿈
		System.out.println(exp.replaceAll(" ", ""));
		String postfix=toPostfix(exp.replaceAll(" ", ""));
		
		System.out.println(postfix);
		
		calculate(postfix);
	}
	
	public static String toPostfix(String infix) throws StackException{
		stack = new Stack<Character>(); //빈스택 생성
		
		postfix = ""; //초기값 설정
		
		for(int i=0; i<infix.length(); i++){
			//식의 문자 하나하나 배열로 나눠 저장할 것
			char c = infix.charAt(i);//포문없이 배열만들어서 하면 어때? .tocharArray()이용해서
			//( 1 + 2 ) * ( 3 / 4 ) + ( 5 + ( 6 - 7 ) )
			
			if(stack==null)
				stack.push(c);
			//연산자 스택에 집어넣어야 해 
			
			switch(c){
				case'+':
				case'-': 
					pos=0;
					stackcal(c,pos);
					break;
				case'*':
				case'/':
					pos=1;
					stackcal(c,pos);
					break;
				case'('://우선순위에 상관없이 바로 스택에 삽입
					stack.push(c);
					break;
				case')'://우선순위 상관없이 pop해야함
					getParen(c);
					break;
				default://피연산자의 경우
					postfix=postfix+c;
			}
		}
		while(!stack.empty())
			postfix+=stack.pop();
		return postfix;
	}
	
	//push 경우 스택내 우선순위 
	public static void stackcal(char c,int pos) throws StackException {
		while(!stack.empty()){
				int pos2;
				//스택내 맨위 원소 꺼내서 지금 넣을 것과 비교
				char a = stack.pop();
				
				if(a=='('){//여는 괄호의 경우 
					stack.push(a);//꺼낸 괄호 다시 넣어주기
					break;
				}
				else{
					if(a=='+'||a=='-')
						pos2=0;
					else
						pos2=1;
					
					if(pos>pos2){//새로 들어갈 것이 큰경우만 뽑은거 다시 넣음
						stack.push(a);
						break;
					}
					else
						postfix=postfix+a;
				}
				//스택내 모든 우선순위 정렬 끝난 후 삽입 가능
				
			}
		stack.push(c);
		}
	
	

	//pop경우 
	public static void getParen(char c) throws StackException{
		while(!stack.empty()){//(나올때까지 반복 하며 pop
			char a = stack.pop();
			if(a=='(')
				break;//(는 사라짐
			else
				postfix+=a;
		}		
	}
	
	public static void calculate(String postfix) throws StackException{
		
		double pre=0;
		double post=0;
		
		for(int i=0; i<postfix.length(); i++){
			char exp = postfix.charAt(i);
			
			stack = new Stack<Character>();
			
			if(stack.empty())
				stack.push(exp);
			else{
				num();
				//System.out.println(post);
				switch(exp){
					case'+':
						exp=(char) (pre+post);
						break;
					case'-':
						exp=(char) (pre-post);
						break;
					case'*':
						exp=(char) (pre*post);
						break;
					case'/':
						exp=(char) (pre/post);
						break;
					
				}
				stack.push(exp);
			}
			
		}
		
		System.out.println("= "+stack.pop());
		
	}
	public static void num() throws StackException{
		char temp =stack.pop();
		//System.out.println(temp);
		if(stack.empty())			
			stack.push(temp);
		
		else{
			double post = temp-'0';
			System.out.println(post);
			double pre = stack.pop()-'0';
			System.out.println(pre);
		}
	}
}
