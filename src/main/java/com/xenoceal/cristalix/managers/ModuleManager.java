package com.xenoceal.cristalix.managers;

import com.xenoceal.cristalix.module.Module;
import com.xenoceal.cristalix.module.categories.combat.KillAura;
import com.xenoceal.cristalix.module.categories.others.Gui;
import com.xenoceal.cristalix.module.categories.visuals.Hud;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import lombok.val;

import java.util.HashSet;
import java.util.Set;

@UtilityClass
public class ModuleManager {

    @Getter
    private final Set<Module> modules = new HashSet<>();

    public void initialize() {
        modules.add(new Hud());
        modules.add(new KillAura());
        modules.add(new Gui());
    }

    public Module getModuleByName(String name) {
        for (val module : modules)
            if (module.getName().equals(name))
                return module;
        return null;
    }

    public Module getModuleByClass(@NonNull Class<? extends Module> clazz) {
        for (val module : modules)
            if (module.getClass() == clazz)
                return module;
        return null;
    }

}
