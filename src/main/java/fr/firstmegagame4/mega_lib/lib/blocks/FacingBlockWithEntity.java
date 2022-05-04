package fr.firstmegagame4.mega_lib.lib.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;

public abstract class FacingBlockWithEntity extends CustomBlockWithEntity {

    public static DirectionProperty FACING;

    protected FacingBlockWithEntity(Settings settings) {
        this(settings, false);
    }

    protected FacingBlockWithEntity(Settings settings, boolean hasItem) {
        this(settings, hasItem, null);
    }

    protected FacingBlockWithEntity(Settings settings, boolean hasItem, ItemGroup itemGroup) {
        super(settings, hasItem, itemGroup);
        this.setDefaultState(this.stateManager.getDefaultState().with(Properties.FACING, Direction.NORTH));
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    static {
        FACING = Properties.FACING;
    }

}
