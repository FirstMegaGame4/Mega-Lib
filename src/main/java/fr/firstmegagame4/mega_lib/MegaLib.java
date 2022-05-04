package fr.firstmegagame4.mega_lib;

import fr.firstmegagame4.mega_lib.lib.MegaLibModInitializer;

public class MegaLib implements MegaLibModInitializer {
    @Override
    public String getIdentifier() {
        return "mega_lib";
    }

    @Override
    public String getModName() {
        return "Mega Library";
    }

    @Override
    public void onInitialize() {
        this.getLogger().info("Initialize " + this.getModName());;
    }
}
