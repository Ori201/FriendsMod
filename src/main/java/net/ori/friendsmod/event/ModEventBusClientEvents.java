package net.ori.friendsmod.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.ori.friendsmod.FriendsMod;
import net.ori.friendsmod.block.entity.ModBlockEntities;
import net.ori.friendsmod.block.entity.renderer.HeartMakerBlockEntityRenderer;

@Mod.EventBusSubscriber(modid = FriendsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.HEART_MAKER_BE.get(), HeartMakerBlockEntityRenderer::new);
    }
}