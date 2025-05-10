package com.shiny1um.shiny1umsmod;

import com.shiny1um.shiny1umsmod.block.ModBlocks;
import com.shiny1um.shiny1umsmod.handler.MagnetEffectHandler;
import com.shiny1um.shiny1umsmod.item.ModItemGroups;
import com.shiny1um.shiny1umsmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Shiny1umsMod implements ModInitializer {
    public static final String MOD_ID = "shiny1ums";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModItemGroups.registerItemGroups();
        MagnetEffectHandler.register();
    }
}