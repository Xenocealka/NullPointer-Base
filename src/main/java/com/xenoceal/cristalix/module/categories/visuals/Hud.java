package com.xenoceal.cristalix.module.categories.visuals;

import com.xenoceal.cristalix.module.Module;
import com.xenoceal.cristalix.module.categories.Category;

public final class Hud
        extends Module {

    public Hud() {
        super("Hud", Category.VISUALS);
        setEnabled(true);
    }

    @Override
    public void onGuiOverlayRender() {
        api.fontRenderer().drawStringWithShadow("NullPointer-Base for Cristalix v1.0", 2.0F, 2.0F, -1);
    }

}
