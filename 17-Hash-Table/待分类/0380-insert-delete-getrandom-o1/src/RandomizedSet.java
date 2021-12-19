import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {

    /**
     * 动态数组
     */
    List<Integer> nums;

    /**
     * 用来建立每个数字和其在数组中的位置之间的对应关系
     * key ：真正插入的数值，方便以 O(1) 的时间复杂度实现 insert 和 remove 操作
     * value：该值在数组 nums 中的下标
     */
    Map<Integer, Integer> hashMap;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        nums = new ArrayList<>();
        hashMap = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (hashMap.containsKey(val)) {
            return false;
        }

        hashMap.put(val, nums.size());
        // 添加在最后，这样就是 O(1)
        nums.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        // 不在集合里面，就没法删除
        if (!hashMap.containsKey(val)) {
            return false;
        }

        // 注意：这里是很有技巧的地方

        int index = hashMap.get(val);
        // 如果这个数不在最后一位，就把本来最后一位应该放置的数字放到这个数的位置上，然后赋值
        if (index < nums.size() - 1) {
            int lastValue = nums.get(nums.size() - 1);
            nums.set(index, lastValue);

            // 重新维护一下下标的定义
            hashMap.put(lastValue, index);
        }

        // 两个数据结构都要同时维护
        hashMap.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}
