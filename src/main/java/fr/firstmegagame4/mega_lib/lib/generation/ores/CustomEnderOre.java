package fr.firstmegagame4.mega_lib.lib.generation.ores;

import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;

public class CustomEnderOre extends CustomOre {
    public CustomEnderOre(CustomOre ore) {
        this.veinSize = ore.veinSize;
        this.numVeins = ore.numVeins;
        this.minHeight = ore.minHeight;
        this.maxHeight = ore.maxHeight;
    }

    public void register(Block block, String generationId) {
        this.registerOre(block, generationId, new BlockMatchRuleTest(Blocks.END_STONE), BiomeSelectors.foundInTheEnd());
    }
}
