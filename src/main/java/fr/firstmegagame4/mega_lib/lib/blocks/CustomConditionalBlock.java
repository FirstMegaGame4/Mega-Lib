package fr.firstmegagame4.mega_lib.lib.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.item.ItemGroup;

public class CustomConditionalBlock extends AbstractConditionalBlock implements ConditionalBlock<CustomBlock> {
    private CustomBlock block = null;

    public CustomConditionalBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    public CustomConditionalBlock(AbstractBlock.Settings settings, boolean hasItem) {
        super(settings, hasItem);
    }

    public CustomConditionalBlock(AbstractBlock.Settings settings, boolean hasItem, ItemGroup itemGroup) {
        super(settings, hasItem, itemGroup);
    }

    @Override
    public CustomBlock create() {
        return this.block = new CustomBlock(this.settings, this.hasItem, this.itemGroup);
    }

    @Override
    public CustomBlock getIfCreated() {
        return this.block;
    }
}
