package cn.leetcode.utils;

import cn.leetcode.examples.GenerateRandomArrayStrategy;
import cn.leetcode.examples.IGenerateArrayStrategy;
import cn.leetcode.sorting.ISortingAlgorithm;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

/**
 * @author liweiwei1419
 * @date 2019/9/6 5:00 AM
 */
public class SortingUtil {

    /**
     * 随机数种子
     */
    public static final Random RANDOM = new Random(System.currentTimeMillis());

    /**
     * 测试方法执行的次数
     */
    private static final int TEST_TIMES = 3;

    /**
     * 小数点后保留几位有效数字
     */
    private static final int SCALE = 8;

    /**
     * 将毫秒转化为秒的分母常量
     */
    private static final BigDecimal DIVISOR = new BigDecimal("1000");

    /**
     * 交换数组中两个索引位置的元素
     *
     * @param nums   数组
     * @param index1 索引 1
     * @param index2 索引 2
     */
    public static void swap(int[] nums, int index1, int index2) {
        // 严格意义上说，这里需要对 index1 和 index2 的有效性做校验
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    /**
     * 打印数组
     *
     * @param nums 待打印数组
     */
    public static void printArray(int[] nums) {
        int len = nums.length;
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
            if (i == len - 1) {
                System.out.println("]");
                break;
            }
            System.out.print(", ");
        }
        // 使用 Java，可以用下面这一行代码代替
        // System.out.println(Arrays.toString(nums));
    }


    /**
     * 生成随机整型数组
     *
     * @param len 生成随机整型数组的长度
     * @param min 生成随机整型中元素的最小值（可以取到）
     * @param max 生成随机整型中元素的最大值（可以取到）
     * @return 一个随机数组
     */
    public static int[] generateRandomArray(int len, int min, int max) {
        // 参数校验
        assert len > 0;
        if (min > max) {
            int temp = max;
            max = min;
            min = temp;
        }

        int[] randomArray = new int[len];
        for (int i = 0; i < len; i++) {
            // nextInt(n) 生成 [0, n) 的随机整数
            randomArray[i] = min + RANDOM.nextInt(max - min + 1);
        }
        return randomArray;
    }

    /**
     * 复制数组：根据已经有的数组得到一个新的数组（用于比较排序算法的效率）
     *
     * @param nums 待复制数组
     * @return 与 nums 相等的数值
     */
    public static int[] copyFromArray(int[] nums) {
        int len = nums.length;
        int[] newArr = new int[len];
        // Java 可以使用下面一行代码
        // System.arraycopy(nums, 0, newArr, 0, len);
        for (int i = 0; i < len; i++) {
            newArr[i] = nums[i];
        }
        return newArr;
    }

    /**
     * 判断两个数组是否相等，通过逐个比对的方式比较两个数组是否相等
     *
     * @param arr1 待比较的数组 1
     * @param arr2 待比较的数组 2
     */
    public static void judgeArrayEquals(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        if (len1 != len2) {
            throw new RuntimeException("两个数组长度不相等，请检查！");
        }
        for (int i = 0; i < len1; i++) {
            if (arr1[i] != arr2[i]) {
                throw new RuntimeException("您编写的排序算法错误！");
            }
        }
    }


    /**
     * 测试排序算法正确性、计算排序算法执行时间
     *
     * @param sortingAlgorithm 我们自己编写的排序算法实现对象
     */
    public static void testSortingAlgorithm(ISortingAlgorithm sortingAlgorithm) {
        int len = 1_0000;
        testSortingAlgorithm(sortingAlgorithm, new GenerateRandomArrayStrategy(len, 1, len));
    }

