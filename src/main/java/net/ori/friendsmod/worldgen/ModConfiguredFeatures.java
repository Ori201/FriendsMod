package net.ori.friendsmod.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.ori.friendsmod.FriendsMod;
import net.ori.friendsmod.block.ModBlocks;

import java.util.List;


public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_YELLOWNGE_ORE_KEY = resourceKey("yellownge_ore");


    public static void bootsrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldYellowngeOres = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.YELLOWNGE_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_YELLOWNGE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldYellowngeOres, 9));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> resourceKey(String name) {
        return  ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FriendsMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
