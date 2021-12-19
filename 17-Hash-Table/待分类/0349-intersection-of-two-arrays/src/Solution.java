import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        // 把第 1 个数组的全部元素加入哈希表
        // 哈希表的作用：去重、判断是否存在
        Set<Integer> record = new HashSet<>();
        for (int num : nums1) {
            record.add(num);
        }

        // 把第 2 个数组里不在第 1 个数组里的元素加入结果集哈希表，这里也达到了去重的作用
        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (record.contains(num)) {
                resultSet.add(num);
            }
        }

        // 把哈希表中的额所有元素输出到数组中
        int size = resultSet.size();
        int[] res = new int[size];
        int index = 0;
        for (Integer num : resultSet) {
            res[index] = num;
            index++;
        }
        return res;
    }
}