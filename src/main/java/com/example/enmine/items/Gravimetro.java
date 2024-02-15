package com.example.enmine.items;

import com.example.enmine.blocks.EnMineBlocks;
import ic2.api.items.electric.ElectricItem;
import ic2.api.util.DirectionList;
import ic2.core.item.base.ElectricToolItem;
import ic2.core.item.base.IC2ElectricItem;
import ic2.core.item.base.PropertiesBuilder;
import ic2.core.platform.registries.IC2Blocks;
import ic2.core.utils.helpers.Tool;
import ic2.core.utils.math.geometry.Box;
import it.unimi.dsi.fastutil.Hash;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.world.ForgeChunkManager;
import org.apache.commons.io.output.ChunkedWriter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Gravimetro extends ElectricToolItem {
    HashMap<Block, Float> mineralDensity = new HashMap<>();

    public Gravimetro(CreativeModeTab tab) {
        super("gravimetro", 8.0F, 2.0F, -3.0F, (new PropertiesBuilder()).group(tab));
        this.tier = 1;
        this.capacity = 25000;
        this.transferLimit = 100;
    }
    @Override
    protected int getEnergyCost(ItemStack itemStack) {
        return 250;
    }

    public void Densita() {
        mineralDensity.put(Blocks.GOLD_ORE, 0.6F);
        mineralDensity.put(Blocks.IRON_ORE, 0.2F);
        mineralDensity.put(Blocks.COAL_ORE, -0.2F);
        mineralDensity.put(Blocks.DIAMOND_BLOCK, 0.3F);
        mineralDensity.put(IC2Blocks.URANIUM_ORE, 0.65F);
        // mineralDensity.put("458:0", -0.3F); sulfur ore
        mineralDensity.put(Blocks.GRAVEL, -0.15F);
        mineralDensity.put(Blocks.ANDESITE, 0.05F);
        mineralDensity.put(Blocks.DIORITE, 0.06F);
        mineralDensity.put(Blocks.GRANITE, 0.08F);
        mineralDensity.put(EnMineBlocks.PERIODITE_BLOCK.get(), 0.12F);
        mineralDensity.put(EnMineBlocks.ARDESIA_BLOCK.get(), 0.02F);
        mineralDensity.put(EnMineBlocks.DIASPRO_BLOCK.get(), -0.3F);
        mineralDensity.put(Blocks.TUFF, 0.04F);
        mineralDensity.put(EnMineBlocks.SERPENTINITE_BLOCK.get(), 0.08F);
        mineralDensity.put(EnMineBlocks.GNEISS.get(), 0.1F);
        mineralDensity.put(EnMineBlocks.KIMBERLITE.get(), 0.3F);
        mineralDensity.put(EnMineBlocks.URANITE.get(), 0.1F);
        // mineralDensity.put("255:1", 0.6F); basalto
        // mineralDensity.put("255", 0.12F); marmo
        mineralDensity.put(Blocks.REDSTONE_ORE, -0.12F);
        mineralDensity.put(Blocks.EMERALD_ORE, 0.14F);
        // mineralDensity.put("254:0", 0.145F); ruby ore
        mineralDensity.put(Blocks.COPPER_ORE, -0.05F);
        // mineralDensity.put("1398:1", -0.05F); apatite ore
        mineralDensity.put(IC2Blocks.TIN_ORE, -0.1F);
        // mineralDensity.put("2001:1", -0.1F); tin ore della thermal
        mineralDensity.put(IC2Blocks.SILVER_ORE, 0.2F);
        // mineralDensity.put(IC2Blocks.SILVER_ORE, 0.2F); silver della thermal
        // mineralDensity.put("2001:3", 0.64F); lead ore della thermal
    }



    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            if (ElectricItem.MANAGER.getCharge(stack) != 0) {
                damage(stack, 250, player);
                Vec3 playerPosition = player.position();
                double x = playerPosition.x();
                double y = playerPosition.y();
                double z = playerPosition.z();
                player.sendSystemMessage(Component.literal(""));
                player.sendSystemMessage(Component.literal("\247bColonna: \2477" + x + ", " + y + ", " + z));
                double reading = gravityOfArea(level, x, y, z);
                if (reading > 981000.0F) {
                    player.sendSystemMessage(Component.literal("\247bGravità:  \247c" + reading + "  \247rmgal"));
                } else if (reading == 981000.0F) {
                    player.sendSystemMessage(Component.literal("\247bGravità:  \247a" + reading + " \247rmgal"));
                } else {
                    player.sendSystemMessage(Component.literal("\247bGravità:  \247e" + reading + " \247rmgal"));
                }
                if (ElectricItem.MANAGER.getCharge(stack) <250) {
                    player.sendSystemMessage(Component.literal("\247cBatteria scarica"));
                }
                player.sendSystemMessage(Component.literal(""));
            }
        }
        return super.use(level, player, hand);
    }

    private void damage(final ItemStack is, final int damage, final Player player) {
        ElectricItem.MANAGER.use(is, damage, player);
    }

    private float gravityOfArea(final Level level, final double x, final double y, final double z) {
        float localGravity = 981000.0F;
        Float modifier = 0.0F;
        final int range = 2;
        for (double blockY = y; blockY > 0; --blockY) {
            for (double blockX = x - range; blockX <= x + range; ++blockX) {
                for (double blockZ = z - range; blockZ <= z + range; ++blockZ) {
                    BlockPos arbitraryPos = new BlockPos(blockX,blockY,blockZ);
                    BlockState blockState = level.getBlockState(arbitraryPos);
                    Block block = blockState.getBlock();
                    if(block == Blocks.GOLD_ORE){
                        modifier = 0.6F;
                    } else if(block == Blocks.IRON_ORE){
                        modifier = 0.2F;
                    } else if(block == Blocks.COAL_ORE){
                        modifier = -0.2F;
                    } else if(block == Blocks.DIAMOND_BLOCK){
                        modifier = 0.3F;
                    } else if(block == IC2Blocks.URANIUM_ORE){
                        modifier = 0.65F;
                    } else if(block == Blocks.GRAVEL){
                        modifier = -0.15F;
                    } else if(block == Blocks.DIORITE) {
                        modifier = 0.05F;
                    } else if(block == Blocks.ANDESITE){
                        modifier = 0.06F;
                    } else if(block == Blocks.GRANITE){
                        modifier = 0.08F;
                    } else if(block == EnMineBlocks.PERIODITE_BLOCK.get()){
                        modifier = 0.12F;
                    } else if(block == EnMineBlocks.ARDESIA_BLOCK.get()){
                        modifier = 0.02F;
                    } else if(block == EnMineBlocks.DIASPRO_BLOCK.get()){
                        modifier = -0.3F;
                    } else if(block == Blocks.TUFF){
                        modifier = 0.04F;
                    } else if(block == EnMineBlocks.SERPENTINITE_BLOCK.get()){
                        modifier = 0.08F;
                    } else if(block == EnMineBlocks.GNEISS.get()){
                        modifier = 0.1F;
                    } else if(block == EnMineBlocks.KIMBERLITE.get()){
                        modifier = 0.3F;
                    } else if(block == Blocks.REDSTONE_ORE){
                        modifier = -0.12F;
                    } else if(block == Blocks.EMERALD_ORE){
                        modifier = 0.14F;
                    } else if(block == Blocks.COPPER_ORE){
                        modifier = -0.05F;
                    } else if(block == IC2Blocks.TIN_ORE){
                        modifier = -0.1F;
                    } else if(block == IC2Blocks.SILVER_ORE){
                        modifier = 0.2F;
                    } else {
                        modifier = 0F;
                    }

                    localGravity = localGravity + modifier;
                }
            }
        }
        return localGravity;
    }



}