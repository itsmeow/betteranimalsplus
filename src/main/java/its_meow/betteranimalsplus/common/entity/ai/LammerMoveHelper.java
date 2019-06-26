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
            return;
        }


        Vec3d vec = new Vec3d(this.posX - this.parentEntity.posX, this.posY - this.parentEntity.posY, this.posZ - this.parentEntity.posZ);
        vec = vec.normalize();
        if(vec.length() < 2) {
            this.action = Action.WAIT;
        }
        this.parentEntity.setMotion(vec.scale(0.25D));
    }

}