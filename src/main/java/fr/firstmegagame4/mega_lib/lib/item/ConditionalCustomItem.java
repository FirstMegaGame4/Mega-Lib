package fr.firstmegagame4.mega_lib.lib.item;

import net.minecraft.item.Item;

public class ConditionalCustomItem extends AbstractConditionalItem implements ConditionalItem<CustomItem> {
    private CustomItem item = null;

    public ConditionalCustomItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public CustomItem create() {
        return this.item = new CustomItem(this.settings);
    }

    @Override
    public CustomItem getIfCreated() {
        return this.item;
    }

    @Override
    public CustomItem getIfCreatedOrElse(CustomItem customItem) {
        if (this.item != null) return this.item;
        else return customItem;
    }
}
