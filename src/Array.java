public class Array<E> {
    private E[] data;
    private int size;

    /**
     * @param capacity 容量
     */
    public Array(int capacity) {
//        不能new
//        data = new E[capacity];
        data = (E[])new Object[capacity];
        size = 0;
    }
    // 这应该是重载吧
    public Array() {
        this(10);
    }
    public int getSize() {
        return size;
    }
    public int getCapacity() {
        return data.length;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void addLast(E e) {
        add(size, e);
    }
    public E get(int index) {
        return data[index];
    }
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set failed, index is illegal");
        }
        data[index] = e;
    }
    public void unshift(E e) {
        add(0, e);
    }
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //查找
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed Index is illegal");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null; //loitering objects != memory leak

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E shift() {
        return remove(0);
    }

    public E pop() {
        return remove(size - 1);
    }

    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        } else {
            return false;
        }
    }
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index illegal");
        }
        if (size == data.length) {
            resize(2 * size);
//            throw new IllegalArgumentException("add failed, Array is full");
        }
        int t = size;
        while(t > index) {
            data[t] = data[t - 1];
            t--;
        }
        data[index] = e;
        size ++;
    }
    // 私有方法，外部无法使用
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d, ", size, getCapacity()));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
