public class ArrayStack<E> implements Stack<E> {
    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array(capacity);
    }
    public ArrayStack() {
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
    public void push(E e) {
        array.addLast(e);
    }
    @Override
    public E peek() {
        return array.getLast();
    }
    @Override
    public E pop() {
        return array.pop();
    }

    public int getCapacity() {
        return array.getCapacity();
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("ArrayStack: size = %d, capacity = %d, ", getSize(), getCapacity()));
        res.append("[");
        for (int i = 0; i < getSize(); i++) {
            res.append(array.get(i));
            if (i != getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
