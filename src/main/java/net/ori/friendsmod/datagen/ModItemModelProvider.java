package net.ori.friendsmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.ori.friendsmod.FriendsMod;
import net.ori.friendsmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FriendsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.HEART_FR);
        simpleItem(ModItems.RAW_Y_O);
        simpleItem(ModItems.Y_O);
        simpleItem(ModItems.DOCUMENT);
        simpleItem(ModItems.TICKET);

        simpleItem(ModItems.DRIVE_SCHOOL_1_MUSIC_DISC);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FriendsMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
