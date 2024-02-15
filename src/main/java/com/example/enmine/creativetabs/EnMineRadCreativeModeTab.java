package com.example.enmine.creativetabs;

import com.example.enmine.items.BasicItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class EnMineRadCreativeModeTab extends CreativeModeTab {
    public static final EnMineRadCreativeModeTab EN_GEO_RAD_CREATIVE_MODE_TAB = new EnMineRadCreativeModeTab(CreativeModeTab.TABS.length, "enhancedgeology_rad");
    private EnMineRadCreativeModeTab(int index, String label) {
        super(index, label);
    }

    public @NotNull ItemStack makeIcon() {
        return new ItemStack(BasicItems.MOXCELL.get());
    }
}
