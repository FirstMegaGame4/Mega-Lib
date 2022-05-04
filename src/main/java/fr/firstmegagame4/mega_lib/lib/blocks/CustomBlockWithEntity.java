package fr.firstmegagame4.mega_lib.lib.blocks;

import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class CustomBlockWithEntity extends CustomBlock implements BlockEntityProvider {
    public CustomBlockWithEntity(Settings settings) {
        this(settings, false);
    }

    public CustomBlockWithEntity(Settings settings, boolean hasItem) {
        this(settings, hasItem, null);
    }

    public CustomBlockWithEntity(Settings settings, boolean hasItem, ItemGroup itemGroup) {
        super(settings, hasItem, itemGroup);
    }

    @Override
    public boolean onSyncedBlockEvent(BlockState state, World world, BlockPos pos, int type, int data) {
        super.onSyncedBlockEvent(state, world, pos, type, data);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity != null) return blockEntity.onSyncedBlockEvent(type, data);
        else return false;
    }

    @Nullable
    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return world.getBlockEntity(pos) instanceof NamedScreenHandlerFactory ? (NamedScreenHandlerFactory) world.getBlockEntity(pos) : null;
    }

    // checkType maybe ?
}
