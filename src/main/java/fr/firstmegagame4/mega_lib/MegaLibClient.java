package fr.firstmegagame4.mega_lib;

import fr.firstmegagame4.mega_lib.lib.initialization.MegaLibClientModInitializer;
import net.fabricmc.api.Environment;

@Environment(net.fabricmc.api.EnvType.CLIENT)
public abstract class MegaLibClient implements MegaLibClientModInitializer {
    @Override
    public void onInitializeClient() {
        MegaLibClientModInitializer.super.onInitializeClient();
    }
}
