package com.mango.verticalslabs;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class VerticalSlabsBlocks {
    public static final VerticalSlabBlock WOODEN_VERTICAL_SLAB = new VerticalSlabBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f));

    public static void RegisterBlocks() {
        Registry.register(Registry.BLOCK, new Identifier("verticalslabs", "wooden_vertical_slab"), WOODEN_VERTICAL_SLAB);
        Registry.register(Registry.ITEM, new Identifier("verticalslabs", "wooden_vertical_slab"), new BlockItem(WOODEN_VERTICAL_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
    }
}
