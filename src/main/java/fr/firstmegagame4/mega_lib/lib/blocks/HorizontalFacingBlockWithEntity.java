package fr.firstmegagame4.mega_lib.lib.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.property.Properties;

public abstract class HorizontalFacingBlockWithEntity extends FacingBlockWithEntity {

    protected HorizontalFacingBlockWithEntity(Settings settings) {
        this(settings, false);
    }

    protected HorizontalFacingBlockWithEntity(Settings settings, boolean hasItem) {
        this(settings, hasItem, null);
    }

    protected HorizontalFacingBlockWithEntity(Settings settings, boolean hasItem, ItemGroup itemGroup) {
        super(settings, hasItem, itemGroup);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    static {
        FACING = Properties.HORIZONTAL_FACING;
    }

}
