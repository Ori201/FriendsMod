package net.ori.friendsmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.ori.friendsmod.FriendsMod;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FriendsMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FRIENDS_TAB = CREATIVE_MODE_TABS.register("friends_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LOGO.get()))
                    .title(Component.translatable("creativetab.friends_tab"))
                    .displayItems((pParameters, output) -> {
                        output.accept(ModItems.TICKET.get());
                        output.accept(ModItems.DOCUMENT.get());


                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
