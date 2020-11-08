package minecraft.ai;

import net.minecraft.item.Item;

/** RecipeLayout.java
 * @author Zackary Nichol
 * An orientation of items that crafts a recipe
 */
public class RecipeLayout {

    public final int recipeSize;

    Item leftTop, leftMid, leftBottom;
    Item midTop, midMid, midBottom;
    Item rightTop, rightMid, rightBottom;

    RecipeLayout(Item leftTop, Item leftMid, Item leftBottm, Item midTop, Item midMid, Item midBottom,
                 Item rightTop, Item rightMid, Item rightBottom, int recipeSize) {
        this.leftTop = leftTop;
        this.leftMid = leftMid;
        this.leftBottom = leftBottm;
        this.midTop = midTop;
        this.midMid = midMid;
        this.midBottom = midBottom;
        this.rightTop = rightTop;
        this.rightMid = rightMid;
        this.rightBottom = rightBottom;

        this.recipeSize = recipeSize;
    }
}
