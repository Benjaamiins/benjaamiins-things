package net.rockpuppy.benjaamiins.screens;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.rockpuppy.benjaamiins.Benjaamiins;

public class BeanstoneMonolithScreenHandler extends ScreenHandler {

    public BeanstoneMonolithScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(Benjaamiins.BEANSTONE_MONOLITH_SCREEN_HANDLER, syncId);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
