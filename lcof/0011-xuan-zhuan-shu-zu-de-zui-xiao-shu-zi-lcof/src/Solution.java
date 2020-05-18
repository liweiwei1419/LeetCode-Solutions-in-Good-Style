public class Solution {

    public int minArray(int[] numbers) {
        int left = 0;

        // numbers.length 这个位置一定不会是待搜索的位置，
        // 为此只需要将右边界设置成 numbers.length - 1
        int right = numbers.length - 1;

        // 因为后面所有出现 right 的地方，都是 right - 1
        // 为此，直接将 right - 1 换成 right
        while (left < right) {
            int mid = left + (right - left) / 2;

            // 最特殊情况放在最后判断

            if (numbers[mid] < numbers[right]) {
                // 以 [3, 4, 1, 2, 3] 为例，mid 可能是最小值
                // mid 的右边一定不是解，
                // 因此下一轮搜索的区间是 [left, mid]，于是将 right 向左收缩到 mid
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                // 以 [3, 4, 5, 1, 3] 为例，mid 肯定不是最小值
                // 最小值只可能存在于 [mid + 1, right] 这个区间里
                // 于是将 left 向左收缩到 mid + 1
                left = mid + 1;
            } else {
                // [3,3,3,1,3]
                // [3,1,3,1,3] 最小值可能在前，也可能在后
                // 只能把 right 这个位置排除掉
                right--;
            }
        }

        // 因为把大于的数都排除了，最后剩下的那个数一定就是要找的数，不必再判断
        return numbers[left];
    }
}