package com.example.enhancedgeology.items;

import ic2.core.platform.registries.IC2Blocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class OxyFuelTorch extends Item {
    public OxyFuelTorch(CreativeModeTab tab) {
        super(new Properties().tab(tab).durability(20).setNoRepair());
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.getBlock() == Blocks.IRON_BARS || state.getBlock() == IC2Blocks.IRON_FENCE) {
            return super.getDestroySpeed(stack, state) + 500;
        }
        return 0.5f;
    }

}
