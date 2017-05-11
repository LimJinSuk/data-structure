package list;

import java.util.Iterator;

public interface List<E> {//인터페이스 간의 상속
	//insert 연산
	void add( E element );
    void add( int index, E element );
    
    //데이터 반환 연산
    E get( int index );
    
    E remove( int index );
    void removeAll();	
    
    int size();
    
    Object[] toArray();
    Iterator<E> iterator();
}
