package fr.firstmegagame4.mega_lib;

import fr.firstmegagame4.mega_lib.lib.MegaLibModInitializer;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MegaLib implements MegaLibModInitializer {
    public static final List<String> megaLibModIdentifiers = new ArrayList<>();

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
        MegaLibModInitializer.super.onInitialize();
        this.getLogger().info("Initialize " + this.getModName());
        String modList = "Mega Library Mods :";
        for (String modIdentifier: megaLibModIdentifiers) {
            modList = modList.concat(" " + modIdentifier + ",");
        }
        modList = StringUtils.chop(modList);
        this.getLogger().info(modList);
    }

}
