package list;

public class ArrayList<E> implements List<E> {
	//처음 만들때 사이즈
	private static final int INIT_CAPACITY=3; 
	private E[] data=null;
	private int size;
	
	
	@SuppressWarnings("unchecked")
	public ArrayList(){
		size=0;
		//data = (E[])new Object[INIT_CAPACITY];
		resize();
	}
	
	private void resize(){//시간복잡도 n
		//배열이 없을경우 초기값으로 생성하고 있는경우는 두배로 생성하여 복사한다
		int capacity = (data==null)? INIT_CAPACITY : data.length*2;
		E[] temp = (E[])new Object[capacity];
		
		//기존 데이터 옮기기
		for(int i=0; i<size; i++)
			temp[i] = data[i];
		
		data= temp;
	}
	
	@Override
	public void add(E element) {
		if(data.length<=size)
			resize(); //시간복잡도 n
		
		//resize 안할 경우 시간복잡도 1
		data[size]=element;
		size++;
	}

	@Override
	public void add(int index, E element) {
		if(index>size)
			throw new IndexOutOfBoundsException("index:"+index+", size:"+size);
		
		if(index<=size)
			resize();
		
		//resize에서 이미 다 복사 해 놓음
		//마지막은 추가만 하면되고,중간 삽입은 삽입전까지만 하나씩 뒤로 밀어서 복사하고 삽입
		for(int i=size; i>index; i--)
			data[i]=data[i-1];
		
		//index자리부분 비게됨 여기에 삽입
		data[index]=element;
		size++;
	}

	@Override
	public E get(int index) {
		if(index==size){//size보다 큰것임
			throw new IndexOutOfBoundsException("index:"+index+", size:"+size);
		}
		return data[index];
	}

	@Override
	public E remove(int index) {
		if(index>=size)
			throw new IndexOutOfBoundsException("index:"+index+", size:"+size);
		
		//삭제할 배열원소 따로 빼놓기
		E element = data[index];
		//삭제원소 다음 원소를 한칸씩 땡겨오고 사이즈 줄임
		for(int i=index; i<size-1; i++)
			data[i] = data[i+1];
		
		size--;
		return element;
	}

	@Override
	public void removeAll() {//시간복잡도 n
		for(int i=0; i<size; i++)
			data[i] = null;
		
		size = 0;//혼자 쓸 경우 덮어쓰기기능
	}

	@Override
	public int size() {
		return size;
	}

}
