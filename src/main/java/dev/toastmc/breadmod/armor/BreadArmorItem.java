package dev.toastmc.breadmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

public class BreadArmorItem extends ArmorItem {

    public BreadArmorItem(ArmorMaterial material, EquipmentSlot slot, Item.Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        // Only server thread. Only living entities. Exclude creative, spectator or peaceful players
        if (world.isClient() || !(entity instanceof LivingEntity) || !EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(entity)) {
            return;
        }

        // Ensure the item is equipped
        equipped:
        {
            for (ItemStack itemStack : entity.getItemsEquipped()) {
                if (itemStack == stack) {
                    break equipped;
                }
            }

            return;
        }

        if (world.random.nextFloat() < calculateChance(entity)) {
            // Wear durability
            if (entity instanceof ServerPlayerEntity) {
                stack.damage(1, world.random, (ServerPlayerEntity) entity);
            } else {
                stack.damage(1, (LivingEntity) entity, livingEntity -> {
                });
            }

            // 50% chance
            if (world.random.nextBoolean()) {
                // Strength II, Nausea II
                // Basically you're drunk
                ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 500, 1));
                ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 350, 1));
            }
        }
    }

    private static float calculateChance(Entity entity) {
        float chance = 0.25F / 100 / 20; // 0.25% chance per second

        if (entity.isWet()) {
            chance *= 10; // 10 times more likely in water
        }

        if (entity.isOnFire()) {
            chance /= 4; // Intense temperature slows down yeast
        }

//        if (entity.getWorld().getDimensionEntry().value().ultrawarm()) {
//            chance /= 2; // Intense temperature slows down yeast
//        }

        return chance;
    }
}
