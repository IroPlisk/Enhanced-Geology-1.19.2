package com.example.enhancedgeology.items;

import ic2.core.item.base.ElectricToolItem;
import ic2.core.item.base.PropertiesBuilder;
import ic2.core.platform.registries.IC2Blocks;
import ic2.core.utils.helpers.Tool;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class SDSdrill extends ElectricToolItem {
    public SDSdrill(CreativeModeTab tab) {
        super("sds", 8.0F, 2.0F, -3.0F, (new PropertiesBuilder()).group(tab));
        this.registerTools(new Tool[] {Tool.PICKAXE.withLevel(2)});
        this.tier = 1;
        this.capacity = 25000;
        this.transferLimit = 100;
    }

    @Override
    protected int getEnergyCost(ItemStack itemStack) {
        return 250;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.getBlock() == IC2Blocks.REINFORCED_STONE || state.getBlock() == IC2Blocks.REINFORCED_GLASS) {
            return super.getDestroySpeed(stack, state) + 500;
        }
        return 0.5f;
    }
}
