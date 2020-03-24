import java.util.Iterator;
import java.util.List;
import java.util.Stack;


interface NestedInteger { // Nested 表示"嵌套的"
    boolean isInteger(); // 这一项是否是一个整形

    Integer getInteger(); // 如果 isInteger() 返回 true，就可以返回这个数字

    List<NestedInteger> getList();
}

// https://leetcode-cn.com/problems/flatten-nested-list-iterator/description/
// 使用 [[1,1],2,[1,1]] 这个例子去想，可以使用栈来完成，并且入栈的时候，应该倒着放进去
public class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack = new Stack<>();
    private Integer data;

    public NestedIterator(List<NestedInteger> nestedList) {
        int len = nestedList.size();
        // 把嵌套的整形全部放到栈中
        // 注意：要倒着放！
        for (int i = len - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
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
        while (!stack.isEmpty()) {
            // 栈顶元素
            NestedInteger top = stack.pop();
            if (top.isInteger()) {
                data = top.getInteger();
                return true;
            } else {
                List<NestedInteger> list = top.getList();
                int len = list.size();
                // 注意：要倒着放！
                for (int i = len - 1; i >= 0; i--) {
                    stack.push(list.get(i));
                }
            }
        }
        return false;
    }
}
