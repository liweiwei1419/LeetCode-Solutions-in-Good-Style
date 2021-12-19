import java.awt.*;


/**
 * 这是一个控制器
 * 控制器里面有视图和模型
 */
public class AlgoVisualizer {

    private static int DELAY = 300;

    // 模型
    private SelectionSortData data;
    // 视图
    private AlgoFrame algoFrame;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) {
        // 设置窗口的大小
        data = new SelectionSortData(N, sceneHeight);

        // 初始化视图
        EventQueue.invokeLater(() -> {
            algoFrame = new AlgoFrame("选择排序算法可视化", sceneWidth, sceneHeight);
            // Java 的官方文档告诉我们 EventQueue.invokeLater 里面的代码要很快执行完
            new Thread(() -> {
                run();
            }).start();
        });
    }

    /**
     * 这里单独写动画逻辑
     */
    private void run() {
        int numbersLength = data.N();
        // 选择排序的框架

        setData(0, -1, -1);
        for (int i = 0; i < numbersLength - 1; i++) {
            int minIndex = i;
            setData(i, -1, minIndex);
            for (int j = i + 1; j < numbersLength; j++) {
                setData(i, j, minIndex);
                if (data.get(j) < data.get(minIndex)) {
                    minIndex = j;
                    setData(i, j, minIndex);
                }
            }
            data.swap(i, minIndex);
            setData(i + 1, -1, -1);
        }
        setData(numbersLength, -1, -1);
    }


    private void setData(int sortedIndex, int currentComparedIndex, int currentMinIndex) {
        // 当前已经排好序的部分的最后一个元素的索引
        data.sortedIndex = sortedIndex;
        // 当前正在用于比较的元素的索引
        data.currentComparedIndex = currentComparedIndex;
        // 当前最小元素的索引
        data.currentMinIndex = currentMinIndex;

        algoFrame.render(data);
        AlgoVisHelper.pause(DELAY);
    }


    public static void main(String[] args) {
        int sceneWidth = 400;
        int sceneHeight = 400;
        int N = 10;
        AlgoVisualizer algoVisualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);
    }
}