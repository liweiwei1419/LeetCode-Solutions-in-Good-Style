import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */


class NestedIntegerImpl3 implements NestedInteger {
    private boolean isInteger = false;
    private Integer intData;
    private List<NestedInteger> nestedList = new ArrayList<>();

    public NestedIntegerImpl3(boolean isInteger, Integer intData) {
        this.isInteger = isInteger;
        this.intData = intData;
    }

    public NestedIntegerImpl3(boolean isInteger, NestedInteger... nestedIntegers) {
        this.isInteger = false;
        for (NestedInteger nestedInteger : nestedIntegers) {
            this.nestedList.add(nestedInteger);
        }
    }

    @Override
    public boolean isInteger() {
        return isInteger;
    }

    @Override
    public Integer getInteger() {
        return intData;
    }

    @Override
    public List<NestedInteger> getList() {
        return nestedList;
    }
}

// 仅仅只是编写了测试用例而已
public class NestedIterator3 implements Iterator<Integer> {

    List<NestedInteger> nestedList;
    
    int data; // 把下一个的值放在这个 data 变量里面

    public NestedIterator3(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
    }

    @Override
    public Integer next() {
        return data;
    }

    @Override
    public boolean hasNext() {
        while (nestedList != null && nestedList.size() > 0) {
            NestedInteger top = nestedList.remove(0);
            if (top.isInteger()) {
                data = top.getInteger();
                return true;
            } else {
                nestedList.addAll(0, top.getList());
            }
        }
        return false;
    }


    /**
     * 测试用例 [1,[4,[6,5]]]
     * @param args
     */
    public static void main(String[] args) {
        NestedInteger six = new NestedIntegerImpl3(true, 6);
        NestedInteger five = new NestedIntegerImpl3(true, 5);
        NestedInteger six_1_five = new NestedIntegerImpl3(false, six, five);

        NestedInteger four = new NestedIntegerImpl3(true, 4);
        NestedInteger four_2_six_1_five = new NestedIntegerImpl3(false, four, six_1_five);

        NestedInteger one = new NestedIntegerImpl3(true, 1);
        NestedInteger one_3_four_2_six_1_five = new NestedIntegerImpl3(false, one, four_2_six_1_five);
        NestedIterator nestedIterator = new NestedIterator(one_3_four_2_six_1_five.getList());
        while (nestedIterator.hasNext()) {
            Integer next = nestedIterator.next();
            System.out.printf("%d \t", next);
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */