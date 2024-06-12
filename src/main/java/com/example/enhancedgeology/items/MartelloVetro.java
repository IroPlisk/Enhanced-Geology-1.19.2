package com.example.enhancedgeology.items;

import net.minecraft.world.item.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class MartelloVetro extends PickaxeItem {
    public MartelloVetro(Tier material, int attackDamage, float attackSpeed, Properties properties) {
        super(material, attackDamage, attackSpeed, properties);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.getMaterial() == Material.GLASS) {
            return super.getDestroySpeed(stack, state) + 500;
        }
        return 0.5f;
    }
}
