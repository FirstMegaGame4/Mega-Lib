package fr.firstmegagame4.mega_lib.lib.initialization;

import net.fabricmc.api.ClientModInitializer;

import javax.annotation.OverridingMethodsMustInvokeSuper;

public interface MegaLibClientModInitializer extends ClientModInitializer {
    ScreensInitializer getScreensInitializer();

    @Override
    @OverridingMethodsMustInvokeSuper
    default void onInitializeClient() {
        this.getScreensInitializer().register();
    }
}
