package minecraft.ai;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.IItemHandler;
import org.lwjgl.system.CallbackI;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Action {

    public static void jump() {
   /*     robot.delay(1000);
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.delay(1000);*/
    }

    public static void move(boolean sprinting) {

    }

    public static void findBlock() {

    }

    public static void breakBlock() {
    }

    ////
    public static void attack() {

    }


    private static boolean hasSwapped = false;

    /**
     * Equips the item or itemstack of the given type and moves the currently equipped item to a different square.
     *
     * @param
     * @return True if the item was found and moved, else false.
     */
    public static boolean checkInventory(Item item) {
        if (hasSwapped) {
            hasSwapped = false;
            return true;
        }
        PlayerEntity player = Minecraft.getInstance().player;

        if (item.getName().getString().equals(player.inventory.mainInventory.get(0).getItem().getName().getString())) {
            return true;
        }

        for (int i = 0; i < 36; i++) {
            ItemStack seachedItem = player.inventory.mainInventory.get(i);
            if (seachedItem.getItem().getName().getString().equals(item.getName().getString())) {

                System.out.println("Found item: " + seachedItem.getItem().getName().getString());
                ItemStack bufferItem = player.inventory.mainInventory.get(0);

                player.inventory.mainInventory.set(0, seachedItem);
                player.inventory.mainInventory.set(i, bufferItem);

                hasSwapped = true;
                return true;
            }
        }
        return false;
    }


    public static void eat() {

    }

    public static void placeBlock() {

    }

    public static void craft() {

    }

    public static void moveToBlock() {

    }
}