    /**
     * 统计排序算法耗时
     *
     * @param sortingAlgorithm 排序算法，传入我们自己编写的排序算法实现对象
     * @param nums             待排序数组
     */
    private static void timingSortingAlgorithm(ISortingAlgorithm sortingAlgorithm, int[] nums) {
        // 使用我们的算法对 nums 进行排序
        Instant startTime = Instant.now();
        sortingAlgorithm.sort(nums);
        Instant endTime = Instant.now();

        // 以毫秒为单位
        long millis = Duration.between(startTime, endTime).toMillis();
        // 向上取整
        BigDecimal spendBigDecimal = new BigDecimal(String.valueOf(millis)).divide(DIVISOR, SCALE, RoundingMode.CEILING);
        System.out.print(String.format("耗时 %s 秒。\n", spendBigDecimal.toString()));
    }

    /**
     * 测试排序算法正确性、计算排序算法执行时间
     *
     * @param sortingAlgorithm 我们自己编写的排序算法实现对象
     * @param generateArray    生成测试用例数组的策略对象
     */
    public static void testSortingAlgorithm(ISortingAlgorithm sortingAlgorithm, IGenerateArrayStrategy generateArray) {
        System.out.println(String.format("您使用的排序算法是：%s。", sortingAlgorithm));
        printGenerateArrayFeature(generateArray);
        // 多运行几次，避免我们编写的算法恰好"蒙混过关"
        for (int i = 0; i < TEST_TIMES; i++) {
            System.out.print(String.format("生成第 %d 个数组，", i + 1));
            // 根据一定的策略生成测试用例数组
            int[] randomArray = generateArray.generateArray();
            // 生成测试用例数组的拷贝
            int[] randomArrayCopy = SortingUtil.copyFromArray(randomArray);

            // 将计时逻辑封装到一个函数中，更好的做法是使用动态代理或者过滤器
            timingSortingAlgorithm(sortingAlgorithm, randomArray);

            // 使用系统库函数对 randomArrayCopy 进行排序
            Arrays.sort(randomArrayCopy);

            // 逐个比较两个排序以后的数组元素，以验证我们编写的排序算法的正确性
            SortingUtil.judgeArrayEquals(randomArray, randomArrayCopy);
        }
        System.out.println("您编写的排序算法正确！\n");
    }

    /**
     * @param sortingAlgorithms 可变长参数，可以理解为数组，即 ISortingAlgorithm[]
     */
    public static void compareSortingAlgorithms(ISortingAlgorithm... sortingAlgorithms) {
        compareSortingAlgorithms(new GenerateRandomArrayStrategy(), sortingAlgorithms);
    }

    /**
     * 根据不同的测试用例，比较不同排序算法的性能
     *
     * @param generateArrayStrategy 以对象的方式传入生成随机数组的策略：完全随机、部分有序、完全逆序、有大量重复元素
     * @param sortingAlgorithms     排序算法的实例
     */
    public static void compareSortingAlgorithms(IGenerateArrayStrategy generateArrayStrategy, ISortingAlgorithm... sortingAlgorithms) {
        System.out.println("排序算法比较：");
        int[] arr = generateArrayStrategy.generateArray();
        printGenerateArrayFeature(generateArrayStrategy);
        for (ISortingAlgorithm sortingAlgorithm : sortingAlgorithms) {
            // 其实第 1 个排序算法没有必要复制数组，目前没有想到更好的写法
            int[] arrCopy = copyFromArray(arr);
            System.out.print(String.format("%s：\n\t", sortingAlgorithm));
            timingSortingAlgorithm(sortingAlgorithm, arrCopy);
        }
        System.out.println();
    }

    /**
     * 输出测试用例数组的特点
     *
     * @param generateArrayStrategy 生成随机数组的策略对象
     */
    private static void printGenerateArrayFeature(IGenerateArrayStrategy generateArrayStrategy) {
        System.out.printf("测试用例特点：%s，规模：%d，最小值：%d，最大值：%d。\n",
                generateArrayStrategy.getFeature(),
                generateArrayStrategy.getLen(),
                generateArrayStrategy.getMin(),
                generateArrayStrategy.getMax());
    }

    public static void main(String[] args) {
        String s = "冒泡排序（优化）";
        System.out.println(s.length());
    }
}