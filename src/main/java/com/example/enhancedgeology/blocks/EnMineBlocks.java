package com.example.enhancedgeology.blocks;

import com.example.enhancedgeology.EnhancedGeology;
import com.example.enhancedgeology.creativetabs.EnMineBlocksCreativeModeTab;
import com.example.enhancedgeology.items.BasicItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class EnMineBlocks {
    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, EnhancedGeology.MODID);

    public static final RegistryObject<Block> PERIODITE_BLOCK = registerBlock("peridotite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f).
                    requiresCorrectToolForDrops()), EnMineBlocksCreativeModeTab.EN_GEO_BLOCKS_CREATIVE_MODE_TAB);
    public static final RegistryObject<Block> ARDESIA_BLOCK = registerBlock("ardesia_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f).
                    requiresCorrectToolForDrops()), EnMineBlocksCreativeModeTab.EN_GEO_BLOCKS_CREATIVE_MODE_TAB);
    public static final RegistryObject<Block> DIASPRO_BLOCK = registerBlock("diaspro_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f).
                    requiresCorrectToolForDrops()), EnMineBlocksCreativeModeTab.EN_GEO_BLOCKS_CREATIVE_MODE_TAB);
    public static final RegistryObject<Block> SERPENTINITE_BLOCK = registerBlock("serpentinite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f).
                    requiresCorrectToolForDrops()), EnMineBlocksCreativeModeTab.EN_GEO_BLOCKS_CREATIVE_MODE_TAB);
    public static final RegistryObject<Block> GNEISS = registerBlock("gneiss_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).
                    requiresCorrectToolForDrops()), EnMineBlocksCreativeModeTab.EN_GEO_BLOCKS_CREATIVE_MODE_TAB);
    public static final RegistryObject<Block> KIMBERLITE = registerBlock("kimberlite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f).
                    requiresCorrectToolForDrops()), EnMineBlocksCreativeModeTab.EN_GEO_BLOCKS_CREATIVE_MODE_TAB);
    public static final RegistryObject<Block> URANITE = registerBlock("uranite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f).
                    requiresCorrectToolForDrops()), EnMineBlocksCreativeModeTab.EN_GEO_BLOCKS_CREATIVE_MODE_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab){
        return BasicItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
