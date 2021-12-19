public class ArrayStack<E> implements Stack<E> {

    // 数组栈相当于在动态数组的基础上进行限制，就能帮助我们解决很多问题
    private Array<E> array;

    public ArrayStack(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayStack() {
        this.array = new Array<>();
    }

    @Override
    public void push(E e) {
        // 只在动态数组的末尾添加元素
        array.addLast(e);
    }

    @Override
    public E pop() {
        // 只在动态数组的末尾移除元素
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Stack: [");
        for (int i = 0; i < array.getSize(); i++) {
            s.append(array.get(i));
            if(i!=array.getSize()-1){
                s.append(", ");
            }
        }
        s.append("] top");
        return s.toString();
    }
}
