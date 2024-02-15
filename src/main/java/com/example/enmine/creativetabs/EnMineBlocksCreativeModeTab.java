package com.example.enmine.creativetabs;

import com.example.enmine.blocks.EnMineBlocks;
import com.example.enmine.items.SDSdrill;
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
