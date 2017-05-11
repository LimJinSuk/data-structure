package list;

import java.util.Iterator;

public class CircularLinkedList<E> implements List<E> {
	private int size=0;
	private Node<E> tail=null;
	private Node<E> pos=null;

	@Override
	public void add(E element) {
		final Node<E> newNode = new Node<E>(element);
		
		if(tail==null){//자기자신 가르킴
			newNode.next = newNode;
			tail=newNode;
		}
		else{
			newNode.next=tail.next;//헤드를 가르키게 함
			tail.next=newNode;//tail이 새노드 가르킴
			tail=tail.next;//tail 이동
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
				newNode.next=tail.next;
				tail.next=newNode;
			}
			else{//중간 삽입
				Node<E> x = tail.next;//head
				for(int i=0; i<index-1; i++)
					x=x.next;
				
				newNode.next=x.next;
				x.next=newNode;

			}
			size++;
		}

	}

	@Override
	public E get(int index) {
		if(index>=size)
			throw new IndexOutOfBoundsException("index:"+index+", size:"+size);
		
		Node<E> x = tail.next;//head
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
			
			data = tail.next.data;
			tail.next=tail.next.next;
		
		} else { // 중간 또는 tail 삭제
			
			Node<E> x = tail.next;//head
			for( int i = 0; i < index - 1; i++ ) {
				x = x.next;
			}
			
			data = x.next.data;
			
			if(x.next==tail)
				tail=x;
			
			else
				x.next = x.next.next;
			
		}
		
		size--;
		return data;
	}

	@Override
	public void removeAll() {
		Node<E> x = tail.next;//head로 이동
				
		while(x!=tail){//tail의 경우 멈춤
			Node<E> next=x.next;
			x.next=null;
			x=next;
		}
		tail.next=null;
		tail=null;
		size=0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[size];
		if(tail==null)
			return arr;
		
		int index = 0;
		Node<E> x=tail.next;
		while(true){
			arr[index++]=x.data;
			x=x.next;
			
			if(x==tail.next)//다시 헤더로 옴(한바퀴)
				break;
		}
		return arr;
	}
	
	public E next(){
		if(tail.next==null)
			return null;
		if(pos==null)
			pos=tail.next;
		E data = pos.data;
		pos = pos.next;
		
		return data;
	}
	
	@Override
	public Iterator<E> iterator() {return new Iterator<E>() {
		private int index = 0;
		private Node<E> x = tail.next;
		
		@Override
		public boolean hasNext() {
			return index < size;
		}
	
		@Override
		public E next() {
			E data = x.data;//head.data
			x = x.next;
			index++;
			return data;
		}
	};
	}
	
private static class Node<E> {
		
		private Node<E> next;
	    private E data;
			
	    private Node( E element ) {
	        data = element;
	        next = null;
	    }
			
	    private Node( E element, Node<E> next ) {
	        data = element;
	        this.next = next;
	    }
	 }

}
