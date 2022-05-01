package fr.firstmegagame4.lib;

import fr.firstmegagame4.lib.generation.ores.CustomOre;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MegaLib implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Mega Lib");

    @Override
    public void onInitialize() {
        LOGGER.info("Initialize FirstMegaGame4 Library");
        new CustomOre().setVeinSize(4).setNumVeins(12).setMinHeight(12).setMaxHeight(48).overworldOre().register(Blocks.BLACK_WOOL, "black_wool");
    }
}
