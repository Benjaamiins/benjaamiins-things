package net.rockpuppy.benjaamiins.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.rockpuppy.benjaamiins.screens.BeanstoneMonolithScreenHandler;
import org.jetbrains.annotations.Nullable;

public class BeanstoneMonolithBlockEntity extends BlockEntity implements NamedScreenHandlerFactory {
    public BeanstoneMonolithBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BEANSTONE_MONOLITH, pos, state);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new BeanstoneMonolithScreenHandler(syncId, playerInventory);
    }
}
