package com.example.enmine.creativetabs;

import com.example.enmine.items.BasicItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class EnMineCreativeModeTab extends CreativeModeTab {
    public static final EnMineCreativeModeTab EN_GEO_CREATIVE_MODE_TAB = new EnMineCreativeModeTab(CreativeModeTab.TABS.length, "enhancedgeology");
    private EnMineCreativeModeTab(int index, String label) {
        super(index, label);
    }

    public @NotNull ItemStack makeIcon() {
        return new ItemStack(BasicItems.ZIRCON.get());
    }
}
