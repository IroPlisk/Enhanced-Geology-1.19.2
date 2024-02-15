package com.example.enmine.items;

import ic2.core.item.base.ElectricToolItem;
import ic2.core.item.base.PropertiesBuilder;
import ic2.core.platform.registries.IC2Blocks;
import ic2.core.utils.helpers.Tool;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class MartelloVetro extends Item {
    public MartelloVetro(CreativeModeTab tab) {
        super(new Properties().tab(tab).durability(50).setNoRepair());
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.getMaterial() == Material.GLASS) {
            return super.getDestroySpeed(stack, state) + 500;
        }
        return 0.5f;
    }
}
