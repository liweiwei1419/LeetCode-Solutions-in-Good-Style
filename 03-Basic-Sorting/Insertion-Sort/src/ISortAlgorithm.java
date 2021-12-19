public interface ISortAlgorithm {

    /**
     * 排序算法的名字
     *
     * @return
     */
    String getName();

    /**
     * 排序算法的实现
     *
     * @param arr 待排序数组
     */
    void sort(int[] arr);
}