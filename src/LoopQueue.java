public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front; // 指向要出队的元素
    private int tail; // 最后一个元素的后面一个位置
    private int size; // 大小
    // front === tail 表示队列为空
    // ((tail + 1) % capacity) === front ==> 队列为满


    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E e) {
        // 不需要在之前考虑那么多，先扩容再说
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2 + 1);
        }
        // 这个时候的 front 和 tail 可能已经发生了变化，但其实无所谓
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can not dequeue from empty queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        // 出队之后的校验工作
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            // 这一步其实很关键的
            newData[i] = data[(front + 1) % data.length];
        }
        data = newData;
        front = 0;
        //这一步也很关键
        tail = size;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue: size = %d, capacity = %d, ", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue();

        for (int i = 0; i < 10; i++) {

//            if (i % 3 == 0) {
//                queue.dequeue();
//            } else {
            queue.enqueue(i);
//            }
            System.out.println(queue);
        }

    }
}