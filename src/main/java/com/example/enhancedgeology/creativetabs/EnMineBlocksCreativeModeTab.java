package com.example.enhancedgeology.creativetabs;

import com.example.enhancedgeology.blocks.EnMineBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class EnMineBlocksCreativeModeTab extends CreativeModeTab {
    public static final EnMineBlocksCreativeModeTab EN_GEO_BLOCKS_CREATIVE_MODE_TAB = new EnMineBlocksCreativeModeTab(CreativeModeTab.TABS.length, "enhancedgeology_blocks");
    private EnMineBlocksCreativeModeTab(int index, String label) {
        super(index, label);
    }

    public @NotNull ItemStack makeIcon() {
        return new ItemStack(EnMineBlocks.PERIODITE_BLOCK.get());
    }
}
