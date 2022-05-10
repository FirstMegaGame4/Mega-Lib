package fr.firstmegagame4.mega_lib.lib.item;

public interface ConditionalItem<T extends CustomItem> {
    T create();

    T getIfCreated();
}
