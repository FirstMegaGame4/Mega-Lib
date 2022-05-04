package fr.firstmegagame4.mega_lib.lib.utils;

import fr.firstmegagame4.mega_lib.lib.blocks.CustomBlock;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegistrationUtils {
    public static void registerItem(Identifier identifier, Item item) {
        Registry.register(Registry.ITEM, identifier, item);
    }

    public static void registerBlock(Identifier identifier, CustomBlock block) {
        Registry.register(Registry.BLOCK, identifier, block);
        if (block.getItem() != null) registerItem(identifier, block.getItem());
    }
}
