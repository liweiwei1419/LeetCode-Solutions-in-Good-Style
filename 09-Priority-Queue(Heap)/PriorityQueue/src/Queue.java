public interface Queue {

    /**
     * 队列是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 返回队列中元素的个数
     *
     * @return
     */
    int size();

    /**
     * 向队列添加一个元素
     *
     * @param x
     */
    void offer(int x);

    /**
     * 将一个元素出队
     *
     * @return
     */
    int poll();

    /**
     * 返回队首元素
     *
     * @return
     */
    int peek();
}
