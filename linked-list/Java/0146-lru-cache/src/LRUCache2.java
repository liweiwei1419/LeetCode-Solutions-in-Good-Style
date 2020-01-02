import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * @author liweiwei1419
 * @date 2019/11/23 1:50 上午
 */
public class LRUCache2 {

    // HashMap 是无序的，
    // 当我们希望有顺序地去存储 key-value 时，
    // 就需要使用 LinkedHashMap 了

    private LinkedHashMap<Integer, Integer> hashMap;
    private int capacity;

    public LRUCache2(int capacity) {
        // 第 3 个参数 accessOrder 是指是否基于访问排序，默认为 false，表示不基于访问顺序
        // 设置为 true ，则表示基于访问顺序，就是这道题要求的
        hashMap = new LinkedHashMap<>(capacity + 1, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            return hashMap.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        hashMap.put(key, value);
        if (hashMap.size() > capacity) {
            Iterator<Integer> iterator = hashMap.keySet().iterator();
            hashMap.remove(iterator.next());
        }
    }
}
