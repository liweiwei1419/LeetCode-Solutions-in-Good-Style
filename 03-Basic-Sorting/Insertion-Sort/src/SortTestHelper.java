import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class SortTestHelper {

    private static final Random RANDOM = new Random();

    /**
     * 生成随机数组的方法
     *
     * @param len 数组的位数
     * @param min 数组中元素的最小值（可以取到）
     * @param max 数组中元素的最大值（可以取到）
     * @return 一个随机数组
     */
    public static int[] generateRandomArray(int len, int min, int max) {
        int[] randomArray = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            randomArray[i] = min + random.nextInt(max - min + 1);
        }
        return randomArray;
    }


    /**
     * 测试排序的效率
     *
     * @param sortAlgorithm
     * @param arr
     */
    public static void testSortEfficiency(ISortAlgorithm sortAlgorithm, int[] arr) {
        System.out.println("您所使用的排序算法是 => " + sortAlgorithm.getName());

        Instant begin = Instant.now();
        sortAlgorithm.sort(arr);
        Instant end = Instant.now();

        long spend = Duration.between(begin, end).toMillis();
        BigDecimal spendBigDecimal = new BigDecimal(String.valueOf(spend)).divide(new BigDecimal("1000"));
        System.out.println("排序算法耗时 => " + spendBigDecimal + " 秒");
    }


    /**
     * 复制数组
     * 根据已经有的数组得到一个新的数组（用于比较排序算法的效率）
     *
     * @param arr
     * @return
     */
    public static int[] copyFromOldArray(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }


    /**
     * 测试数组是否按照升序排序
     *
     * @param arr
     */
    public static void testSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                throw new RuntimeException("给定数组不是按照升序排序");
            }
        }
        System.out.println("给定数组按照升序排序！");
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 判断两个数组是否相等
     *
     * @param arr1 待比较的数组 1
     * @param arr2 待比较的数组 2
     */
    public static boolean judgeArrayEquals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("两个数组的长度不相等");
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                System.out.println("排序算法错误");
                return false;
            }
        }
        System.out.println("排序算法正确");
        return true;
    }


    /**
     * 生成近乎有序的数组
     *
     * @param len
     * @param begin
     * @param swapTime
     */
    public static int[] generateNearlySortedArray(int len, int begin, int swapTime) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = begin + i;
        }
        for (int i = 0; i < swapTime; i++) {
            int randomIndex1 = RANDOM.nextInt(len);
            int randomIndex2 = RANDOM.nextInt(len);
            swap(arr, randomIndex1, randomIndex2);
        }
        return arr;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
