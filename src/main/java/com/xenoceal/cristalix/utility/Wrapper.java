package com.xenoceal.cristalix.utility;

import com.xenoceal.cristalix.NullPointer;
import dev.xdark.clientapi.ClientApi;
import dev.xdark.clientapi.world.World;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Wrapper {

    private final ClientApi api = NullPointer.INSTANCE.api;

    public World getWorld() {
        return api.minecraft().getWorld();
    }

}
