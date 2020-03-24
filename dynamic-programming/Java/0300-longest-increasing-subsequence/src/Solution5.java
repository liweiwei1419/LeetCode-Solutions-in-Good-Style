import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution5 {

    public int lengthOfLIS(int[] nums) {
        // 寻找第一个大于 poker 的元素
        int len = nums.length;
        int[] pile = new int[len];

        if (len == 0) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int poker = nums[i];

            int index = Collections.binarySearch(list, poker);
            if (index < 0) {
                list.add(-index - 1, poker);
                if (-index < list.size()) {
                    list.remove(-index);
                }
            }
        }

        return list.size();
    }
}
