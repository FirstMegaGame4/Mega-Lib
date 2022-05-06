package fr.firstmegagame4.mega_lib.lib.generation.ores;

import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;

public class CustomNetherOre extends CustomOre {
    public CustomNetherOre(CustomOre ore) {
        this.veinSize = ore.veinSize;
        this.numVeins = ore.numVeins;
        this.minHeight = ore.minHeight;
        this.maxHeight = ore.maxHeight;
    }

    public void register(Block block) {
        this.registerOre(block, OreConfiguredFeatures.NETHERRACK, BiomeSelectors.foundInTheNether());
    }
}
