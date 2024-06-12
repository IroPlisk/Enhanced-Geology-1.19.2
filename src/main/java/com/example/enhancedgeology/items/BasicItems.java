package com.example.enhancedgeology.items;

import com.example.enhancedgeology.EnhancedGeology;
import com.example.enhancedgeology.creativetabs.EnMineCreativeModeTab;
import com.example.enhancedgeology.creativetabs.EnMineRadCreativeModeTab;
import com.example.enhancedgeology.creativetabs.EnMineToolsCreativeModeTab;
import com.example.enhancedgeology.rad.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BasicItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EnhancedGeology.MODID);



    // minerali finali
    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
            () -> new Item(new Item.Properties().tab(EnMineCreativeModeTab.EN_GEO_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> BIOTITE = ITEMS.register("biotite",
            () -> new Item(new Item.Properties().tab(EnMineCreativeModeTab.EN_GEO_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> MUSCOVITE = ITEMS.register("muscovite",
            () -> new Item(new Item.Properties().tab(EnMineCreativeModeTab.EN_GEO_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> FELDSPAR = ITEMS.register("feldspar",
            () -> new Item(new Item.Properties().tab(EnMineCreativeModeTab.EN_GEO_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> MAGNETITE = ITEMS.register("magnetite",
            () -> new Item(new Item.Properties().tab(EnMineCreativeModeTab.EN_GEO_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> EMATITE = ITEMS.register("ematite",
            () -> new Item(new Item.Properties().tab(EnMineCreativeModeTab.EN_GEO_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> SERPENTINE = ITEMS.register("serpentine",
            () -> new Item(new Item.Properties().tab(EnMineCreativeModeTab.EN_GEO_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> CHRYSOTILE = ITEMS.register("chrysotile",
            () -> new Item(new Item.Properties().tab(EnMineCreativeModeTab.EN_GEO_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> ORNE_BLENDE = ITEMS.register("orneblende",
            () -> new Item(new Item.Properties().tab(EnMineCreativeModeTab.EN_GEO_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> BRUCITE = ITEMS.register("brucite",
            () -> new Item(new Item.Properties().tab(EnMineCreativeModeTab.EN_GEO_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> FLUORITE = ITEMS.register("fluorite",
            () -> new Item(new Item.Properties().tab(EnMineCreativeModeTab.EN_GEO_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> UO = ITEMS.register("uo",
            () -> new Item(new Item.Properties().tab(EnMineCreativeModeTab.EN_GEO_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> IRIDIUM_NUGGET = ITEMS.register("iridium_nugget",
            () -> new Item(new Item.Properties().tab(EnMineCreativeModeTab.EN_GEO_CREATIVE_MODE_TAB)));

    // roba elettrica vvv

    public static final RegistryObject<Item> SDS = ITEMS.register("sds",
            () -> new SDSdrill(EnMineToolsCreativeModeTab.EN_GEO_TOOLS_CREATIVE_MODE_TAB));
    public static final RegistryObject<Item> HDRILL = ITEMS.register("hdrill",
            () -> new HDrill(EnMineToolsCreativeModeTab.EN_GEO_TOOLS_CREATIVE_MODE_TAB));
    public static final RegistryObject<Item> GEIGER = ITEMS.register("geiger",
            () -> new Geiger(EnMineToolsCreativeModeTab.EN_GEO_TOOLS_CREATIVE_MODE_TAB));
    public static final RegistryObject<Item> CONDUTTIMETRO = ITEMS.register("conduttimetro",
            () -> new Conduttimetro(EnMineToolsCreativeModeTab.EN_GEO_TOOLS_CREATIVE_MODE_TAB));
    public static final RegistryObject<Item> GRAVIMETRO = ITEMS.register("gravimetro",
            () -> new Gravimetro(EnMineToolsCreativeModeTab.EN_GEO_TOOLS_CREATIVE_MODE_TAB));

    // altri tool
    public static final RegistryObject<Item> BATEIA = ITEMS.register("bateia",
            () -> new Bateia(EnMineToolsCreativeModeTab.EN_GEO_TOOLS_CREATIVE_MODE_TAB));
    public static final RegistryObject<Item> FRANGIVETRO = ITEMS.register("frangivetro",
            () -> new MartelloVetro(Tiers.WOOD, 2, -1f, new Item.Properties().tab(EnMineToolsCreativeModeTab.EN_GEO_TOOLS_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> OXY = ITEMS.register("oxy",
            () -> new OxyFuelTorch(Tiers.WOOD, 7, -1.5f, new Item.Properties().tab(EnMineToolsCreativeModeTab.EN_GEO_TOOLS_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> MARTELLOGEOLOGO = ITEMS.register("martellogeologo",
            () -> new MartelloGeo(Tiers.IRON, 1, -2.8f, new Item.Properties().tab(EnMineToolsCreativeModeTab.EN_GEO_TOOLS_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> TOOLGASDRILL = ITEMS.register("gasdrill",
            () -> new TrapanoBenza(Tiers.IRON, 1, -2.8f, new Item.Properties().tab(EnMineToolsCreativeModeTab.EN_GEO_TOOLS_CREATIVE_MODE_TAB)));

    // Radiologia

    public static final RegistryObject<Item> MOXCELL = ITEMS.register("moxcell",
            () -> new MoxCell(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB));
    public static final RegistryObject<Item> MOXCELL2 = ITEMS.register("moxcell2",
            () -> new MoxCell2(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB));
    public static final RegistryObject<Item> MOXCELL4 = ITEMS.register("moxcell4",
            () -> new MoxCell4(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB));

    public static final RegistryObject<Item> HEUCELL = ITEMS.register("heucell",
            () -> new HEUCell(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB));
    public static final RegistryObject<Item> HEUCELL2 = ITEMS.register("heucell2",
            () -> new HEUCell2(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB));
    public static final RegistryObject<Item> HEUCELL4 = ITEMS.register("heucell4",
            () -> new HEUCell4(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB));

    public static final RegistryObject<Item> LEUCELL = ITEMS.register("leucell",
            () -> new LEUCell(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB));
    public static final RegistryObject<Item> LEUCELL2 = ITEMS.register("leucell2",
            () -> new LEUCell2(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB));
    public static final RegistryObject<Item> LEUCELL4 = ITEMS.register("leucell4",
            () -> new LEUCell4(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB));

    public static final RegistryObject<Item> MGUCELL = ITEMS.register("mgucell",
            () -> new MGUCell(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB));
    public static final RegistryObject<Item> MGUCELL2 = ITEMS.register("mgucell2",
            () -> new MGUCell2(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB));
    public static final RegistryObject<Item> MGUCELL4 = ITEMS.register("mgucell4",
            () -> new MGUCell4(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB));

    // celle
    public static final RegistryObject<Item> ACETYLENE = ITEMS.register("acetylene",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> LIQUIDOXYGENCELL = ITEMS.register("liquidoxygencell",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> OXYGENCELL = ITEMS.register("oxygencell",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> GASOLINE = ITEMS.register("gasoline",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> FLUORINE = ITEMS.register("fluorine",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> UO2 = ITEMS.register("uo2",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> UF6 = ITEMS.register("uf6",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> LEUF6 = ITEMS.register("leuf6",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> HEUF6 = ITEMS.register("heuf6",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> MGUF6 = ITEMS.register("mguf6",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));


    // lingotti e plate
    public static final RegistryObject<Item> ZIRCALLOYDUST = ITEMS.register("zircalloydust",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> ZIRCALLOYINGOT = ITEMS.register("zircalloyingot",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> ZIRCALLOYPLATE = ITEMS.register("zircalloyplate",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> LEUINGOT = ITEMS.register("leuingot",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> HEUINGOT = ITEMS.register("heuingot",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> MGUINGOT = ITEMS.register("mguingot",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> DURALUMIN = ITEMS.register("duralumin",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> MOXINGOT = ITEMS.register("moxingot",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> IRONORESCRAPS = ITEMS.register("ironorescraps",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> COPPERSULFATEDUST = ITEMS.register("coppersulfatedust",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> COPPER2OXIDEDUST = ITEMS.register("copper2oxidedust",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> ALLOYMIXTURE2014 = ITEMS.register("alloymixture2014",
            () -> new Item(new Item.Properties().tab(EnMineRadCreativeModeTab.EN_GEO_RAD_CREATIVE_MODE_TAB)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
