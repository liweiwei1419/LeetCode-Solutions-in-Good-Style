import javax.swing.*;
import java.awt.*;

public class AlgoFrame extends JFrame {

    private int canvasWidth;
    private int canvasHeight;

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    private SelectionSortData data;

    public void render(SelectionSortData data) {
        // 把数据对象传进来
        this.data = data;
        // 将 JFrame 中所有的控件重新刷新一遍
        this.repaint();
    }


    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas algoCanvas = new AlgoCanvas();
        setContentPane(algoCanvas);

        // 进行布局的整理
        // 自动调整 AlgoFrame 窗口的大小
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public AlgoFrame(String title) {
        this(title, 1024, 768);
    }


    // 写一个内部类，实现绘图画布的功能
    // 这个类是私有的，外部不能使用
    private class AlgoCanvas extends JPanel {
        // 设置双缓存（图形渲染优化）
        public AlgoCanvas() {
            super(true);
        }


        // 具体绘制的代码
        // 使用 Graphics 对象完成绘图的功能
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // 计算机图形学相关内容
            // 设置抗锯齿效果
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );
            hints.put(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);
            // 设置抗锯齿效果

            // 具体绘制
            // AlgoVisHelper.setStrokeWidth(g2d, 1);
            AlgoVisHelper.setColor(g2d, Color.BLUE);

            int dataLength = data.N();
            // 最好是整除，这样画出来的矩形比较均匀
            int width = canvasWidth / dataLength;
            for (int i = 0; i < dataLength; i++) {
                int number = data.get(i);
                if (i < data.sortedIndex) {
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Red);
                } else {
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.BlueGrey);
                }
                if (i == data.currentComparedIndex) {
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Cyan);
                }
                if (i == data.currentMinIndex) {
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Indigo);
                }
                AlgoVisHelper.fillRectangle(g2d, width * i, canvasHeight - number, width - 2, number);
            }
        }

        // 返回画布的大小
        // 这里写了，上面有一步，设置 panel 的窗口就不用写了
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}