package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;
    public boolean plusPressed;
    public boolean minusPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code==KeyEvent.VK_UP){
            upPressed = true;
        }
        if (code==KeyEvent.VK_DOWN){
            downPressed = true;
        }
        if (code==KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        if (code==KeyEvent.VK_RIGHT){
            rightPressed = true;
        }
        if (code==KeyEvent.VK_Q){
            plusPressed = true;
        }
        if (code==KeyEvent.VK_W){
            minusPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code==KeyEvent.VK_UP){
            upPressed = false;
        }
        if (code==KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if (code==KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if (code==KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
        if (code==KeyEvent.VK_Q){
            plusPressed = false;
        }
        if (code==KeyEvent.VK_W){
            minusPressed = false;
        }
    }
}
