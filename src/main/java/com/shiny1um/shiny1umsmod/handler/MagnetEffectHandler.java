package com.shiny1um.shiny1umsmod.handler;

import com.shiny1um.shiny1umsmod.item.custom.MagnetItem;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class MagnetEffectHandler {

    private static final double RADIUS = 10.0;
    private static final double SPEED = 0.4;

    public static void register() {
        ServerTickEvents.END_WORLD_TICK.register(MagnetEffectHandler::onTick);
    }

    private static void onTick(World world) {
        for (PlayerEntity player : world.getPlayers()) {
            if (!(player instanceof ServerPlayerEntity serverPlayer)) continue;

            if (!MagnetItem.isMagnetOn(player)) continue;

            boolean hasMagnet = serverPlayer.getInventory().main.stream()
                    .anyMatch(stack -> stack.getItem() instanceof MagnetItem)
                    || serverPlayer.getInventory().offHand.stream()
                    .anyMatch(stack -> stack.getItem() instanceof MagnetItem);


            if (!hasMagnet) continue;

            List<ItemEntity> items = world.getEntitiesByClass(ItemEntity.class,
                    player.getBoundingBox().expand(RADIUS), item -> !item.cannotPickup());

            for (ItemEntity item : items) {
                Vec3d direction = player.getPos().add(0, 0, 0).subtract(item.getPos()).normalize();
                item.setVelocity(item.getVelocity().add(direction.multiply(SPEED)));
                item.velocityModified = true;
            }
        }
    }
}
