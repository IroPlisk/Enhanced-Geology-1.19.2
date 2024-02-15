package com.example.enmine.items;

import cofh.lib.tags.BlockTagsCoFH;
import cofh.thermal.foundation.data.TFndBlockStateProvider;
import cofh.thermal.foundation.init.TFndBlocks;
import cofh.thermal.foundation.init.TFndIDs;
import com.smashingmods.chemlib.ChemLib;
import com.smashingmods.chemlib.common.blocks.ChemicalBlock;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class OxyFuelTorch extends Item {
    public OxyFuelTorch(CreativeModeTab tab) {
        super(new Properties().tab(tab).durability(20).setNoRepair());
    }

     // cuttableItems.add("178:0");todo corrugated steel
	 //	cuttableItems.add("661:0"); blocco piombo

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.getBlock() == Blocks.IRON_BARS) {
            return super.getDestroySpeed(stack, state) + 500;
        }
        return 0.5f;
    }

}
