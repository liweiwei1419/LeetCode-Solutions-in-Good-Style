import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public int twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(nums[0], 1);

        int res = 0;
        for (int i = 1; i < len; i++) {
            // 先查 map 里有多少个与当前数 nums[i] 匹配（匹配的那个数是 target - nums[i]），加上去
            res += hashMap.getOrDefault(target - nums[i], 0);

            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();

        int[] nums = {1, 5, 3, 3, 3};
        int target = 6;
        int res = solution3.twoSum(nums, target);
        System.out.println(res);

        System.out.println(Math.log(10000) / Math.log(2));
    }
}
