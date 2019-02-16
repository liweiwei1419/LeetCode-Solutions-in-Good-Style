```java
public int lengthOfLIS(int[] nums) {
    int len = nums.length;
    if (len < 2) {
        return len;
    }
    // 这个数组实际上的长度，就是最后所求
    int[] tail = new int[len];
    int end = 0;
    tail[0] = nums[0];
    for (int i = 1; i < len; i++) {
        if (nums[i] > tail[end]) {
            end++;
            tail[end] = nums[i];
        } else {
            // 使用二分搜索法来做这件事情
            // 数组长度不变，一定会更新一次
            // 特殊例子：1 2 3 4 5 7 7 7 7 7 7 7 （只是举个例子，这道题不会出现这种情况），来了一个 6
            // 我要将从左到右边数第 1 个大于 6 的数字更新为 6
            int left = 0;
            int right = end;
            int target = nums[i];
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tail[mid] < target) {
                    // 只要比目标值要小，我们要找的位置就至少是当前位置 + 1
                    left = mid + 1;
                } else {
                    assert tail[mid] >= target;
                    // 大于目标值，我们不能盲目向前走，因为向前走很可能，值会变得比目标值小
                    right = mid;
                }
            }
            tail[right] = target;
        }
    }
    return end + 1;
}
```