package its_meow.betteranimalsplus.common.entity.ai;

import its_meow.betteranimalsplus.common.entity.EntityLammergeier;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.util.math.Vec3d;

public class LammerMoveHelper extends MovementController {

    private final EntityLammergeier parentEntity;

    public LammerMoveHelper(EntityLammergeier lam) {
        super(lam);
        this.parentEntity = lam;
    }

    public void tick() {
        if (this.action != MovementController.Action.MOVE_TO) {
            this.parentEntity.setMotion(0, 0, 0);
            return;
        }


        Vec3d vec = new Vec3d(this.posX - this.parentEntity.getPosX(), this.posY - this.parentEntity.getPosY(), this.posZ - this.parentEntity.getPosZ());
        vec = vec.normalize();
        if(vec.length() < 2) {
            this.action = Action.WAIT;
        }
        this.parentEntity.setMotion(vec.scale(0.25D));
    }

}