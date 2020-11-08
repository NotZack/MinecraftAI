import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.IItemHandler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Action {


    Robot robot;

    {
        try {
            Robot robot = new Robot();
        } catch (Exception e) {

        }
    }

    public void jump() {

    }

    public void move(boolean sprinting) {

    }

    public void findBlock() {

    }

    ////
    public void breakBlock() {
        robot.mousePress(1);
    }

    ////
    public void attack() {
        robot.mousePress(MouseEvent.BUTTON1);
        robot.delay(100);
        robot.mouseRelease(MouseEvent.BUTTON1);
    }

    /**
     * Returns true and equips the item or itemstack with the given name.
     * @param name
     * @return
     */
    public boolean checkInventory(String name) {
        robot.keyPress(KeyEvent.VK_E);
        // Open inventory
        // look at each inventory slot
        PlayerEntity player = Minecraft.getInstance().player;
        for (int i = 0; i < 36; i++) {
            //If the name of the item matches what we want
            ItemStack seachedItem = player.inventory.mainInventory.get(i);
            if (seachedItem.getDisplayName().getString().equals(name)) {
                double centerWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
                double centerHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

                //A box is around 54 pixels across.
                double originWidth = centerWidth - (4.5 * 54);

                //Its possible that the origin is a different square than what im thinking...

                double originHeight = centerHeight + (54 / 2);


                double boxLocationX = originWidth + (i % 9) * 54;
                double boxLocationY = originHeight + /*Or minus */ i / 9;

                robot.mouseMove((int) boxLocationX, (int) boxLocationY);
                // click this square
                robot.mousePress(MouseEvent.BUTTON1);

                // move cursor to the first inventory slot
                robot.mouseMove((int) originWidth, (int) originHeight + (4 * 54));
                //click that square
                robot.mousePress(MouseEvent.BUTTON1);

                //if there is still an item under the cursor
                if (!player.inventory.getCurrentItem().isEmpty()) {
                    robot.mouseMove((int) boxLocationX, (int) boxLocationY);
                }
                robot.mousePress(MouseEvent.BUTTON1);
                robot.keyPress(KeyEvent.VK_E);
                return true;
            }
        }
        robot.keyPress(KeyEvent.VK_E);
        return false;
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
