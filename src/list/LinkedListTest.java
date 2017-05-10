package list;

public class LinkedListTest {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		
		//add 연산
		list.add(11);
		list.add(22);
		list.add(22);
		list.add(33);
		list.add(44);
		list.add(44);
		
		//size 연산
		//length : 배열의 전체 크기
		//size : 실제 사용하는 데이터의 크기
		int count=list.size();
		System.out.println("list 크기 : "+count);
		
		//get 연산
		for(int i=0; i<count; i++)
			System.out.println(i+"번째 항목 : "+list.get(i));
		
		System.out.println("--------------------------");
		//removeAll 테스트
		list.removeAll();
		//list.add(2,00);
		
		//add
		list.add(33);
		list.add(44);
		list.add(55);
		list.add(66);
		list.add(77);
	
		list.add(0,11);	
		list.add(2,00);
				
		count=list.size();
		System.out.println("list 크기 : "+count);
		for(int i=0; i<count; i++)
			System.out.println(i+"번째 항목 : "+list.get(i));
		
		
		System.out.println("--------------------------");
		
		//remove test
				
		System.out.println("삭제 항목 : "+list.remove(0));
		//System.out.println("삭제 항목 : "+list.remove(4));
		System.out.println("삭제 항목 : "+list.remove(4));
		
		count=list.size();
		System.out.println("list 크기 : "+count);
		for(int i=0; i<count; i++){
			System.out.println(i+"번째 항목 : "+list.get(i));
		}
		
		System.out.println("-----예외 테스트------");
		//예외 테스트
		try{
			System.out.println(list.get(0));
		}catch(IndexOutOfBoundsException e){
			e.printStackTrace();
		}
		
	}

}
