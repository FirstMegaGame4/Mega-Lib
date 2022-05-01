package fr.firstmegagame4.lib;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MegaLib implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("mega-lib");

    @Override
    public void onInitialize() {
        LOGGER.info("Initialize FirstMegaGame4 Library");
    }
}
