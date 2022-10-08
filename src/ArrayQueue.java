public class ArrayQueue<E> implements Queue<E> {
    Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array(capacity);
    }
    public ArrayQueue() {
        array = new Array();
    }
    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public E dequeue() {
        return array.pop();
    }

    @Override
    public void enqueue(E e) {
        array.unshift(e);
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("ArrayQueue: size = %d, capacity = %d, ", getSize(), getCapacity()));
        res.append("front [");
        for (int i = 0; i < getSize(); i++) {
            res.append(array.get(i));
            if (i != getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue();

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
