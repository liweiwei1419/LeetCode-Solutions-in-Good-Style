import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] res = new int[list.size()];
        int index = 0;
        for (Integer integer : list) {
            res[index] = integer;
            index++;
        }
        return res;
    }
}