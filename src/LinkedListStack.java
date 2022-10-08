public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> list;
    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedListStack top:");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> list = new LinkedListStack<>();
        for (int i = 0; i < 10; i++) {
            list.push(i);
        }
        list.pop();
        System.out.println(list);
    }
}
