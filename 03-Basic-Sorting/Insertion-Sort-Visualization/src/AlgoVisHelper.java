import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * 算法可视化辅助类
 */
public class AlgoVisHelper {
    /**
     * 这个类是一个辅助的工具类，为了让算法可视化的调用更简单
     * 语义更明确
     * 不让外部实例化，这个类所有对外的方法都是静态方法
     */
    private AlgoVisHelper() {
    }


    /**
     * Google 公司风格的颜色
     */
    public static final Color Red = new Color(0xF44336);
    public static final Color Pink = new Color(0xE91E63);
    public static final Color Purple = new Color(0x9C27B0);
    public static final Color DeepPurple = new Color(0x673AB7);
    public static final Color Indigo = new Color(0x3F51B5);
    public static final Color Blue = new Color(0x2196F3);
    public static final Color LightBlue = new Color(0x03A9F4);
    public static final Color Cyan = new Color(0x00BCD4);
    public static final Color Teal = new Color(0x009688);
    public static final Color Green = new Color(0x4CAF50);
    public static final Color LightGreen = new Color(0x8BC34A);
    public static final Color Lime = new Color(0xCDDC39);
    public static final Color Yellow = new Color(0xFFEB3B);
    public static final Color Amber = new Color(0xFFC107);
    public static final Color Orange = new Color(0xFF9800);
    public static final Color DeepOrange = new Color(0xFF5722);
    public static final Color Brown = new Color(0x795548);
    public static final Color Grey = new Color(0x9E9E9E);
    public static final Color BlueGrey = new Color(0x607D8B);
    public static final Color Black = new Color(0x000000);
    public static final Color White = new Color(0xFFFFFF);

    /**
     * 画一个空心圆 stroke 表示绘制边框，这里就是空心的意思
     *
     * @param g
     * @param x
     * @param y
     * @param r
     */
    public static void strokeCircle(Graphics2D g, int x, int y, int r) {
        /**
         * 我们期望设置圆心坐标和圆的半径来画图
         */
        Ellipse2D circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
        // draw 表示画线条
        g.draw(circle);
        // g.drawOval(50,50,300,300);

    }

    /**
     * 绘制实心圆
     *
     * @param g
     * @param x
     * @param y
     * @param r
     */
    public static void fillCircle(Graphics2D g, int x, int y, int r) {
        Ellipse2D circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
        // fill 表示填充
        g.fill(circle);
    }

    /**
     * 绘制空心矩形
     * @param g
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public static void strokeRectangle(Graphics2D g, int x, int y, int w, int h){
        Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
        g.draw(rectangle);
    }

    /**
     * 绘制实心矩形
     * @param g
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public static void fillRectangle(Graphics2D g, int x, int y, int w, int h){
        Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
        g.fill(rectangle);
    }


    public static void setColor(Graphics2D g, Color color) {
        // 基于状态设置颜色
        g.setColor(color);
    }

    // 设置笔画的宽度
    public static void setStrokeWidth(Graphics2D g, int w) {
        int strokeWidth = w;
        // BasicStroke.CAP_ROUND
        // BasicStroke.JOIN_ROUND
        g.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }

    public static void pause(int t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 绘制图片
     * @param g
     * @param x
     * @param y
     * @param imageURL
     */
    public static void putImage(Graphics2D g, int x, int y, String imageURL){

        ImageIcon icon = new ImageIcon(imageURL);
        Image image = icon.getImage();

        g.drawImage(image, x, y, null);
    }

    /**
     * 绘制文字
     * @param g
     * @param text
     * @param centerx
     * @param centery
     */
    public static void drawText(Graphics2D g, String text, int centerx, int centery){

        if(text == null)
            throw new IllegalArgumentException("Text is null in drawText function!");

        FontMetrics metrics = g.getFontMetrics();
        int w = metrics.stringWidth(text);
        int h = metrics.getDescent();
        g.drawString(text, centerx - w/2, centery + h);
    }


}
