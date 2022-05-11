package fr.firstmegagame4.mega_lib.lib.screenhandlers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractContainerScreenHandler extends ScreenHandler {
    private Inventory inventory;

    protected AbstractContainerScreenHandler(@Nullable ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);
    }

    public void setupInventories(PlayerInventory playerInventory, Inventory inventory, int inventorySize) {
        checkSize(inventory, inventorySize);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);
    }

    public abstract void setupInventory(Inventory inventory);

    public void setupPlayerInventory(PlayerInventory playerInventory, int x, int y) {
        int a;
        int b;

        for (a = 0; a < 3; a++) {
            for (b = 0; b < 9; b++) {
                this.addSlot(new Slot(playerInventory, b + a * 9 + 9, x + b * 18, y + a * 18));
            }
        }
    }

    public void setupPlayerHotBar(PlayerInventory playerInventory, int x, int y) {
        int a;

        for (a = 0; a < 9; a++) {
            this.addSlot(new Slot(playerInventory, a, x + a * 18, y));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasStack()) {
            ItemStack oldStack = slot.getStack();
            newStack = oldStack.copy();
            if (index < this.inventory.size()) {
                if (!this.insertItem(oldStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.insertItem(oldStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (oldStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            }
            else {
                slot.markDirty();
            }
        }

        return newStack;
    }
}
