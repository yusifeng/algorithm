public interface Queue<E> {
    int getSize(); // 获取大小
    boolean isEmpty(); //是否为空
    void enqueue(E e); //入队
    E dequeue(); //出队
    E getFront(); //获取元素
}
