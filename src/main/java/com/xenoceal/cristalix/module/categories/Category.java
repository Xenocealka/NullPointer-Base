package com.xenoceal.cristalix.module.categories;

import lombok.Getter;

public enum Category {

    COMBAT("Combat"), MOVEMENT("Movement"), PLAYER("Player"), VISUALS("Visuals"), OTHERS("Others");

    @Getter
    private final String name;

    Category(final String name) {
        this.name = name;
    }

}
