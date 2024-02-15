package com.example.enmine.items;

import com.example.enmine.blocks.EnMineBlocks;
import ic2.api.items.electric.ElectricItem;
import ic2.core.item.base.ElectricToolItem;
import ic2.core.item.base.PropertiesBuilder;
import ic2.core.platform.registries.IC2Blocks;
import ic2.core.utils.helpers.Tool;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Conduttimetro extends ElectricToolItem {
    public Conduttimetro(CreativeModeTab tab) {
        super("conduttimetro", 8.0F, 2.0F, -3.0F, (new PropertiesBuilder()).group(tab));
        this.tier = 1;
        this.capacity = 25000;
        this.transferLimit = 100;
    }

        // mineralConductivity.put("458:0", -0.9F); SULFUR ORE
        // mineralConductivity.put("255:1", -0.2F); basalto
        // mineralConductivity.put("255", -0.2F); marmo
        // mineralConductivity.put("254:0", -0.2F); ruby ore
        //mineralConductivity.put("1398", 0.8F); apatite



    public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        Vec3 playerPosition = player.position();
        double x = playerPosition.x();
        double y = playerPosition.y();
        double z = playerPosition.z();
        if (!level.isClientSide()) {
            if (ElectricItem.MANAGER.getCharge(stack) >= 250) {
                player.sendSystemMessage(Component.literal(""));
                player.sendSystemMessage(Component.literal("\247bColonna:       \2477" + x + ", " + y + ", " + z));
                float reading = condOfArea(level, x, y, z);
                if (reading > 0.3F) {
                    player.sendSystemMessage(Component.literal(("\247bConduttività:  \247c" + reading + "  \247rmS/m")));
                } else if (reading == 0.3F) {
                    player.sendSystemMessage(Component.literal(("\247bConduttività:  \247a" + reading + " \247rmS/m")));
                } else if (reading <= 0.0F) {
                    player.sendSystemMessage(Component.literal(("\247bConduttività:  \247aOL \247rmS/m")));
                } else {
                    player.sendSystemMessage(Component.literal(("\247bConduttività:  \247e" + reading + " \247rmS/m")));
                }
                if (ElectricItem.MANAGER.getCharge(stack) < 250) {
                    player.sendSystemMessage(Component.literal(("\247cBatteria scarica")));
                }
                player.sendSystemMessage(Component.literal(("")));
                this.damage(stack, 250, player);
            }
        }
        return super.use(level, player, hand);
    }

 private float condOfArea(final Level level, final double x, final double y, final double z) {
     int totalScore = 0;
     int blocksScanned = 0;
     float localConductivity = 0.3F;
     Float modifier = 0.0F;
     final int range = 2;
     for (double blockY = y; blockY > 0; --blockY) {
         for (double blockX = x - range; blockX <= x + range; ++blockX) {
             for (double blockZ = z - range; blockZ <= z + range; ++blockZ) {
                 BlockPos arbitraryPos = new BlockPos(blockX,blockY,blockZ);
                 BlockState blockState = level.getBlockState(arbitraryPos);
                 Block block = blockState.getBlock();
                 if(block == Blocks.GOLD_ORE){
                     modifier = 0.1F;
                 } else if(block == Blocks.IRON_ORE){
                     modifier = 0.12F;
                 } else if(block == Blocks.COAL_ORE){
                     modifier = -0.5F;
                 } else if(block == Blocks.DIAMOND_ORE){
                     modifier = -0.9F;
                 } else if(block == IC2Blocks.URANIUM_ORE){
                     modifier = -0.2F;
                 } else if(block == Blocks.GRAVEL){
                     modifier = -0.2F;
                 } else if(block == Blocks.DIORITE) {
                     modifier = 0.007F;
                 } else if(block == Blocks.ANDESITE){
                     modifier = -0.12F;
                 } else if(block == Blocks.GRANITE){
                     modifier = -0.2F;
                 } else if(block == EnMineBlocks.PERIODITE_BLOCK.get()){
                     modifier = 0.05F;
                 } else if(block == EnMineBlocks.ARDESIA_BLOCK.get()){
                     modifier = 0.05F;
                 } else if(block == EnMineBlocks.DIASPRO_BLOCK.get()){
                     modifier = -0.2F;
                 } else if(block == Blocks.TUFF){
                     modifier = 0.01F;
                 } else if(block == EnMineBlocks.SERPENTINITE_BLOCK.get()){
                     modifier = -0.2F;
                 } else if(block == EnMineBlocks.GNEISS.get()){
                     modifier = -0.2F;
                 } else if(block == EnMineBlocks.KIMBERLITE.get()){
                     modifier = 0.03F;
                 }else if(block == EnMineBlocks.URANITE.get()){
                     modifier = -0.2F;
                 } else if(block == Blocks.REDSTONE_ORE){
                     modifier = 0.11F;
                 } else if(block == Blocks.EMERALD_ORE){
                     modifier = -0.2F;
                 } else if(block == Blocks.COPPER_ORE){
                     modifier = 0.8F;
                 } else if(block == IC2Blocks.TIN_ORE){
                     modifier = 0.3F;
                 } else if(block == IC2Blocks.SILVER_ORE){
                     modifier = 0.3F;
                 } else if(block == Blocks.WATER){
                     modifier = 0.4F;
                 } else {
                     modifier = 0F;
                 }

                 localConductivity = localConductivity + (modifier / 100);
             }
         }
     }
     return localConductivity;
 }

    private void damage(final ItemStack is, final int damage, final Player player) {
        ElectricItem.MANAGER.use(is, damage, player);
    }

    @Override
    protected int getEnergyCost(ItemStack itemStack) {
        return 250;
    }
}
