package com.example.enhancedgeology.items;

import net.minecraft.world.item.*;
import net.minecraft.world.level.block.state.BlockState;

public class TrapanoBenza extends PickaxeItem {
    public TrapanoBenza(Tier material, int attackDamage, float attackSpeed, Properties properties) {
        super(material, attackDamage, attackSpeed, properties);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if(stack.getDamageValue() > 245){
            return 0.05f;
        } else {
            return 10000f;
        }
    }
}
