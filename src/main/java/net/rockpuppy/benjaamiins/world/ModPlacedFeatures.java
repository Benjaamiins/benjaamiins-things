package net.rockpuppy.benjaamiins.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.rockpuppy.benjaamiins.Benjaamiins;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> BEAN_ORE_PLACED_KEY = registerKey("bean_ore_placed");
    public static final RegistryKey<PlacedFeature> ZEPHORINE_ORE_PLACED_KEY = registerKey("zephorine_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_ZEPHORINE_ORE_PLACED_KEY = registerKey("nether_zephorine_ore_placed");
    public static final RegistryKey<PlacedFeature> END_ZEPHORINE_ORE_PLACED_KEY = registerKey("end_zephorine_ore_placed");

    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, BEAN_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BEAN_ORE_KEY),
                ModOrePlacement.modifiersWithCount(6, // veins per chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(40))));
        register(context, ZEPHORINE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ZEPHORINE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(2, // veins per chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(40))));
        register(context, NETHER_ZEPHORINE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_ZEPHORINE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(2, // veins per chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(200))));
        register(context, END_ZEPHORINE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.END_ZEPHORINE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(2, // veins per chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Benjaamiins.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
