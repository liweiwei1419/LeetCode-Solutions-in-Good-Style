import java.util.Arrays;
import java.util.Random;

public class SortHelper {

    public static Random random = new Random(System.currentTimeMillis());


    /**
     * 判断给定的数组是不是已经排好序的数组
     * 对于只有交换元素位置的排序算法来说，这个测试方法是可用的
     * 不过对于一些引入额外空间赋值操作的排序算法来说，这个检测方法就不行了
     *
     * @param arr
     */
    public static void checkSorted(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                throw new RuntimeException("数组不是排好序的。");
            }
        }
        System.out.println("数组已经是排好序的。");
    }


    public static void checkSorted1(int[] originArr, int[] yourSortedArr) {
        int len = originArr.length;
        if (len != yourSortedArr.length) {
            throw new RuntimeException("您的排序数组与原数组长度不相等。");
        }
        Arrays.sort(originArr);
        for (int i = 0; i < len; i++) {
            if (originArr[i] != yourSortedArr[i]) {
                throw new RuntimeException("数组不是排好序的。");
            }
        }
        System.out.println("数组已经是排好序的。");
    }


    /**
     * @param count 数组中元素的个数
     * @param mix   最小值，能取到
     * @param max   最大值，取不到
     * @return
     */
    public static int[] generateRandomArray(int count, int mix, int max) {
        if (mix > max) {
            int temp = mix;
            mix = max;
            max = temp;
        }
        int[] arr = new int[count];
        int bound = max - mix;
        for (int i = 0; i < count; i++) {
            int randomInt = random.nextInt(bound) + mix;
            arr[i] = randomInt;
        }
        return arr;
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
