package com.example.enmine.creativetabs;

import com.example.enmine.items.BasicItems;
import com.example.enmine.items.SDSdrill;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class EnMineToolsCreativeModeTab extends CreativeModeTab {
    public static final EnMineToolsCreativeModeTab EN_GEO_TOOLS_CREATIVE_MODE_TAB = new EnMineToolsCreativeModeTab(CreativeModeTab.TABS.length, "enhancedgeology_tools");
    private EnMineToolsCreativeModeTab(int index, String label) {
        super(index, label);
    }

    public @NotNull ItemStack makeIcon() {
        return new ItemStack(BasicItems.SDS.get());
    }
}
