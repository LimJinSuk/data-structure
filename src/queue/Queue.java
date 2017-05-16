package queue;

public interface Queue<E> {
	void offer( E item );

    E poll();//가장 앞의 항목 제거,반환

    E peek();//가장 앞의항목 반환

}
