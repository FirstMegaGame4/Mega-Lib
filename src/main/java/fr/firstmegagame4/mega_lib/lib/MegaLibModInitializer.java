package fr.firstmegagame4.mega_lib.lib;

import fr.firstmegagame4.mega_lib.MegaLib;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.OverridingMethodsMustInvokeSuper;

public interface MegaLibModInitializer extends ModInitializer {
    String getIdentifier();

    String getModName();

    default Logger getLogger() {
        return LoggerFactory.getLogger(this.getModName());
    }

    @Override
    @OverridingMethodsMustInvokeSuper
    default void onInitialize() {
        if (!this.getIdentifier().equals("mega_lib")) MegaLib.megaLibModIdentifiers.add(this.getIdentifier());
    }
}
