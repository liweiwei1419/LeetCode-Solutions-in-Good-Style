public class Solution2 {

    // 参考资料：https://leetcode-cn.com/problems/reverse-pairs/solution/493fan-zhuan-dui-gui-bing-pai-xu-java-by-sugar-31/

    public int reversePairs(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);

    }

    public int mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftRes = mergeSort(nums, left, mid);
        int rightRes = mergeSort(nums, mid + 1, right);

        return leftRes + rightRes + merge(nums, left, mid, right);
    }

    public int merge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int count = 0;

        while (i <= mid && j <= right) {
            if (nums[i] > 2 * (long) nums[j]) {
                // 这里要画图计算出来
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }

        i = left;
        j = mid + 1;

        int[] temp = new int[right - left + 1];
        int index = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[index] = nums[i];
                i++;
                index++;
            } else {
                temp[index] = nums[j];
                j++;
                index++;
            }
        }

        while (i <= mid) {
            temp[index] = nums[i];
            i++;
            index++;
        }
        while (j <= right) {
            temp[index] = nums[j];
            j++;
            index++;
        }

        // 赋值回去
        for (int k = 0; k < temp.length; k++) {
            nums[left + k] = temp[k];
        }
        return count;
    }
}