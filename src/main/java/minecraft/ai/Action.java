package minecraft.ai;

import net.minecraft.item.Item;

/** Action.java
 * @author Zackary Nichol
 * Low level direct keyboard mouse game interactions
 */
public class Action {

    public void jump() {

    }

    public void move(boolean sprinting) {

    }

    public void findBlock() {

    }

    public void breakBlock() {

    }

    public void attack() {

    }

    public static boolean checkInventory(Item itemToMove) {
        return false;
    }

    public static void eat() {
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

    public void moveToBlock() {

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
}
