package com.example.enhancedgeology.items;

import ic2.core.platform.registries.IC2Blocks;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class OxyFuelTorch extends PickaxeItem {
    public OxyFuelTorch(Tier material, int attackDamage, float attackSpeed, Properties properties) {
        super(material, attackDamage, attackSpeed, properties);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.getBlock() == Blocks.IRON_BARS || state.getBlock() == IC2Blocks.IRON_FENCE || state.getBlock() == Blocks.IRON_BLOCK || state.getBlock() == Blocks.IRON_DOOR) {
            return super.getDestroySpeed(stack, state) + 500;
        }
        return 0.1f;
    }

}
