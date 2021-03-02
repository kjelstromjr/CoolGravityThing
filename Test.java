import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Test {

    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private Mouse m;

    private double screenWidth = 1.5;
    private double screenHeight = 1.5;
    private int screenX;
    private int screenY;

    public Test() {
        frame = new JFrame();
        panel = new JPanel();
        label = new JLabel("You clicked the screen!");
        m = new Mouse(panel);

        panel.add(label);
        //panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        frame.add(panel);
		//frame.pack();
        frame.setSize((int) (screenSize.getWidth() / screenWidth), (int) (screenSize.getHeight() / screenHeight));
        screenX = (int) ((screenSize.getWidth() / 2) - (screenSize.getWidth() / (screenWidth * 2)));
        screenY = (int) ((screenSize.getHeight() / 2) - (screenSize.getHeight() / (screenHeight * 2)));
        frame.setLocation(screenX, screenY);
		frame.setVisible(true);
        frame.setTitle("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Test();
        
    }
}