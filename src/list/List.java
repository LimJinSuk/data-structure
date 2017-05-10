package list;

public interface List<E> {
	//insert 연산
	void add( E element );
    void add( int index, E element );
    
    //데이터 반환 연산
    E get( int index );
    
    E remove( int index );
    void removeAll();	
    
    int size();

}
