package net.ori.friendsmod.item;

import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.server.commands.PlaySoundCommand;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ori.friendsmod.FriendsMod;
import net.ori.friendsmod.sound.ModSounds;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FriendsMod.MOD_ID);

    public static RegistryObject<Item> DOCUMENT = ITEMS.register("agreement_document",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TICKET = ITEMS.register("ticket",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HEART_FR = ITEMS.register("heart_fr",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BROKEN_HEART_FR = ITEMS.register("broken_heart_fr",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Y_O = ITEMS.register("yellownge",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_Y_O = ITEMS.register("raw_yellownge",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIVE_SCHOOL_1_MUSIC_DISC = ITEMS.register("drive_school_1_music_disc",
            () -> new RecordItem(8, ModSounds.DRIVE_SCHOOL_1, new Item.Properties().stacksTo(1), 2480));

    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
