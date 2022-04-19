package com.xenoceal.cristalix.utility.reflection;

import com.xenoceal.cristalix.utility.Wrapper;
import dev.xdark.clientapi.entity.Entity;
import dev.xdark.clientapi.network.Packet;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class Mappings {

    public List<?> getPlayerEntities() {
        return Reflection.invokeMethod("playerEntities", Wrapper.getWorld());
    }

    public Packet<?> CPacketUseEntity(Entity entity) {
        return Reflection.invokeMethod("CPacketUseEntity", entity);
    }

}
