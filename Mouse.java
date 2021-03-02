import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JFrame;

public class Mouse extends MouseAdapter {

  private ObjectHandler h;
  private Main m;
  private String mouseState = "";
  private int x, y;
  private boolean released = true;
  

  public Mouse(ObjectHandler h, Main m) {
    this.h = h;
    this.m = m;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    mouseState = "Clicked";
    released = true;
    x = e.getX();
    y = e.getY();
  }

  @Override
  public void mousePressed(MouseEvent e) {
    mouseState = "Pressed";
    released = false;
    x = e.getX();
    y = e.getY();
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    mouseState = "Dragged";
    released = false;
    x = e.getX();
    y = e.getY();
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    mouseState = "Released";
    released = true;
    x = e.getX();
    y = e.getY();
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    mouseState = "Moved";
    x = e.getX();
    y = e.getY();
  }

  public String getMouseState() {
    return mouseState;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public boolean isReleased() {
    return released;
  }

}

/*
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class Mouse {
  private boolean b1 = false, b2 = false, b3 = false;
  private int clickCount = 0, x = 0, y = 0;

  public Mouse (JPanel w) {
    w.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.NOBUTTON) {
          b1 = false;
          b2 = false;
          b3 = false;
        } else if (e.getButton() == MouseEvent.BUTTON1) {
          b1 = true;
          b2 = false;
          b3 = false;
        } else if (e.getButton() == MouseEvent.BUTTON2) {
          b1 = false;
          b2 = true;
          b3 = false;
        } else if (e.getButton() == MouseEvent.BUTTON3) {
          b1 = false;
          b2 = false;
          b3 = true;
        }

        clickCount = e.getClickCount();
        x = e.getX();
        y = e.getY();
      }

      public void mouseReleased(MouseEvent e) {
        b1 = false;
        b2 = false;
        b3 = false;
      }
    });
  }

  public boolean buttonOneClicked() {
    return b1;
  }

  public boolean buttonTwoClicked() {
    return b2;
  }

  public boolean buttonThreeClicked() {
    return b3;
  }

  public int getButtonClicked() {
      if (b1) {
          return 1;
      } else if (b2) {
          return 2;
      } else if (b3) {
          return 3;
      } else {
          return 0;
      }
  }

  public int getMouseX() {
    return x;
  }

  public int getMouseY() {
    return y;
  }

  public int getClickCount() {
    return clickCount;
  }
}
*/