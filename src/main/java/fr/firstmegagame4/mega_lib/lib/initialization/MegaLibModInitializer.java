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

    ItemsInitializer getItemsInitializer();

    default Logger getLogger() {
        return LoggerFactory.getLogger(this.getModName());
    }

    @Override
    @OverridingMethodsMustInvokeSuper
    default void onInitialize() {
        if (!this.getIdentifier().equals("mega_lib")) MegaLib.megaLibModIdentifiers.add(this.getIdentifier());
        this.getBlocksInitializer().register();
        this.getBlocksInitializer().registerOres();
        this.getBlockEntitiesInitializer().register();
        this.getItemsInitializer().register();
    }
}
