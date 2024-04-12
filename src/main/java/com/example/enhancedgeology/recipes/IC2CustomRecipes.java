package com.example.enhancedgeology.recipes;

import com.example.enhancedgeology.EnhancedGeology;
import com.example.enhancedgeology.items.BasicItems;
import ic2.api.recipes.ingridients.inputs.IInput;
import ic2.api.recipes.ingridients.inputs.ItemInput;
import ic2.api.recipes.ingridients.inputs.ItemTagInput;
import ic2.api.recipes.misc.RecipeMods;
import ic2.api.recipes.registries.IMachineRecipeList;
import ic2.core.IC2;
import ic2.core.block.machines.recipes.misc.EnrichRecipe;
import ic2.core.item.reactor.base.IUraniumRod;
import ic2.core.item.reactor.urantypes.BlazeUranium;
import ic2.core.item.reactor.urantypes.CharcoalUranium;
import ic2.core.item.reactor.urantypes.EnderUranium;
import ic2.core.item.reactor.urantypes.NetherStarUranium;
import ic2.core.item.reactor.urantypes.RedstoneUranium;
import ic2.core.platform.registries.IC2Blocks;
import ic2.core.platform.registries.IC2Items;
import ic2.core.platform.registries.IC2Tags;
import ic2.core.utils.math.ColorUtils;
import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.commands.arguments.ResourceLocationArgument.id;


public class IC2CustomRecipes {

    public static ResourceLocation id(String id){
        return new ResourceLocation(EnhancedGeology.MODID, id);
    }

    public static void init(){
        IC2.RECIPES.get(true).canner.registerListener(r -> {
            List<Tuple<IInput, ItemStack>> addList = new ArrayList<>();
            addList.forEach(t -> {
                r.registerFillable(new ItemStack(IC2Items.CELL_EMPTY), t.getA(), t.getB());
            });
            r.registerFillable(new ItemStack(IC2Items.CELL_EMPTY), new ItemInput(BasicItems.LEUINGOT.get()), new ItemStack(BasicItems.LEUCELL.get()));
            r.registerFillable(new ItemStack(IC2Items.CELL_EMPTY), new ItemInput(BasicItems.HEUINGOT.get()), new ItemStack(BasicItems.HEUCELL.get()));
            r.registerFillable(new ItemStack(IC2Items.CELL_EMPTY), new ItemInput(BasicItems.MGUINGOT.get()), new ItemStack(BasicItems.MGUCELL.get()));
            r.registerFillable(new ItemStack(IC2Items.CELL_EMPTY), new ItemInput(BasicItems.MOXINGOT.get()), new ItemStack(BasicItems.MOXCELL.get()));
        });
        IC2.RECIPES.get(true).compressor.registerListener(r -> {
                r.addSimpleRecipe(id("zircalloyingot"), new ItemStack(BasicItems.ZIRCALLOYPLATE.get()), BasicItems.ZIRCALLOYINGOT.get());
        });
        IC2.RECIPES.get(true).extractor.registerListener(r ->{
            r.addSimpleRecipe(id("leuingot"), new ItemStack(BasicItems.LEUINGOT.get()), new ItemStack(BasicItems.LEUF6.get()));
            r.addSimpleRecipe(id("heuingot"), new ItemStack(BasicItems.HEUINGOT.get()), new ItemStack(BasicItems.HEUF6.get()));
            r.addSimpleRecipe(id("mguingot"), new ItemStack(BasicItems.MGUINGOT.get()), new ItemStack(BasicItems.MGUF6.get()));
        });
    }

    public void onCommonSetup(FMLCommonSetupEvent event) {
        IC2CustomRecipes.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
    }

}


