public interface Queue {

    /**
     * 队列是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * @return 队列中元素的个数
     */
    int size();

    /**
     * 向队列添加一个元素
     *
     * @param item
     */
    void offer(int item);


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


    /**
     * 将当前队首元素替换成为 item
     *
     * @param item
     */
    void replace(int item);
}
