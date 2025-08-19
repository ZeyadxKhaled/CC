package io.github.itzispyder.clickcrystals.scripting.syntax.client;

import io.github.itzispyder.clickcrystals.ClickCrystals;
import io.github.itzispyder.clickcrystals.Global;
import io.github.itzispyder.clickcrystals.scripting.ScriptArgs;
import io.github.itzispyder.clickcrystals.scripting.ScriptCommand;

// @Format config (save|load|reload)
public class ConfigCmd extends ScriptCommand implements Global {

    public ConfigCmd() {
        super("config");
    }

    @Override
    public void onCommand(ScriptCommand command, String line, ScriptArgs args) {
        switch (args.get(0).toEnum(Type.class, null)) {
            case SAVE -> saveEntireConfig();
            case LOAD -> ClickCrystals.config.loadEntireConfig();
            case RELOAD -> {
                saveEntireConfig();
                ClickCrystals.config.loadEntireConfig();
            }
        }

        if (args.match(1, "then")) {
            args.executeAll(2);
        }
    }

    public static void saveEntireConfig() {
        system.println("-> saving data");
        ClickCrystals.config.saveModules();
        ClickCrystals.config.saveKeybinds();
        ClickCrystals.config.saveHuds();
        system.println("-> saving config");
        ClickCrystals.config.save();
    }

    public enum Type {
        SAVE,
        LOAD,
        RELOAD
    }
}
