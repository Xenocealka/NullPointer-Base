package com.xenoceal.cristalix.module;

import com.xenoceal.cristalix.NullPointer;
import com.xenoceal.cristalix.module.categories.Category;
import dev.xdark.clientapi.ClientApi;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Module {

    protected final ClientApi api = NullPointer.INSTANCE.api;

    final String name;
    final Category category;

    boolean isEnabled = false;
    int keyBind = 0; // KEY_NONE

    public void onEnable() {}
    public void onDisable() {}

    // onEvent

    public void onKeyPress(int key) {}
    public void onGameLoop() {}
    public void onGuiOverlayRender() {}

}
