package fr.firstmegagame4.mega_lib.lib.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.item.ItemGroup;

public class CustomConditionalBlock extends AbstractConditionalBlock implements ConditionalBlock<CustomBlock> {
    protected CustomConditionalBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    protected CustomConditionalBlock(AbstractBlock.Settings settings, boolean hasItem) {
        super(settings, hasItem);
    }

    protected CustomConditionalBlock(AbstractBlock.Settings settings, boolean hasItem, ItemGroup itemGroup) {
        super(settings, hasItem, itemGroup);
    }

    @Override
    public CustomBlock create() {
        return new CustomBlock(this.settings, this.hasItem, this.itemGroup);
    }
}
