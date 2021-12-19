import java.awt.*;


/**
 * 这是一个控制器
 * 控制器里面有视图和模型
 */
public class AlgoVisualizer {

    private static int DELAY = 800;

    // 模型
    private InsertSortData data;
    // 视图
    private AlgoFrame algoFrame;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) {
        // 设置窗口的大小
        data = new InsertSortData(N, sceneHeight);

        // 初始化视图
        EventQueue.invokeLater(() -> {
            algoFrame = new AlgoFrame("插入排序算法可视化", sceneWidth, sceneHeight);
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
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int numbersLength = data.N();
        // 插入排序的框架
        setData(0,-1);
        for (int i = 1; i < numbersLength; i++) {
            setData(i,i);
            for (int j = i; j > 0 && data.get(j) < data.get(j - 1); j--) {
                data.swap(j, j - 1);
                setData(i+1,j-1);
            }
            setData(i+1,-1);
        }
        setData(numbersLength,-1);
    }


    private void setData(int sortedIndex, int currentIndex) {
        data.sortedIndex = sortedIndex;
        data.currentIndex = currentIndex;

        algoFrame.render(data);
        AlgoVisHelper.pause(DELAY);

    }


    public static void main(String[] args) {
        int sceneWidth = 400;
        int sceneHeight = 400;
        int N = 20;
        AlgoVisualizer algoVisualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);
    }
}
