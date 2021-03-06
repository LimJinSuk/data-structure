package list;

import java.util.Arrays;

public class ArrayListTest {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		
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
		
		
		System.out.println("-----------------------");
		
		//removeAll 테스트
		list.removeAll();
		System.out.println(Arrays.toString(list.toArray()));
		
		list.add(33);
		list.add(44);
		list.add(55);
		list.add(66);
		list.add(77);
	
		list.add(0,11);	
		list.add(6,00);
		
		count=list.size();
		System.out.println("list 크기 : "+count);
		for(int i=0; i<count; i++)
			System.out.println(i+"번째 항목 : "+list.get(i));
		
		System.out.println("-----------------------");
		
		System.out.println("삭제 항목 : "+list.remove(0));
		System.out.println("삭제 항목 : "+list.remove(2));
		
		count=list.size();
		System.out.println("list 크기 : "+count);
		for(int i=0; i<count; i++)
			System.out.println(i+"번째 항목 : "+list.get(i));
		
		//foreach문을 사용하기 위한 컬렉션 객체는
		//java.lang.iterable 인터페이스를 구해야 한다
		//for(in ti=0; i<count; i++)
		// 		System.out.println();
		
		
		//Iterator 반복자를 통한 리스트 순회
				
		
		
		//예외 테스트
		try{
			System.out.println(list.get(0));
		}catch(IndexOutOfBoundsException e){
			e.printStackTrace();
		}
		
	}

}
