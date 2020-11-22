import java.util.HashMap;
import java.util.Map;

public class Solution {

    // 重复出现 1 次和 2 次的时候什么都不做
    // [0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 4]

    public int removeDuplicates(int[] nums) {
        // [1, 1] 最多 2 个元素就能够不用判断

        int len = nums.length;
        if (len < 3) {
            return len;
        }
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        int k = 0;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int count = counter.get(nums[i]);
            if (count > 2){
                count = 2;
            }
            for (int j = 0; j < count; j++) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}