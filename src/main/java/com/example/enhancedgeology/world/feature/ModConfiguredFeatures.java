package com.example.enhancedgeology.world.feature;

import com.example.enhancedgeology.EnhancedGeology;
import com.example.enhancedgeology.blocks.EnMineBlocks;
import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, EnhancedGeology.MODID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_PERIDOTITE = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, EnMineBlocks.PERIODITE_BLOCK.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, EnMineBlocks.PERIODITE_BLOCK.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_ARDESIA = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, EnMineBlocks.ARDESIA_BLOCK.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_DIASPRO = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, EnMineBlocks.DIASPRO_BLOCK.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SERPENTINITE = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, EnMineBlocks.SERPENTINITE_BLOCK.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, EnMineBlocks.SERPENTINITE_BLOCK.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_GNEISS = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, EnMineBlocks.GNEISS.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, EnMineBlocks.GNEISS.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_KIMBERLITE = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, EnMineBlocks.KIMBERLITE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_URANINITE = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, EnMineBlocks.URANITE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_DEBRIS = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Blocks.ANCIENT_DEBRIS.defaultBlockState())));



    public static final RegistryObject<ConfiguredFeature<?, ?>> PERIDOTITE_ORE = CONFIGURED_FEATURES.register("peridotite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_PERIDOTITE.get(),5)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ARDESIA_ORE = CONFIGURED_FEATURES.register("ardesia_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_ARDESIA.get(),30)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> DIASPRO_ORE = CONFIGURED_FEATURES.register("diaspro_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_DIASPRO.get(),30)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SERPENTINITE_ORE = CONFIGURED_FEATURES.register("serpentinite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_SERPENTINITE.get(),30)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> GNEISS_ORE = CONFIGURED_FEATURES.register("gneiss_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_GNEISS.get(),15)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> KIMBERLITE_ORE = CONFIGURED_FEATURES.register("kimberlite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_KIMBERLITE.get(),12)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> URANINITE_ORE = CONFIGURED_FEATURES.register("uraninite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_URANINITE.get(),3)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> OW_DEBRIS = CONFIGURED_FEATURES.register("debris_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_DEBRIS.get(),3)));


    public static void register(IEventBus eventBus){
        CONFIGURED_FEATURES.register(eventBus);
    }
}
