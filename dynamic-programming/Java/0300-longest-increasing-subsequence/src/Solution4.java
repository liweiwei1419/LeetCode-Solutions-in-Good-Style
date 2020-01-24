public class Solution4 {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        // 特判
        if (len <= 1) {
            return len;
        }
        // tail 数组的定义：长度为 i + 1 的上升子序列的末尾最小是几
        int[] tail = new int[len];
        // 遍历第 1 个数，直接放在有序数组 tail 的开头
        tail[0] = nums[0];
        // end 表示有序数组 tail 的最后一个已经赋值元素的索引

        int end = 0;
        for (int i = 1; i < len; i++) {
            int left = 0;
            // 这里，因为当前遍历的数，有可能比有序数组 tail 数组实际有效的末尾的那个元素还大
            // 【逻辑 1】因此 end + 1 应该落在候选区间里
            int right = end + 1;
            while (left < right) {
                // 选左中位数不是偶然，而是有原因的，原因请见 LeetCode 第 35 题题解
                // int mid = left + (right - left) / 2;
                int mid = (left + right) >>> 1;

                if (tail[mid] < nums[i]) {
                    // 中位数肯定不是要找的数，把它写在分支的前面
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // 因为 【逻辑 1】，因此一定能找到第 1 个大于等于 nums[i] 的元素
            // 因此，无需再单独判断，直接更新即可
            tail[left] = nums[i];

            // 但是 end 的值，需要更新，当前仅当更新位置在当前 end 的下一位
            if (left == end + 1) {
                end++;
            }

        }
        // 调试方法
        // printArray(nums[i], tail);
        // 此时 end 是有序数组 tail 最后一个元素的索引
        // 题目要求返回的是长度，因此 +1 后返回
        end++;
        return end;
    }

    // 调试方法，以观察是否运行正确
    private void printArray(int num, int[] tail) {
        System.out.print("当前数字：" + num);
        System.out.print("\t当前 tail 数组：");
        int len = tail.length;
        for (int i = 0; i < len; i++) {
            if (tail[i] == 0) {
                break;
            }
            System.out.print(tail[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
        Solution4 solution4 = new Solution4();
        int lengthOfLIS = solution4.lengthOfLIS(nums);
        System.out.println("最长上升子序列的长度：" + lengthOfLIS);
    }
}
