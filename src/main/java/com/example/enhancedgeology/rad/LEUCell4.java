package com.example.enhancedgeology.rad;

import ic2.api.reactor.IReactor;
import ic2.api.reactor.IReactorComponent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class LEUCell4 extends Item implements IReactorComponent {

    public int damage = 7450;
    public LEUCell4(CreativeModeTab tab) {
        super(new Properties().tab(tab).durability(7450));
    }

    @Override
    public void processChamber(ItemStack itemStack, IReactor iReactor, int i, int i1, boolean b, boolean b1) {
        if (!iReactor.isProducingEnergy()) {
            return;
        }
        int heat = pulses * 4 * 4;

        if (heat > 0){
            iReactor.addHeat(heat);
        }
        if(itemStack.getDamageValue() >= damage){
            iReactor.setStackInReactor(i, i1, null);
        } else {
            itemStack.setDamageValue(1);
        }
    }

    int pulses = 1;
        @Override
        public boolean acceptUraniumPulse(ItemStack itemStack, IReactor iReactor, ItemStack itemStack1, int i, int i1, int i2, int i3, boolean b, boolean b1) {
            iReactor.addOutput(24);
            return true;
        }


    @Override
    public boolean canStoreHeat(ItemStack itemStack, IReactor iReactor, int i, int i1) {
        return false;
    }

    @Override
    public int getStoredHeat(ItemStack itemStack, IReactor iReactor, int i, int i1) {
        return 0;
    }

    @Override
    public int getMaxStoredHeat(ItemStack itemStack, IReactor iReactor, int i, int i1) {
        return 0;
    }

    @Override
    public int storeHeat(ItemStack itemStack, IReactor iReactor, int i, int i1, int i2) {
        return 0;
    }

    @Override
    public float getExplosionInfluence(ItemStack itemStack, IReactor iReactor) {
        return 8.0F;
    }
}


