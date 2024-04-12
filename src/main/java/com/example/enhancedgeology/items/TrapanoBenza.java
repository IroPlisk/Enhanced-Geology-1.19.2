package com.example.enhancedgeology.items;

import com.example.enhancedgeology.sound.EnhancedGeologySoundEvents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
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

    int m = 0;
    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean bool) {
        Player player = (Player) entity;
        ItemStack mainhanditem = player.getItemBySlot(EquipmentSlot.MAINHAND);
        if(!mainhanditem.isEmpty() && mainhanditem.getItem() == BasicItems.TOOLGASDRILL.get()) {
            if(m<1 && mainhanditem.getDamageValue() < 245) {
                level.playSound(player, player.getX(), player.getY(), player.getZ(), EnhancedGeologySoundEvents.TRAPANO_BENZA_START.get(), SoundSource.MASTER, 1.0F, 1.0F);
            }
            if(m<1 && stack.getDamageValue() > 245) {
                level.playSound(player, player.getX(), player.getY(), player.getZ(), EnhancedGeologySoundEvents.TRAPANO_BENZA_SCARICO.get(), SoundSource.MASTER, 1.0F, 1.0F);
            }
            m++;
        } else {
            m = 0;
        }
    }
}


