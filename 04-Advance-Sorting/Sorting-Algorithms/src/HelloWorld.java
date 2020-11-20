import java.util.Arrays;

/**
 * @author liweiwei1419
 * @date 2019/9/6 4:01 AM
 */
public class HelloWorld {

    // 选择排序

    public static void main(String[] args) {
        int[] nums = {5, 3, 6, 2, 10};

        int len = nums.length;
        // 外层循环：如果有 5 个元素，我们就要遍历 4 次，因此遍历的次数是数组元素个数 - 1
        for (int i = 0; i < len - 1; i++) {
            // 内层循环我们看一看遍历的路径，它从 0 开始，一直要到数组的末尾
            // 开始的那个索引恰恰好是与 i 正相关的

            // 它初始化为 i，这是我们遍历的起点
            // 循环不变量，假设修正法
            int minIndex = i;
            // 初始化的时候，这里是 + 1
            for (int j = i + 1; j <= len - 1; j++) {
                // 在遍历的过程中，因为要选出一个最小的元素，后面我们还要把这个元素交换到
                // 未排序部分的开始，因此我们需要记录一个当前的最小值的索引
                // 在一次遍历过程的比较，总是与这个索引位置上的元素进行比较
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int index1, int index2) {
        // 我们需要借助一个临时变量，我们把它命名为 temp
        // 接下来代码的编写就是"头尾相接"，把它们写出来即可
        // 这个代码是固定的，相信也不难理解
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}