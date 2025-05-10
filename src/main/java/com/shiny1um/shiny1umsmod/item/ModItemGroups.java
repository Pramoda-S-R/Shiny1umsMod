package com.shiny1um.shiny1umsmod.item;

import com.shiny1um.shiny1umsmod.Shiny1umsMod;
import com.shiny1um.shiny1umsmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup SHINY1UMS_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Shiny1umsMod.MOD_ID, "shin1yums_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.TV))
                    .displayName(Text.translatable("itemgroup.shiny1ums.shiny1ums_items"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.MAGNET);
                        entries.add(ModItems.CHEST_MOVER);
                        entries.add(ModBlocks.TV);
                    })).build());

    public static void registerItemGroups() {
        Shiny1umsMod.LOGGER.info("Registering Item Groups for " + Shiny1umsMod.MOD_ID);
    }
}
