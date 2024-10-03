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
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.rockpuppy.benjaamiins.block.custom.BeanPedestalBlock;
import org.jetbrains.annotations.Nullable;

public class BeanPedestalBlockEntity extends BlockEntity{
    private final SimpleInventory beanPedestalInventory = new SimpleInventory(1) {
        @Override
        public void markDirty() {
            super.markDirty();
            update();
        }
    };

    private final InventoryStorage beanPedestalInventoryStorage = InventoryStorage.of(beanPedestalInventory, null);

    public BeanPedestalBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BEAN_PEDESTAL, pos, state);
    }

    public ItemStack getRenderStack() {
        return beanPedestalInventory.getStack(0);
    }

    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.writeNbt(nbt, this.beanPedestalInventory.getHeldStacks(), registryLookup);
        super.writeNbt(nbt, registryLookup);
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        this.beanPedestalInventory.clear();
        Inventories.readNbt(nbt, this.beanPedestalInventory.getHeldStacks(), registryLookup);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        NbtCompound nbtCompound = new NbtCompound();
        Inventories.writeNbt(nbtCompound, this.beanPedestalInventory.getHeldStacks(), true, registryLookup);
        return createNbt(registryLookup);
    }

    private void update() {
        markDirty();
        if(world != null)
            world.updateListeners(pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
    }

    public InventoryStorage getInventoryProvider(Direction direction) {
        return beanPedestalInventoryStorage;
    }

    public SimpleInventory getBeanPedestalInventory() {
        return this.beanPedestalInventory;
    }
}
