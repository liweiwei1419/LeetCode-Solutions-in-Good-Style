import java.util.HashMap;
import java.util.Map;

public class FindSumPairs {

    private int[] nums1;
    private int[] nums2;

    private Map<Integer, Integer> freq;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        freq = new HashMap<>();
        for (int num : nums2) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
    }

    /**
     * 给某个数值加上 val，注意是增量，所以频数数组一减一加
     *
     * @param index
     * @param val
     */
    public void add(int index, int val) {
        freq.put(nums2[index], freq.get(nums2[index]) - 1);
        nums2[index] += val;
        freq.put(nums2[index], freq.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int res = 0;
        for (int num : nums1) {
            int rest = tot - num;
            if (freq.containsKey(rest) && freq.get(rest) > 0) {
                res += freq.get(rest);
            }
        }
        return res;
    }
}