package minecraft.ai;

import com.google.common.eventbus.Subscribe;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/** minecraft.ai.PlayerEvents.java
 * @author Zackary Nichol
 * Contains all player event handlers
 */
@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class PlayerEvents {

    @SubscribeEvent()
    public void onEvent(LivingEvent.LivingJumpEvent event){
        if(event.getEntityLiving() instanceof PlayerEntity){

            System.out.println("Triggering player event");
            Action.checkInventory();
        }
    }
}
