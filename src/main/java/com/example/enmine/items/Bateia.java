package com.example.enmine.items;

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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class Bateia extends Item {
    public Bateia(CreativeModeTab tab) {
        super(new Properties().tab(tab).durability(100).setNoRepair());
    }

    public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        Vec3 playerPosition = player.position();
        double x = playerPosition.x();
        double y = playerPosition.y();
        double z = playerPosition.z();
        if (!level.isClientSide) {
            if (stack.getDamageValue() > 2) {
                if ((x < -2000 || x > 2000) && (z < -2000 || z > 2000)) {
                    BlockPos arbitraryPos = new BlockPos(x, y, z);
                    BlockState blockState = level.getBlockState(arbitraryPos);
                    Block block = blockState.getBlock();
                    if ((level.getBlockState(arbitraryPos).getMaterial() == Material.WATER)
                            && (level.getBlockState(arbitraryPos).getBlock() == Blocks.GRAVEL || level.getBlockState(arbitraryPos).getBlock() == Blocks.SAND) && player.isInWater()) {
                        if (level.getBiome(arbitraryPos) == Biomes.FROZEN_RIVER) {
                            stack.setDamageValue(4);
                        } else if (level.getBiome(arbitraryPos) == Biomes.RIVER) {
                            stack.setDamageValue(2);
                        } else if (stack.getDamageValue() - 10 > 0) {
                            stack.setDamageValue(-4);
                        }
                    }
                }
            } else {
            player.sendSystemMessage(Component.literal(("La bateia è piena!")));
            }
        }
        return super.use(level, player, hand);
    }




    public int getIconFromDamage(int dmg) {
        if (dmg < 25) {
            return 5;
        } else if (dmg < 50 && dmg >= 25) {
            return 6;
        } else if (dmg < 75 && dmg >= 50) {
            return 7;
        }
        return 8;

    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        return super.getCraftingRemainingItem(itemStack);
    }
}
