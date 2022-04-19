package com.xenoceal.cristalix.module.categories.others;

import com.xenoceal.cristalix.gui.ClickGui;
import com.xenoceal.cristalix.module.Module;
import com.xenoceal.cristalix.module.categories.Category;
import org.lwjgl.input.Keyboard;

public final class Gui
        extends Module {

    private ClickGui clickGui;

    public Gui() {
        super("ClickGui", Category.OTHERS);
        setKeyBind(Keyboard.KEY_RSHIFT);
    }

    @Override
    public void onEnable() {
        if (clickGui == null)
            clickGui = new ClickGui();
        api.minecraft().displayScreen(clickGui.getClickGui());
    }

}
