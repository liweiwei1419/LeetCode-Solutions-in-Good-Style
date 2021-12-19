import java.util.Arrays;

public class Array<E> {

    // 我们的动态数组的底层实现，仍然是静态数组
    private E[] data;
    private int size; // 当前的动态数组中有多少元素

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认内部实现的静态数组的容量是 10
    public Array() {
        this(10);
    }

    // 返回当前静态数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 返回我们当前设计的自己的动态数组中的元素个数
    public int getSize() {
        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }


    // 在索引 index 处插入一个元素 e
    // 原来 index 处的元素全部向后移
    public void add(int index, E e) {
        // 判断用户传来的索引是否正确
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        // 先把 index 以及后面的所有元素向后移动
        // 空出 index 这个位置的元素给新来的朋友
        data[index] = e;
        size++;
    }


    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }


    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }


    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }


    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }


    // 查找数组中元素 e 所在的索引，
    // 如果不存在元素 e，则返回 -1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 查找数组中是否包含元素 e
    public boolean contain(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) { // 包括了 size = 0 的时候，不能删的情况
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        E result = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        // loitering objects != memory leak
        // 为什么？这句话不是必须的。
        data[size] = null;// 手动解除引用其实更好

        // remove size 的时候，我们有一些着急
        // 这个时候我们没有必要直接缩容
        // data.length / 2 != 0 是为了防止出现 data.length = 1 时，data.length / 2 = 0 的情况
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return result;
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E removeFirst() {
        return remove(0);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        s.append("[");
        for (int i = 0; i < size; i++) {
            s.append(data[i]);
            if (i != size - 1) {
                s.append(", ");
            }
        }
        s.append("]");
        return s.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
