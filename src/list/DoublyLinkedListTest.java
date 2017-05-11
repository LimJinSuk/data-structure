package list;

import java.util.Iterator;

public class DoublyLinkedListTest {

	public static void main(String[] args) {
		List<Integer> list = new DoublyLinkedList<Integer>();
		
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
	
		count=list.size();
		System.out.println("list 크기 : "+count);
		for(int i=0; i<count; i++)
			System.out.println(i+"번째 항목 : "+list.get(i));
		
		
		System.out.println("--------------------------");
		
		//list.add(3,0);
		list.remove(3);
		count=list.size();
		System.out.println("list 크기 : "+count);
		for(int i=0; i<count; i++)
			System.out.println(i+"번째 항목 : "+list.get(i));
		
		System.out.println("--------------------------");
		
		// Iterator 반복자를 통한 리스트 순회
		System.out.print("반복자 순회 :");
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			int i = it.next(); // auto unboxing
			System.out.print(i + "\t");
		}
		System.out.print("\n");
		
		System.out.println("-----예외 테스트------");
		//예외 테스트
		try{
			System.out.println(list.get(0));
		}catch(IndexOutOfBoundsException e){
			e.printStackTrace();
		}
		
	}

}
