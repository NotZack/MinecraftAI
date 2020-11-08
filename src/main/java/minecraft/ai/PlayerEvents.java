package minecraft.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/** PlayerEvents.java
 * @author Zackary Nichol
 * Contains all player event handlers
 */
@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class PlayerEvents {

    /**
     * Handles anytime a living entity jumps
     * @param event The jump event
     */
    @SubscribeEvent()
    public void onEvent(LivingEvent.LivingJumpEvent event)
    {
        if (event.getEntityLiving() instanceof PlayerEntity) {

        }
    }

    /**
     * Handles every tick of the player
     * @param event The player tick event
     */
    @SubscribeEvent()
    public void onEvent(TickEvent.PlayerTickEvent event) {
        GameLoop.tick();
    }
}
