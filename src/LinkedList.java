public class LinkedList<E> {
    // 这个设计成私有的
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }
        public Node() {
            this(null, null);
        }
        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;
    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }
    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    // 中间添加
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }
        // 虚拟头节点
        Node prev = dummyHead;
        // 这个地方由 index - 1 => index
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size ++;
    }
    public void addLast(E e) {
        add(size, e);
    }
    public void addFirst(E e) {
        add(0, e);
    }
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }
        Node current = dummyHead;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
//        视频上是这样的,但跟我写的其实是一样的
//        Node current = dummyHead.next;
//        for (int i = 0; i < index; i++) {
//            current = current.next;
//        }
        return current.e;
    }

    public E getFirst() {
        return get(0);
    }
    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        // 不是换的节点，换的是e呀
        current.e = e;
    }

    public boolean contains(E e) {
        Node current = dummyHead.next;
//        for (int i = 0; i < size; i++) {
//            current = current.next;
//            if (current.e == e) {
//                return true;
//            }
//        }
        while (current != null){
            if (current.e.equals((e))) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }
        // 待删除节点的前一个节点
        Node prev = dummyHead;
//        这里是找到它前一个所以用的dummyHead
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }
    public E removeLast() {
        return remove(size - 1);
    }
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
    public static void main(String[] args) {
        System.out.println(123);
        LinkedList<Integer> linkList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkList.addFirst(i);
            System.out.println(linkList);
        }
        linkList.add(2, 666);
        System.out.println(linkList);
        linkList.removeFirst();
        System.out.println(linkList);
        linkList.removeLast();
        System.out.println(linkList);
        linkList.remove(1);
        System.out.println(linkList);
    }
}
