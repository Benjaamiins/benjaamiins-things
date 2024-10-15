package net.rockpuppy.benjaamiins.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.rockpuppy.benjaamiins.Benjaamiins;
import net.minecraft.util.Identifier;
import net.rockpuppy.benjaamiins.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> BEAN_ORE_KEY = registerKey("bean_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ZEPHORINE_ORE_KEY = registerKey("zephorine_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_ZEPHORINE_ORE_KEY = registerKey("nether_zephorine_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_ZEPHORINE_ORE_KEY = registerKey("end_zephorine_ore");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new BlockMatchRuleTest(Blocks.NETHERRACK);
        RuleTest endReplacables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldBeanOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.BEAN_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_BEAN_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldZephorineOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.ZEPHORINE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_ZEPHORINE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherZephorineOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, ModBlocks.NETHER_ZEPHORINE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> endZephorineOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, ModBlocks.END_STONE_ZEPHORINE_ORE.getDefaultState()));

        register(context,BEAN_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldBeanOres, 12));
        register(context,ZEPHORINE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldZephorineOres, 12));
        register(context,NETHER_ZEPHORINE_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherZephorineOres, 12));
        register(context,END_ZEPHORINE_ORE_KEY, Feature.ORE, new OreFeatureConfig(endZephorineOres, 12));



    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Benjaamiins.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
