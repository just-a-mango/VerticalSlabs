package com.mango.verticalslabs;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class VerticalSlabsItems {
    public static final WrenchItem WRENCH_ITEM = new WrenchItem(new FabricItemSettings().group(ItemGroup.TOOLS).maxCount(1).maxDamage(50));

    public static void RegisterItems() {
        Registry.register(Registry.ITEM, new Identifier("verticalslabs", "wrench_item"), WRENCH_ITEM);
    }
}
