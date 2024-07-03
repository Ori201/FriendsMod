package net.ori.friendsmod.block.entity;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ori.friendsmod.FriendsMod;
import net.ori.friendsmod.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FriendsMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<HeartMakerBlockEntity>> HEART_MAKER_BE =
            BLOCK_ENTITIES.register("heart_maker_be", () ->
                    BlockEntityType.Builder.of(HeartMakerBlockEntity::new,
                            ModBlocks.HEART_MAKER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
