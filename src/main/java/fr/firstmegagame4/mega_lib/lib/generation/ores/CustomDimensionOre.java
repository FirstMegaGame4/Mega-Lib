package fr.firstmegagame4.mega_lib.lib.generation.ores;

import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

public class CustomDimensionOre extends CustomOre {
    private final Identifier dimensionIdentifier;

    public CustomDimensionOre(CustomOre ore, Identifier identifier) {
        this.veinSize = ore.veinSize;
        this.numVeins = ore.numVeins;
        this.minHeight = ore.minHeight;
        this.maxHeight = ore.maxHeight;

        this.dimensionIdentifier = identifier;
    }

    public void register(Block block, String generationId) {
        if (this.dimensionIdentifier != null) {
            this.registerOre(block, generationId, null, context -> context.canGenerateIn(RegistryKey.of(Registry.DIMENSION_KEY, this.dimensionIdentifier)));
        }
    }
}
