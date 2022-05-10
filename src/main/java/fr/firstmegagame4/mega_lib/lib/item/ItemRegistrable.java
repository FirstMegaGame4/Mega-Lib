package fr.firstmegagame4.mega_lib.lib.item;

import fr.firstmegagame4.mega_lib.lib.utils.Registrable;
import fr.firstmegagame4.mega_lib.lib.utils.RegistrationUtils;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public interface ItemRegistrable extends Registrable {
    default void register(Identifier identifier) {
        if (this.isNotRegistered()) {
            RegistrationUtils.registerItem(identifier, (Item) this);
            this.setRegistered();
        }
    }
}
