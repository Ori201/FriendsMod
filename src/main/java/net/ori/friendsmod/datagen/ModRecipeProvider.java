package net.ori.friendsmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.ori.friendsmod.FriendsMod;
import net.ori.friendsmod.block.ModBlocks;
import net.ori.friendsmod.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> YELLOWNGE_SMELTABLES = List.of(ModItems.RAW_Y_O.get(),
            ModBlocks.FRIENDS_ORE.get());

    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, YELLOWNGE_SMELTABLES, RecipeCategory.MISC, ModItems.RAW_Y_O.get(), 0.25f, 100, "yellownge");
        oreBlasting(pWriter, YELLOWNGE_SMELTABLES, RecipeCategory.MISC, ModItems.RAW_Y_O.get(), 0.25f, 100, "yellownge");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOWNGE_BLOCK.get())
                .pattern("YYY")
                .pattern("YYY")
                .pattern("YYY")
                .define('Y', ModItems.Y_O.get())
                .unlockedBy(getHasName(ModItems.Y_O.get()), has(ModItems.Y_O.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.Y_O.get(), 9)
                .requires(ModBlocks.YELLOWNGE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.YELLOWNGE_BLOCK.get()), has(ModBlocks.YELLOWNGE_BLOCK.get()))
                .save(pWriter);



        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FR_BLOCK.get())
                .pattern("BBA")
                .pattern("BCA")
                .pattern("BAA")
                .define('A', Items.YELLOW_CONCRETE)
                .define('B', Items.ORANGE_CONCRETE)
                .define('C', ModItems.HEART_FR.get())
                .showNotification(true)
                .unlockedBy(getHasName(ModItems.HEART_FR.get()), has(ModItems.HEART_FR.get()))
                .save(pWriter);

    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  FriendsMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}


