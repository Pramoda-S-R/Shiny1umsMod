package com.shiny1um.shiny1umsmod.item;

import com.shiny1um.shiny1umsmod.Shiny1umsMod;
import com.shiny1um.shiny1umsmod.item.custom.MagnetItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item MAGNET = registerItem("magnet", new MagnetItem(new Item.Settings().maxCount(1)));
    public static final Item CHEST_MOVER = registerItem("chest_mover", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Shiny1umsMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Shiny1umsMod.LOGGER.info("Registering Mod Items for " + Shiny1umsMod.MOD_ID);

    }
}
