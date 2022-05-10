package fr.firstmegagame4.mega_lib.lib.generation.ores;

import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Block;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;

public class CustomOverworldOre extends CustomOre {
    public CustomOverworldOre(CustomOre ore) {
        this.veinSize = ore.veinSize;
        this.numVeins = ore.numVeins;
        this.minHeight = ore.minHeight;
        this.maxHeight = ore.maxHeight;
    }

    private boolean deepslateOre = false;

    public CustomOverworldOre deepslateOre() {
        this.deepslateOre = true;
        return this;
    }

    public void register(Block block, String generationId) {
        RuleTest ruleTest;
        if (!this.deepslateOre) ruleTest = OreConfiguredFeatures.STONE_ORE_REPLACEABLES;
        else ruleTest = OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES;
        this.registerOre(block, generationId, ruleTest, BiomeSelectors.foundInOverworld());
    }
}