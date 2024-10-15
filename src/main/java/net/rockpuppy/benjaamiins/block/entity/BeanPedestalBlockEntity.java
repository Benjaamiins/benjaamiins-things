package net.rockpuppy.benjaamiins.block.entity;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.DefaultedRegistry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.rockpuppy.benjaamiins.block.custom.BeanPedestalBlock;
import org.jetbrains.annotations.Nullable;

public class BeanPedestalBlockEntity extends BlockEntity{

    private final DefaultedList<ItemStack> beanPedestalInventory = DefaultedList.ofSize(1, ItemStack.EMPTY);

    public BeanPedestalBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BEAN_PEDESTAL, pos, state);
    }

    public ItemStack getRenderStack() {
        return beanPedestalInventory.get(0);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, beanPedestalInventory);
        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.beanPedestalInventory.clear();
        Inventories.readNbt(nbt, beanPedestalInventory);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    private void update() {
        markDirty();
        if(world != null)
            world.updateListeners(pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
    }
}
