public class Solution3 {
    public int findBestValue(int[] arr, int target) {//待查找区间是所有可能的value从小到大排好的数组，要查的目标是能使距离更小的那个value的左边界
        int sum = 0;
        int maxArr = arr[0];
        for (int a : arr) {
            if (a > maxArr) {
                maxArr = a;
            }
            sum += a;
        }
        if (sum <= target) {
            return maxArr;
        }
        // 依题意改变 arr，只会让sum(arr)不变或变得更小，当target本身就大于等于sum(arr)时，取arr的最大元素，不改变arr
        // 能取到的最小值，即待查找区间起始点
        int left = 0;
        // 能取到的最大值，即待查找区间终结点，实际上更大也可以，但是没有意义，都不改变arr
        int right = maxArr;

        while (left <= right) {
            int mid  = (left + right) / 2;
            int temp = getSum(arr, mid);
            if (temp - target == 0) {
                return mid;
            } else if (temp < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (Math.abs(getSum(arr, left) - target) < Math.abs(getSum(arr, left - 1) - target)) {
            return left;
        } else {
            return left - 1;
        }
    }

    public int getSum(int[] arr, int value) {//二分的判断函数，用于判断是否距离更小
        int sum = 0;
        for (int a : arr) {
            sum += Math.min(a, value);
        }
        return sum;
    }


}
