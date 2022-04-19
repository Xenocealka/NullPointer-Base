package com.xenoceal.cristalix.utility;

import dev.xdark.clientapi.entity.Entity;
import dev.xdark.clientapi.entity.EntityPlayerSP;
import lombok.experimental.UtilityClass;
import lombok.val;

@UtilityClass
public class MathUtil {

    public double getDistanceToEntity(EntityPlayerSP player, Entity entity) {
        val x = player.getX() - entity.getX();
        val y = player.getY() - entity.getY();
        val z = player.getZ() - entity.getZ();
        return Math.sqrt(x * x + y * y + z * z);
    }

}
