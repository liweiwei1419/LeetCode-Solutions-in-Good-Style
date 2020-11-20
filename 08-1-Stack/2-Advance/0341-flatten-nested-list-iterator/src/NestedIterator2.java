import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


// https://leetcode-cn.com/problems/flatten-nested-list-iterator/description/
// 使用 [[1,1],2,[1,1]] 这个例子去想，可以使用栈来完成，并且入栈的时候，应该倒着放进去
public class NestedIterator2 implements Iterator<Integer> {

    private Integer data;
    private LinkedList<NestedInteger> deque = new LinkedList<>();
    // private Deque<NestedInteger> deque = new ArrayDeque<>(); 用双端队列也是可以的

    public NestedIterator2(List<NestedInteger> nestedList) {
        for (int i = 0; i < nestedList.size(); i++) {
            deque.addLast(nestedList.get(i));

        }
    }

    // 要求我们实现的方法 1
    @Override
    public Integer next() {
        return data;
    }

    // 要求我们实现的方法 2
    @Override
    public boolean hasNext() {
        while (!deque.isEmpty()) {
            NestedInteger top = deque.removeFirst();
            if (top.isInteger()) {
                data = top.getInteger();
                return true;
            } else {
                List<NestedInteger> list = top.getList();
                for (int i = list.size() - 1; i >= 0; i--) {
                    deque.addFirst(list.get(i));
                }
            }
        }
        return false;
    }
}