package fr.firstmegagame4.mega_lib.lib.item;

import net.minecraft.item.Item;

public abstract class AbstractConditionalItem {
    protected final Item.Settings settings;

    public AbstractConditionalItem(Item.Settings settings) {
        this.settings = settings;
    }
}
