package com.example.enmine.items;

import ic2.core.item.base.PropertiesBuilder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class MartelloGeo extends PickaxeItem {
    public MartelloGeo(Tier material, int attackDamage, float attackSpeed, Properties properties) {
        super(material, attackDamage, attackSpeed, properties);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
            return 0.500f;
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level level, Player player) {
        stack.enchant(Enchantments.BLOCK_FORTUNE, 6);
        super.onCraftedBy(stack, level, player);
    }
}
