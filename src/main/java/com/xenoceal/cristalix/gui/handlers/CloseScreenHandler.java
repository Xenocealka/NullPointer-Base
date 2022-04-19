package com.xenoceal.cristalix.gui.handlers;

import com.xenoceal.cristalix.managers.ModuleManager;
import com.xenoceal.cristalix.module.categories.others.Gui;
import dev.xdark.clientapi.gui.Screen;
import dev.xdark.clientapi.gui.ScreenCloseHandler;

public final class CloseScreenHandler
        implements ScreenCloseHandler {

    @Override
    public void close(Screen screen) {
        ModuleManager.getModuleByClass(Gui.class).setEnabled(false);
    }

}
