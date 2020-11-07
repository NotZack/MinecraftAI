package minecraft.ai;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Action {

    Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void jump() {
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.delay(1000);
    }

    public void move(boolean sprinting) {

    }

    public void findBlock() {

    }

    public void breakBlock() {

    }

    public void attack() {

    }

    public void checkInventory() {

    }

    public void eat() {

    }

    public void placeBlock() {

    }

    public void craft() {

    }

    public void moveToBlock() {

    }
}
