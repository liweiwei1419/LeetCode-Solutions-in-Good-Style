import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * Nested 表示"嵌套的"
 */
interface NestedInteger {
    /**
     * 这一项是否是一个整形
     *
     * @return
     */
    boolean isInteger();

    /**
     * @return 如果 isInteger() 返回 true，就可以返回这个数字
     */
    Integer getInteger();

    List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

    // 使用 [[1,1],2,[1,1]] 这个例子去想，可以使用栈来完成，并且入栈的时候，应该倒着放进去


    private Deque<NestedInteger> stack = new ArrayDeque<>();
    private Integer data;

    public NestedIterator(List<NestedInteger> nestedList) {
        int len = nestedList.size();
        // 把嵌套的整形全部放到栈中
        // 注意：要倒着放！
        for (int i = len - 1; i >= 0; i--) {
            stack.addLast(nestedList.get(i));
        }
    }

    /**
     * 要求我们实现的方法 1
     *
     * @return
     */
    @Override
    public Integer next() {
        return data;
    }

    /**
     * 要求我们实现的方法 2
     *
     * @return
     */
    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            // 栈顶元素
            NestedInteger top = stack.removeLast();
            if (top.isInteger()) {
                data = top.getInteger();
                return true;
            } else {
                List<NestedInteger> list = top.getList();
                int len = list.size();
                // 注意：要倒着放！
                for (int i = len - 1; i >= 0; i--) {
                    stack.addLast(list.get(i));
                }
            }
        }
        return false;
    }
}