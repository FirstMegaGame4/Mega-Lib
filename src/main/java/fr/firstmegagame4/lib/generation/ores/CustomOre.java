package fr.firstmegagame4.lib.generation.ores;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.minecraft.block.Block;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.Arrays;
import java.util.function.Predicate;

public class CustomOre {

    protected int veinSize;
    protected int numVeins;
    protected int minHeight;
    protected int maxHeight;

    public CustomOre setVeinSize(int veinSize) {
        this.veinSize = veinSize;
        return this;
    }

    public CustomOre setNumVeins(int numVeins) {
        this.numVeins = numVeins;
        return this;
    }

    public CustomOre setMinHeight(int minHeight) {
        this.minHeight = minHeight;
        return this;
    }

    public CustomOre setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
        return this;
    }

    public CustomOverworldOre overworldOre() {
        return new CustomOverworldOre(this);
    }

    public CustomNetherOre netherOre() {
        return new CustomNetherOre(this);
    }

    public CustomEnderOre enderOre() {
        return new CustomEnderOre(this);
    }

    protected void registerOre(Block block, String blockId, RuleTest ruleTest, Predicate<BiomeSelectionContext> biomeSelectionContextPredicate) {

        Identifier generationIdentifier = new Identifier("mega_lib", blockId + "_generation");

        ConfiguredFeature<?, ?> configuredFeature = new ConfiguredFeature<>(
                Feature.ORE, new OreFeatureConfig(ruleTest, block.getDefaultState(), this.veinSize
        ));

        PlacedFeature placedFeature = new PlacedFeature(
                RegistryEntry.of(configuredFeature), Arrays.asList(
                CountPlacementModifier.of(this.numVeins),
                SquarePlacementModifier.of(),
                HeightRangePlacementModifier.uniform(YOffset.fixed(this.minHeight), YOffset.fixed(this.maxHeight))
        ));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, generationIdentifier, configuredFeature);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, generationIdentifier, placedFeature);

        BiomeModifications.addFeature(biomeSelectionContextPredicate, GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY, generationIdentifier));

    }

}
