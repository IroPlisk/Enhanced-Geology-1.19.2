package com.example.enhancedgeology.items;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Bateia extends Item {

    private int antispam = 0;
    public Bateia(CreativeModeTab tab) {
        super(new Properties().tab(tab).durability(100).setNoRepair());
    }

    public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        Vec3 playerPosition = player.position();
        double x = playerPosition.x();
        double y = playerPosition.y();
        double z = playerPosition.z();
        Random rand = new Random();
        BlockPos arbitraryPos = new BlockPos(x, y, z);
        if (!level.isClientSide) {
            if (stack.getDamageValue() <= 100) {
                if ((x < -2000 || x > 2000) && (z < -2000 || z > 2000)) {
                    if ((player.isInWater()) && hasBlockNearby(player, level) && !player.isShiftKeyDown()) {
                        if (level.getBiome(arbitraryPos).is(Biomes.FROZEN_RIVER)) {
                            stack.setDamageValue(stack.getDamageValue() + 4);
                        } else if (level.getBiome(arbitraryPos).is(Biomes.RIVER)) {
                            stack.setDamageValue(stack.getDamageValue() + 2);
                        }
                    }
                }
            } else {
                player.sendSystemMessage(Component.literal(("La bateia è piena!")));
            }
            if (player.isShiftKeyDown() && stack.getDamageValue() >= 100) {
                stack.setDamageValue(-stack.getDamageValue());
                ItemStack gold = new ItemStack(Items.GOLD_NUGGET);
                gold.setCount(rand.nextInt(1, 5));
                player.drop(gold, true);
                antispam++;
            }
            if (antispam == 7) {
                stack.setCount(0);
            }

        }
        return super.use(level, player, hand);
    }


    private boolean hasBlockNearby(Player player, Level level){
        return level.getBlockStates(player.getBoundingBox().inflate(2))
                .filter(state ->  state.is(Blocks.GRAVEL) || state.is(Blocks.SAND)).toArray().length > 0;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        return super.getCraftingRemainingItem(itemStack);
    }




}
