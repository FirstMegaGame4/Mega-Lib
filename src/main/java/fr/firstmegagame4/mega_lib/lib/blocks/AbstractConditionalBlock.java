package fr.firstmegagame4.mega_lib.lib.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.item.ItemGroup;


public abstract class AbstractConditionalBlock {
    protected final AbstractBlock.Settings settings;

    protected final boolean hasItem;

    protected final ItemGroup itemGroup;

    public AbstractConditionalBlock(AbstractBlock.Settings settings) {
        this(settings, false);
    }

    public AbstractConditionalBlock(AbstractBlock.Settings settings, boolean hasItem) {
        this(settings, hasItem, null);
    }

    public AbstractConditionalBlock(AbstractBlock.Settings settings, boolean hasItem, ItemGroup itemGroup) {
        this.settings = settings;
        this.hasItem = hasItem;
        this.itemGroup = itemGroup;
    }
}
