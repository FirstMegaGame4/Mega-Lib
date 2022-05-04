package fr.firstmegagame4.mega_lib.lib;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface MegaLibModInitializer extends ModInitializer {
    String getIdentifier();

    String getModName();

    default Logger getLogger() {
        return LoggerFactory.getLogger(this.getModName());
    }
}
