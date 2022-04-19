package com.xenoceal.cristalix;

import com.xenoceal.cristalix.managers.ModuleManager;
import com.xenoceal.cristalix.utility.reflection.Reflection;
import dev.xdark.clientapi.ClientApi;
import dev.xdark.clientapi.entry.ModMain;
import dev.xdark.clientapi.event.Listener;
import dev.xdark.clientapi.event.input.KeyPress;
import dev.xdark.clientapi.event.lifecycle.GameLoop;
import dev.xdark.clientapi.event.render.GuiOverlayRender;
import lombok.val;

public final class NullPointer
        implements ModMain, Listener {

    public static final NullPointer INSTANCE = new NullPointer();

    public ClientApi api;

    @Override
    public void load(ClientApi api) {
        this.api = api;

        Reflection.initialize();
        ModuleManager.initialize();

        KeyPress.BUS.register(this, keyPress -> {
            val key = keyPress.getKey();

            for (val module : ModuleManager.getModules()) {
                if (key == module.getKeyBind()) {
                    module.setEnabled(!module.isEnabled());

                    if (module.isEnabled())
                        module.onEnable();
                    else
                        module.onDisable();
                }

                module.onKeyPress(key);
            }
        }, 0);

        GameLoop.BUS.register(this, gameLoop -> {
            val player = api.minecraft().getPlayer();
            val world = api.minecraft().getWorld();

            if (player == null || world == null)
                return;

            for (val module : ModuleManager.getModules())
                if (module.isEnabled())
                    module.onGameLoop();
        }, 0);

        GuiOverlayRender.BUS.register(this, guiOverlayRender -> {
            for (val module : ModuleManager.getModules())
                if (module.isEnabled())
                    module.onGuiOverlayRender();
        }, 0);

    }

    @Override
    public void unload() {}

}
