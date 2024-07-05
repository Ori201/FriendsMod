package net.ori.friendsmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditions;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.ori.friendsmod.FriendsMod;
import net.ori.friendsmod.item.ModItems;
import net.ori.friendsmod.loot.AddItemModifier;
import net.ori.friendsmod.loot.AddSusSandItemModifier;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, FriendsMod.MOD_ID);
    }

    @Override
    protected void start() {
        add("broken_heart_fr_from_village_weaponsmith", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_weaponsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.75f).build()}, ModItems.BROKEN_HEART_FR.get()));


        add("heart_fr_from_village_weaponsmith", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_weaponsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()}, ModItems.HEART_FR.get()));


        add("heart_fr_from_buried_treasure", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/buried_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.55f).build()}, ModItems.HEART_FR.get()));


        add("broken_heart_fr_from_desert_pyramid", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/desert_pyramid")).build(),
                LootItemRandomChanceCondition.randomChance(0.65f).build()}, ModItems.BROKEN_HEART_FR.get()));


        add("broken_heart_fr_from_jungle_temple", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/jungle_temple")).build(),
                LootItemRandomChanceCondition.randomChance(0.75f).build()}, ModItems.BROKEN_HEART_FR.get()));


        add("broken_heart_fr_from_suspicious_sand", new AddSusSandItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/desert_pyramid")).build()}, ModItems.BROKEN_HEART_FR.get()));






        // village_weaponsmith - שבור | buried_treasure - שלם | desert_pyramid - שבור | jungle_temple - שבור //
    }
}
