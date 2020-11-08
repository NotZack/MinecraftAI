package minecraft.ai;

import net.minecraft.block.Block;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import static minecraft.ai.GameLoop._player;

/** Action.java
 * @author Zackary Nichol
 * Low level direct keyboard mouse game interactions
 */
public class Action {

    public void jump() {

    }

    public static void move(boolean sprinting) {

    }

    public static void findBlock() {

    }

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

    public static void eat(PlayerEntity player)
    {
        if(player.getFoodStats().needFood())
        {
            Item apple = Item.getItemById(260);
            player.getEatSound(player.inventory.mainInventory.get(0));
            player.getFoodStats().consume(apple, player.inventory.getItemStack());
            World world = player.world;

            if(!Action.checkInventory(apple))
            {
                Item bread = Item.getItemById(297);
                if(Action.checkInventory(bread))
                {
                    player.getEatSound(player.inventory.mainInventory.get(0));
                    player.getFoodStats().consume(bread, player.inventory.getItemStack());
                }
            }

            else
            {
                player.getEatSound(player.inventory.mainInventory.get(0));
                player.getFoodStats().consume(apple, player.inventory.getItemStack());
            }


        }

    }

    /**
     * Places the given block if in inventory to the given coordinates
     * @param blockToPlace The block to place
     * @param x The x coord to put the given block at
     * @param y THe y coord to put the given block at
     * @return If the block was successfully placed or not
     */
    public boolean placeBlock(Item blockToPlace, double x, double y) {
        if (checkInventory(blockToPlace)) {
            lookToBlock(x, y);
            //place block
            return true;
        }
        else {
            return false;
        }
    }

    private void lookToBlock(double x, double y) {

    }

    /**
     * Crafts the given recipe
     * @param toCraft The recipe to craft
     */
    public static void craft(RecipeLayout toCraft) {
        moveToCraftingInventory(toCraft.leftTop, 0, 0);
        moveToCraftingInventory(toCraft.leftMid, 1, 0);
        moveToCraftingInventory(toCraft.leftBottom, 2, 0);

        moveToCraftingInventory(toCraft.midTop, 0, 1);
        moveToCraftingInventory(toCraft.midMid, 1, 1);
        moveToCraftingInventory(toCraft.midBottom, 2, 1);

        moveToCraftingInventory(toCraft.rightTop, 0, 2);
        moveToCraftingInventory(toCraft.rightMid, 1, 2);
        moveToCraftingInventory(toCraft.rightBottom, 2, 2);

        //move from final crafting box
    }

    public static void placeBlock() {

    }

    public static void moveToBlock() {

    }

    /**
     * Moves the given item to the given crafting inventory coordinate
     * @param toMove The item to move
     * @param x The crafting inventory row
     * @param y The crafting inventory column
     */
    private static void moveToCraftingInventory(Item toMove, int x, int y) {
        if (toMove == null) {
            return;
        }
        else {
            //do it
        }
    }

    public static void breakBlock()
    {
        RayTraceResult inView = Minecraft.getInstance().objectMouseOver;
        World world = _player.world;

        System.out.println(inView.getHitVec().x);
        System.out.print(inView.getHitVec().y);
        System.out.print(inView.getHitVec().z);

        world.destroyBlock(new BlockPos(inView.getHitVec()), true);

        Block toDestroy = world.getBlockState(new BlockPos(inView.getHitVec())).getBlock();
        //toDestroy.harvestBlock(world, _player, new BlockPos(inView.getHitVec()), toDestroy.getDefaultState(), null, _player.inventory.);
    }
}
