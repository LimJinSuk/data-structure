package list;

public class LinkedList<E> implements List<E> {
	
	private Node<E> head=null;
	private Node<E> tail=null;
	private int size;
	
	@Override
	public void add(E element) {
		Node<E> newNode = new Node<E>(element);
		
		if(head==null)//아무것도 없을 경우
			head = newNode;
		else{
			Node<E> x = head;
			while(x.next!=null)//노드의 마지막이 될때 까지 반복
				x=x.next; //노드 하나씩 이동
			
			x.next=newNode;
		}
		size++;
	}

	@Override
	public void add(int index, E element) {
		Node<E> newNode = new Node<E>(element);
		
		if(index>size)
			throw new IndexOutOfBoundsException("index:"+index+", size:"+size);
		else if(index==size)
			add(element);
		else{
			if(index==0){//처음 삽입
				Node<E> temp = newNode;
				newNode.next=head;
				head=temp;
				size++;
			}
			else{//중간 삽입
				Node<E> x = head;
				for(int i=0; i<index-1; i++)
					x=x.next;
				
				newNode.next=x.next;
				x.next=newNode;
				
				size++;
			}
		}
	}

	@Override
	public E get(int index) {
		
		if(size<=index)
			throw new IndexOutOfBoundsException("index:"+index+", size:"+size);
		
		Node<E> x=head;
		
		for(int i=0; i<index; i++)
			x=x.next;
		
		return x.data;
	}

	@Override
	public E remove(int index) {//삭제데이터 반환
		Node<E> x=head;
		Node<E> temp=null;
		if(index>size-1)
			throw new IndexOutOfBoundsException("index:"+index+", size:"+size);
		else{//첫번째 노드 삭제
			if(index==0){
				Node<E> next=x.next;
				temp=x;
				
				x=next;
				head=x;
				size--;
			}
			//마지막 노드 삭제
			else if(index==size-1){
				Node<E> tail=head;
				for(int i=0; i<index-1; i++)
					tail=tail.next;
				temp=tail.next;
				tail.next.next=null;
				tail.next.data=null;
				size--;
			}
			//중간 노드 삭제
			else{
				Node<E> tail=head;
				for(int i=0; i<index-1; i++)
					tail=tail.next;
				temp=tail.next;
				tail.next=temp.next;
				size--;
				
			}
		}
		return temp.data;
	}

	@Override
	public void removeAll() {
		for(Node<E> x=head; x!=null;){
			//next값을 미리 구해놓아야 옆으로 이동이 가능
			Node<E> next = x.next;
			//이동 후 삭제
			x.data=null;
			x.next=null;
			
			x=next;
		}
		head = null;
		size=0;
	}

	@Override
	public int size() {
		return size;
	}
	
	//리스트 내부에서만 쓰기 때문에 내부클래스로 지정
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
