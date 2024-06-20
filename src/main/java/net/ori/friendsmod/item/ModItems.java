package net.ori.friendsmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.NewRegistryEvent;
import net.minecraftforge.registries.RegistryObject;
import net.ori.friendsmod.FriendsMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FriendsMod.MOD_ID);

    public static RegistryObject<Item> DOCUMENT = ITEMS.register("agreement_document",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TICKET = ITEMS.register("ticket",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HEART_FR = ITEMS.register("heart_fr",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Y_O = ITEMS.register("yellownge",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_Y_O = ITEMS.register("raw_yellownge",
            () -> new Item(new Item.Properties()));

    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
