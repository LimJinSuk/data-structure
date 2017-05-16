package stack;

import java.util.Iterator;

public class DoublyLinkedList<E> implements List<E> {
	
	private int size=0;
	private Node<E> head=null;
	private Node<E> tail=null;
	
	@Override
	public void add(E element) {
		final Node<E> newNode = new Node<E>( element );
		
		if(head==null)
			head=tail=newNode;
		else{
			tail.next=newNode;
			newNode.prev=tail;
			
			tail=newNode;
		}
		size++;
		
	}

	@Override
	public void add(int index, E element) {

		if(index>size)
			throw new IndexOutOfBoundsException("index:"+index+", size:"+size);
		if(index==size)
			add(element);
		else{
			final Node<E> newNode = new Node<E>(element);
			
			if(index==0){//처음 삽입
				newNode.next=head.next;
				head.prev=newNode;
				
				head=newNode;
			}
			else{//중간 삽입
				Node<E> x = head;//head
				for(int i=0; i<index-1; i++)
					x=x.next;
				
				newNode.next=x.next;
				x.next.prev=newNode;
				
				x.next=newNode;
				newNode.prev=x;
			}
			size++;
		}
		
	}

	@Override
	public E get(int index) {
		if(index>=size)
			throw new IndexOutOfBoundsException("index:"+index+", size:"+size);
		
		Node<E> x = head;//head
		for(int i=0; i<index; i++)
			x=x.next;
			
		return x.data;
	}

	@Override
	public E remove(int index) {

		if( size <= index )
			throw new IndexOutOfBoundsException( "Index:" + index + ", size:" + size );
		
		E data = null;
		
		if( 0 == index ) {  // head 삭제
			data = head.data;
			head.next.prev=null;
			
			head = head.next;
		} 
		else { // 중간 또는 tail 삭제
			
			Node<E> x = head;//head
			for( int i = 0; i < index - 1; i++ )
				x = x.next;
			
			data = x.next.data;
			
			if(x.next==tail){//끝제거
				tail.prev=null;
				tail=x;
				x.next=null;
			}
			else
				x.next = x.next.next;
				x.next.prev=x;
		}
		
		size--;
		return data;
	
	}

	@Override
	public void removeAll() {
		Node<E> x = head;//head로 이동
		
		while(x!=null){//null의 경우 멈춤
			Node<E> next=x.next;
			x.next=null;//연결 끊어버림
			x.prev=null;//첫번째는 아직 head가 있어서 없어지진않음 연결만 끊긴 상태
			x=next;
		}
		head=null;//첫번째 노드 삭제
		tail=null;//마지막 삭제
		size=0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[ size ];
		
		Node<E> x = head;
		int index = 0;
		while( x != null ) {
			arr[ index++ ] = x.data;
			x = x.next;
		}		
		return arr;
	}
	
	@Override
	public Iterator<E> iterator() {//for문으로 점근식n제곱을 방지하기 위함 = O(n)
		return new Iterator<E>() {
			private Node<E> x = head;
			
			@Override
			public boolean hasNext() {
				return x != null;
			}

			@Override
			public E next() {
				E data = x.data;
				x = x.next;
				return data;
			}
		};
	}
	
private static class Node<E> {
		
		private Node<E> next;
		private Node<E> prev;
	    private E data;
			
	    private Node( E element ) {
	        data = element;
	        next = null;
	        prev=null;
	    }
		
	 }

}
