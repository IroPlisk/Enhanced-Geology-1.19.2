package com.example.enhancedgeology.world.feature;

import com.example.enhancedgeology.EnhancedGeology;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, EnhancedGeology.MODID);

    public static final RegistryObject<PlacedFeature> PERIDOTITE_ORE_PLACED = PLACED_FEATURES.register("peridotite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.PERIDOTITE_ORE.getHolder().get(),
                    commonOrePlacement(5, // VeinsPerChunk
                            HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-10), VerticalAnchor.belowTop(30)))));
    public static final RegistryObject<PlacedFeature> ARDESIA_ORE_PLACED = PLACED_FEATURES.register("ardesia_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.ARDESIA_ORE.getHolder().get(),
                    commonOrePlacement(2, // VeinsPerChunk
                            HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(60), VerticalAnchor.belowTop(255)))));
    public static final RegistryObject<PlacedFeature> DIASPRO_ORE_PLACED = PLACED_FEATURES.register("diaspro_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.DIASPRO_ORE.getHolder().get(),
                    commonOrePlacement(3, // VeinsPerChunk
                            HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(50), VerticalAnchor.belowTop(90)))));
    public static final RegistryObject<PlacedFeature> SERPENTINITE_ORE_PLACED = PLACED_FEATURES.register("serpentinite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SERPENTINITE_ORE.getHolder().get(),
                    commonOrePlacement(3, // VeinsPerChunk
                            HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.belowTop(70)))));
    public static final RegistryObject<PlacedFeature> GNEISS_ORE_PLACED = PLACED_FEATURES.register("gneiss_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GNEISS_ORE.getHolder().get(),
                    commonOrePlacement(2, // VeinsPerChunk
                            HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.belowTop(20)))));
    public static final RegistryObject<PlacedFeature> KIMBERLITE_ORE_PLACED = PLACED_FEATURES.register("kimberlite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.KIMBERLITE_ORE.getHolder().get(),
                    commonOrePlacement(1, // VeinsPerChunk
                            HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.belowTop(0)))));
    public static final RegistryObject<PlacedFeature> URANINITE_ORE_PLACED = PLACED_FEATURES.register("uraninite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.URANINITE_ORE.getHolder().get(),
                    commonOrePlacement(15, // VeinsPerChunk
                            HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.belowTop(0)))));


    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus){
        PLACED_FEATURES.register(eventBus);
    }
}
