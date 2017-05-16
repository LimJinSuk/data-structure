package tree.test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityTest01 {//우선순위 큐

	public static void main(String[] args) {
		
		//초기 사이즈
		//트리를 배열로 끝노드에 추가할때 쉽게 하도록 배열로
		//인터페이스 객체
		Queue<String> pq = new PriorityQueue<String>(10,new Comparator<String>(){

			@Override//우선순위 비교 메서드
			public int compare(String o1, String o2) {
				//return o1.length()-o2.length();//MinHeap
				return o2.length()-o1.length();//MaxHeap
			}});
		
		pq.offer("A");
		pq.offer("ABCDE");
		pq.offer("ABC");
		pq.offer("ABCDEFGHI");
		pq.offer("ABCDEF");
		
		while(pq.isEmpty()==false){
			System.out.println(pq.poll());
		}
	}

}
