import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable {
    Window w;
    ObjectHandler h;
    Thread thread;
    Mouse m;
    boolean running, released = true;
    int tick = 100, tickCount = 0;
    int createWait = 500, createCount = 0;
    int circleCount = 0, circleMax = 1000;

    public Main() {
        w = new Window();
        h = new ObjectHandler(w.WIDTH, w.HEIGHT);
        m = new Mouse(h, this);
        start();
        //w.getFrame().addMouseListener(m);
        //w.getFrame().addMouseMotionListener(m);
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (running) {
            if (createCount == createWait && circleCount != circleMax) {
                h.addCircle(new Circle((int) Math.round(Math.random() * (w.WIDTH - 40) + 20), (int) Math.round(Math.random() * (w.HEIGHT - 40) + 20), 10, 10));
                createCount = 0;
                circleCount++;
            } else {
                createCount++;
            }
            if (tickCount == tick) {
                update();
                draw();
                tickCount = 0;
            } else {
                tickCount++;
            }
        }
        stop();
    }

    public void update() {
        String mouseState = m.getMouseState();
        h.update();

        if (mouseState.equals("Pressed") && released) {
            h.addCircle(new Circle(m.getX() - 5, m.getY() - 5, 10, 10));
            released = false;
        } else if (m.isReleased()) {
            released = true;
        }
    }

    public void draw() {
        BufferStrategy bs = w.getFrame().getBufferStrategy();
        if (bs == null) {
            w.getFrame().createBufferStrategy(2);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, w.WIDTH, w.HEIGHT);
        h.draw(g);
        g.dispose();
        bs.show();
    }
    public static void main(String[] args) {
        new Main();
    }
}
