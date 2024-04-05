package com.example.enhancedgeology.items;

import com.example.enhancedgeology.blocks.EnMineBlocks;
import ic2.api.items.electric.ElectricItem;
import ic2.core.item.base.ElectricToolItem;
import ic2.core.item.base.PropertiesBuilder;
import ic2.core.platform.registries.IC2Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Random;

public class Geiger extends ElectricToolItem {
    public Geiger(CreativeModeTab tab) {
        super("geiger", 8.0F, 2.0F, -3.0F, (new PropertiesBuilder()).group(tab));
        this.tier = 1;
        this.capacity = 25000;
        this.transferLimit = 100;
    }
    HashMap<Block, Float> mineralRadioactivity = new HashMap<>();
    public void Densita() {
        mineralRadioactivity.put(Blocks.COAL_ORE, 0.023F);
        mineralRadioactivity.put(IC2Blocks.URANIUM_ORE, 1.72F);
        mineralRadioactivity.put(Blocks.TUFF, 0.057F);
        mineralRadioactivity.put(EnMineBlocks.KIMBERLITE.get(), 0.0033F);
        mineralRadioactivity.put(EnMineBlocks.URANITE.get(), 1.85F);
        mineralRadioactivity.put(Blocks.REDSTONE_ORE, 0.003F);
        mineralRadioactivity.put(IC2Blocks.URANIUM_BLOCK, 12.6762F);
        mineralRadioactivity.put(IC2Blocks.NUCLEAR_REACTOR, 45.6762F);
        mineralRadioactivity.put(IC2Blocks.REACTOR_CHAMBER, 67.6762F);
    }

   public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, InteractionHand hand) {
       ItemStack stack = player.getItemInHand(hand);
       Vec3 playerPosition = player.position();
       double x = playerPosition.x();
       double y = playerPosition.y();
       double z = playerPosition.z();
        if (!level.isClientSide()) {
           if (ElectricItem.MANAGER.getCharge(stack) >= 250) {
               player.sendSystemMessage(Component.literal(""));
               player.sendSystemMessage(Component.literal("\247bColonna:       \2477" + Math.floor(x) + ", " + Math.floor(y) + ", " + Math.floor(z)));
               double reading = radOfArea(level, x, y, z);
               double readingfloorato = Math.floor(reading);
               String readingFmt = new DecimalFormat("#.##").format(readingfloorato);
               if (reading > 5.0F) {
                   player.sendSystemMessage(Component.literal("\247bRadioattività:  \247c" + readingFmt + "  \247ruSv/h"));
               } else {
                   player.sendSystemMessage(Component.literal("\247bRadioattività:  \247a" + readingFmt + " \247ruSv/h"));
               }
               if (ElectricItem.MANAGER.getCharge(stack) < 250) {
                   player.sendSystemMessage(Component.literal("\247cBatteria scarica"));
               }
               player.sendSystemMessage(Component.literal(""));
               this.damage(stack, 250, player);
           }
       }
       return super.use(level, player, hand);
   }


    private void damage(final ItemStack is, final int damage, final Player player) {
        ElectricItem.MANAGER.use(is, damage, player);
    }

    private float radOfArea(final Level level, final double x, final double y, final double z) {
        Random rand = new Random();
        float localRad = rand.nextFloat() * (0.15F - 0.07F) + 0.07F;
        float modifier = 0.0F;
        final int range = 2;
        for (double blockY = y; blockY > 0; --blockY) {
            for (double blockX = x - range; blockX <= x + range; ++blockX) {
                for (double blockZ = z - range; blockZ <= z + range; ++blockZ) {
                    BlockPos arbitraryPos = new BlockPos(blockX,blockY,blockZ);
                    BlockState blockState = level.getBlockState(arbitraryPos);
                    Block block = blockState.getBlock();
                    if(block == Blocks.COAL_ORE){
                        modifier = 0.023F;
                    } else if(block == IC2Blocks.URANIUM_ORE){
                        modifier = 1.72F;
                    } else if(block == Blocks.TUFF){
                        modifier = 0.057F;
                    } else if(block == EnMineBlocks.KIMBERLITE.get()){
                        modifier = 0.0033F;
                    } else if(block == EnMineBlocks.URANITE.get()){
                        modifier = 1.85F;
                    } else if(block == Blocks.REDSTONE_ORE){
                        modifier = 0.003F;
                    } else if(block == IC2Blocks.URANIUM_BLOCK){
                        modifier = 12.6762F;
                    } else if(block == IC2Blocks.NUCLEAR_REACTOR){
                        modifier = 45.6762F;
                    } else if(block == IC2Blocks.REACTOR_CHAMBER){
                        modifier = 67.6762F;
                    }
                    }
                    localRad = localRad + (modifier / 10);
                }
            }
        return localRad;
        }

    @Override
    protected int getEnergyCost(ItemStack itemStack) {
        return 250;
    }
}
