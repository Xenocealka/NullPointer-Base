package com.xenoceal.cristalix.gui;

import com.xenoceal.cristalix.gui.handlers.CloseScreenHandler;
import com.xenoceal.cristalix.gui.handlers.DrawScreenHandler;
import dev.xdark.clientapi.gui.Screen;
import dev.xdark.clientapi.gui.ScreenCloseHandler;
import dev.xdark.clientapi.gui.ScreenDrawHandler;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public final class ClickGui {

    ScreenDrawHandler drawHandler = new DrawScreenHandler();
    ScreenCloseHandler closeHandler = new CloseScreenHandler();

    public Screen getClickGui() {
        return Screen.Builder.builder()
                .draw(drawHandler)
                .close(closeHandler)
                .build();
    }

}
