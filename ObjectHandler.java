import java.util.ArrayList;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

public class ObjectHandler {
    public ArrayList<Circle> circles = new ArrayList<Circle>();
    private int width, height;

    public ObjectHandler(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addCircle(Circle c) {
        circles.add(c);
    }

    public void update() {
        int[] xs = new int[circles.size()];
        int[] ys = new int[circles.size()];

        for (Circle circle: circles) {
            if (!circle.stop) {
                if (circles.size() > 1) {
                    if (circle.getY() < height - 20) {
                        circle.setY(circle.getY() + 1);
                        for (Circle c1: circles) {
                            if (collides(circle, c1)) {
                                circle.stop();
                                break;
                            }
                        }
                    }
                } else {
                    if (circle.getY() < height - 20) {
                        circle.setY(circle.getY() + 1);
                    }
                }
            }
        }
    }

    public void draw(Graphics g) {
        for (Circle circle: circles) {
            circle.draw(g);
        }
    }

    public boolean collides(Circle c1, Circle c2) {
        int c1x = c1.getX();
        int c1y = c1.getY();
        int c1r = c1.getWidth() / 2;
        int c2x = c2.getX();
        int c2y = c2.getY();
        int c2r = c2.getWidth() / 2;

        int C1C2 = (int) Math.sqrt(Math.pow(c1x - c2x, 2) + Math.pow(c1y - c2y, 2));
 
        if (C1C2 == c1r + c2r) {
            return true; 
        }
        else if (C1C2 > c1r + c2r) { 
            return false; 
        }
        else {
            return false;
        }
    }
}