package com.xenoceal.cristalix.module.categories.combat;

import com.xenoceal.cristalix.module.Module;
import com.xenoceal.cristalix.module.categories.Category;
import com.xenoceal.cristalix.utility.MathUtil;
import com.xenoceal.cristalix.utility.reflection.Mappings;
import dev.xdark.clientapi.entity.Entity;
import lombok.val;
import org.lwjgl.input.Keyboard;

public final class KillAura
        extends Module {

    public KillAura() {
        super("KillAura", Category.COMBAT);
        setKeyBind(Keyboard.KEY_R);
    }

    @Override
    public void onGameLoop() {
        val player = api.minecraft().getPlayer();

        for (val entityPlayer : Mappings.getPlayerEntities())
            if (entityPlayer != null && entityPlayer != player)
                if (MathUtil.getDistanceToEntity(player, (Entity) entityPlayer) <= 6.0D)
                    api.clientConnection().sendPacket(Mappings.CPacketUseEntity((Entity) entityPlayer));
    }

}
