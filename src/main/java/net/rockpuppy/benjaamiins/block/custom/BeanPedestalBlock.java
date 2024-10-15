package net.rockpuppy.benjaamiins.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.rockpuppy.benjaamiins.block.entity.BeanPedestalBlockEntity;

public class BeanPedestalBlock extends BlockWithEntity implements BlockEntityProvider {
    private static final VoxelShape SHAPE = BeanPedestalBlock.createCuboidShape(0, 0, 0, 16, 15, 16);

    public BeanPedestalBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(BeanPedestalBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BeanPedestalBlockEntity(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient){
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof BeanPedestalBlockEntity BeanPedestalBlockEntity) {

                ItemStack playerItem = player.getMainHandStack();
                ItemStack pedestalItem = BeanPedestalBlockEntity.getBeanPedestalInventory().getStack(0);

                if (!playerItem.isEmpty() && BeanPedestalBlockEntity.getBeanPedestalInventory().isEmpty()) {
                    BeanPedestalBlockEntity.getBeanPedestalInventory().setStack(0, playerItem);
                    player.setStackInHand(Hand.MAIN_HAND, ItemStack.EMPTY);
                } else if (playerItem.isEmpty() && !BeanPedestalBlockEntity.getBeanPedestalInventory().isEmpty()) {
                    player.setStackInHand(Hand.MAIN_HAND, pedestalItem);
                    BeanPedestalBlockEntity.getBeanPedestalInventory().setStack(0, ItemStack.EMPTY);
                } else if (!playerItem.isEmpty() && !BeanPedestalBlockEntity.getBeanPedestalInventory().isEmpty()) {
                    player.setStackInHand(Hand.MAIN_HAND, pedestalItem);
                    BeanPedestalBlockEntity.getBeanPedestalInventory().setStack(0, playerItem);
                }

                BeanPedestalBlockEntity.markDirty();
                world.updateListeners(pos, state, state, 0);
            }
        }

        return ActionResult.SUCCESS;
    }
}
