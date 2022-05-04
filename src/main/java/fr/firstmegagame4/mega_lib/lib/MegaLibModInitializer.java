package fr.firstmegagame4.mega_lib.lib;

import fr.firstmegagame4.mega_lib.MegaLib;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface MegaLibModInitializer extends ModInitializer {
    String getIdentifier();

    String getModName();

    default Logger getLogger() {
        return LoggerFactory.getLogger(this.getModName());
    }

    default void registerMegaLibMod() {
        MegaLib.megaLibModIdentifiers.add(this.getIdentifier());
    }
}
