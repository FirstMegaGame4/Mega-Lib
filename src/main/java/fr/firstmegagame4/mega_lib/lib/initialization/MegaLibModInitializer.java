package fr.firstmegagame4.mega_lib.lib.initialization;

import fr.firstmegagame4.mega_lib.MegaLib;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.OverridingMethodsMustInvokeSuper;

public interface MegaLibModInitializer extends ModInitializer {
    String getIdentifier();

    String getModName();

    BlocksInitializer getBlocksInitializer();

    BlockEntitiesInitializer getBlockEntitiesInitializer();

    OresInitializer getOresInitializer();

    ItemsInitializer getItemsInitializer();

    default Logger getLogger() {
        return LoggerFactory.getLogger(this.getModName());
    }

    @Override
    @OverridingMethodsMustInvokeSuper
    default void onInitialize() {
        MegaLib.megaLibModIdentifiers.add(this.getModName() + "[" + this.getIdentifier() + "]");
        this.getBlocksInitializer().register();
        this.getBlockEntitiesInitializer().register();
        this.getOresInitializer().register();
        this.getItemsInitializer().register();
    }
}
