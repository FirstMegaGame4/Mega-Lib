package fr.firstmegagame4.mega_lib;

import net.fabricmc.api.ModInitializer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MegaLib implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Mega Library");
    public static final List<String> megaLibModIdentifiers = new ArrayList<>();

    public String getModName() {
        return "Mega Library";
    }

    public void onInitialize() {
        LOGGER.info("Initialize " + this.getModName());
        String modList = "Mega Library Mods :";
        for (String modIdentifier: megaLibModIdentifiers) {
            modList = modList.concat(" " + modIdentifier + ",");
        }
        modList = StringUtils.chop(modList);
        LOGGER.info(modList);
    }
}
