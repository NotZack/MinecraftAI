package minecraft.ai;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static minecraft.ai.GameLoop._player;

/** PlayerEvents.java
 * @author Zackary Nichol
 * Contains all player event handlers
 */
@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class PlayerEvents {

    /**
     * Handles anytime a living entity jumps
     *
     * @param event The jump event
     */
    @SubscribeEvent()
    public void onEvent(LivingEvent.LivingJumpEvent event) {
        if (event.getEntityLiving() instanceof PlayerEntity) {
            _player.beeStingRemovalCooldown = 1000000;
            _player.getFoodStats().setFoodLevel(0);
            _player.getFoodStats().addExhaustion(1000000);
            Action.checkInventory();
        }
    }

    /**
     * Handles every tick of the player
     *
     * @param event The player tick event
     */
    @SubscribeEvent()
    public void onEvent(TickEvent.PlayerTickEvent event) {
        GameLoop.tick();
    }
}
