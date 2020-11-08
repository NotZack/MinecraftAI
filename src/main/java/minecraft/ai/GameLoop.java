package minecraft.ai;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;

/** GameLoop.java
 * @author Zackary Nichol
 * The state machine containing the high level AI logic
 */
public class GameLoop {

    public static PlayerEntity _player;

    /**
     * Is called during every player tick event.
     */
    static void tick() {
        if (_player != null && _player.isAlive()) {
            _player.setMotion(_player.getLookVec().getX(), _player.getLookVec().getY(), _player.getPosZ());
        }
        else {
            _player = Minecraft.getInstance().player;
        }
    }
}