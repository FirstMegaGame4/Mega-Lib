package fr.firstmegagame4.mega_lib.lib.blocks;

import fr.firstmegagame4.mega_lib.lib.utils.RegistrationUtils;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

public class CustomBlock extends Block {
    private BlockItem item = null;
    private boolean registered = false;

    public CustomBlock(Settings settings) {
        this(settings, false);
    }

    public CustomBlock(Settings settings, boolean hasItem) {
        this(settings, hasItem, null);
    }

    public CustomBlock(Settings settings, boolean hasItem, ItemGroup itemGroup) {
        super(settings);
        if (hasItem) {
            if (itemGroup != null) this.item = new BlockItem(this, new FabricItemSettings().group(itemGroup));
            else this.item = new BlockItem(this, new FabricItemSettings());
        }
    }

    public void register(Identifier identifier) {
        if (!this.registered) RegistrationUtils.registerBlock(identifier, this);
        this.registered = true;
    }

    public BlockItem getItem() {
        return this.item;
    }

}
