package com.shiny1um.shiny1umsmod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.WeakHashMap;

public class MagnetItem extends Item {

    // Track magnet toggle state per player
    private static final WeakHashMap<PlayerEntity, Boolean> magnetStates = new WeakHashMap<>();

    public MagnetItem(Settings settings) {
        super(settings);
    }

    public static boolean isMagnetOn(PlayerEntity player) {
        return magnetStates.getOrDefault(player, false);
    }

    public static void toggleMagnet(PlayerEntity player) {
        boolean current = isMagnetOn(player);
        magnetStates.put(player, !current);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            toggleMagnet(player);
            boolean state = isMagnetOn(player);
            player.sendMessage(state ?
                    Text.of("Magnet ON") : Text.of("Magnet OFF"), true);
            world.playSound(null, player.getBlockPos(),
                    state ? SoundEvents.BLOCK_BEACON_ACTIVATE : SoundEvents.BLOCK_BEACON_DEACTIVATE,
                    SoundCategory.PLAYERS, 0.5F, 1.0F);
        }
        return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
    }
}
